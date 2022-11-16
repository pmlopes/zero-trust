package vertx.example.zt;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.eventbus.EventBusOptions;
import io.vertx.core.net.JksOptions;

import static vertx.example.zt.Application.EVENTBUS_X509_SECRET;

public class Main {

  public static void main(String[] args) {

    // All communications between services should be secured.
    // We can instruct Vert.x to start the eventbus with TLS
    // and use a certificate to secure the channel
    var options = new VertxOptions()
      .setEventBusOptions(
        new EventBusOptions()
          .setSsl(true)
          .setKeyStoreOptions(new JksOptions()
                  .setPath("eventbus.jks")
                  .setPassword(EVENTBUS_X509_SECRET)));

    var vertx = Vertx.vertx(options);

    vertx
      .deployVerticle(new EventBusVerticle())
      .compose(id -> vertx.deployVerticle(new HTTPSVerticle()))
      .onFailure(err -> {
        err.printStackTrace();
        System.exit(1);
      });


    vertx.eventBus().addOutboundInterceptor(dctx -> {
      System.out.println("HTTPS to Microservice: \uD83D\uDCE6️-> \uD83D\uDD10 -> \uD83D\uDCE6");
      dctx.next();
    });
    vertx.eventBus().addInboundInterceptor(dctx -> {
      System.out.println("Microservice to HTTPS: \uD83D\uDCE6️<- \uD83D\uDD10 <- \uD83D\uDCE6");
      dctx.next();
    });
  }

}
