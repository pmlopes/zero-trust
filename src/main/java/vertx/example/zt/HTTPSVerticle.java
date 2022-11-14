package vertx.example.zt;

import io.vertx.core.*;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.eventbus.ReplyException;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.core.net.JksOptions;
import io.vertx.ext.auth.oauth2.OAuth2Options;
import io.vertx.ext.auth.oauth2.providers.GoogleAuth;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.*;
import io.vertx.ext.web.sstore.LocalSessionStore;

import java.util.List;

import static vertx.example.zt.Application.*;

public class HTTPSVerticle extends AbstractVerticle {

  @Override
  public void start(Promise<Void> ready) {

    GoogleAuth.discover(vertx, new OAuth2Options().setClientId(OAUTH2_CLIENT_ID).setClientSecret(OAUTH2_CLIENT_SECRET))
      .compose(oauth2 -> {
        var app = Router.router(vertx);
        // serve the HTML
        app.route()
          .handler(StaticHandler.create());

        // add a session handler
        app.route()
          .handler(SessionHandler
            .create(LocalSessionStore.create(vertx)));

        // refresh users setup
        app.route("/user/refresh")
          // this is a high precedence handler
          .handler(UserSwitchHandler.refresh());

        app.route()
            .handler(ctx -> {
              System.out.println("Browser to Web: \uD83D\uDCE6️-> \uD83D\uDD10 -> \uD83D\uDCE6");
              ctx.next();
            });

        // secure the remaining routes
        app.route("/protected/*")
          // security handler
          .handler(
            OAuth2AuthHandler.create(vertx, oauth2, ORIGIN + "/callback")
              .prompt("login")
              .withScopes(List.of("openid", "email"))
              .setupCallback(app.get("/callback"))
          );

        app.route("/protected/simple")
          .handler(ctx -> {
            vertx.eventBus()
              .<String>request(MicroService.ADDRESS, null, new DeliveryOptions()
                .addHeader("action", "execute")
                .addHeader("auth-token", ctx.user().get("id_token")))
              .compose(msg -> {
                  System.out.println("\uD83C\uDFC6 Microservice call OK!");
                return ctx.response()
                  .putHeader("Content-Type", "text/plain; charset=UTF-8")
                  .end(msg.body());
                })
              .onFailure(ctx::fail);
          });

        app.route("/protected/5secs")
          .handler(ctx -> {
            System.out.println("\uD83D\uDE80 " + ctx.currentRoute().getPath());

            vertx.eventBus()
              .<String>request(MicroService.ADDRESS, null, new DeliveryOptions()
                .addHeader("action", "executeWithin5secs")
                .addHeader("auth-token", ctx.user().get("id_token")))
              .compose(msg -> {
                System.out.println("\uD83C\uDFC6 Microservice call OK!");
                return ctx.response()
                  .putHeader("Content-Type", "text/plain; charset=UTF-8")
                  .end(msg.body());
              })
              .recover(err -> {
                if (err instanceof ReplyException) {
                  if (((ReplyException) err).failureCode() == 401) {
                    System.out.println("\uD83D\uDEA8 request a fresh token");
                    return ctx.redirect("/user/refresh?redirect_uri=/protected/5secs");
                  }
                }
                System.out.println("\uD83C\uDF89 Microservice call FAIL!");
                return Future.failedFuture(err);
              })
              .onFailure(ctx::fail);
          });

        return vertx.createHttpServer(
            new HttpServerOptions()
              .setSsl(true)
              .setKeyStoreOptions(
                new JksOptions()
                  .setPath("https.jks")
                  .setPassword(HTTP_X509_SECRET)))
          .requestHandler(app)
          .listen(PORT)
          .onSuccess(v -> System.out.println("Server listening at: " + ORIGIN));

      })
      .map((Void) null)
      .onComplete(ready);
  }
}
