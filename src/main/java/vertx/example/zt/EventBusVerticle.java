package vertx.example.zt;

import io.vertx.core.*;
import io.vertx.core.eventbus.ReplyException;
import io.vertx.core.eventbus.ReplyFailure;
import io.vertx.ext.auth.User;
import io.vertx.ext.auth.oauth2.OAuth2Options;
import io.vertx.ext.auth.oauth2.providers.GoogleAuth;
import io.vertx.serviceproxy.AuthenticationInterceptor;
import io.vertx.serviceproxy.ServiceBinder;
import io.vertx.serviceproxy.ServiceInterceptor;
import vertx.example.zt.impl.MicroServiceImpl;

import static vertx.example.zt.Application.*;

public class EventBusVerticle extends AbstractVerticle {

  @Override
  public void start(Promise<Void> ready) {

    // TODO: providers should tag the user object with a unique name
    GoogleAuth.discover(vertx, new OAuth2Options().setClientId(OAUTH2_CLIENT_ID).setClientSecret(OAUTH2_CLIENT_SECRET))
      .onSuccess(oauth2 -> {
        MicroService service = new MicroServiceImpl();

        // Register the handler
        new ServiceBinder(vertx)
          .setAddress(MicroService.ADDRESS)
          // Secure the messages in transit
          .addInterceptor(AuthenticationInterceptor.create(oauth2))
          // Add more specific interceptors
          .addInterceptor("executeWithin5secs", Require.authnWithIn(5))
          // Finally allow executing "our" business logic
          .register(MicroService.class, service);
      })
      .map((Void) null)
      .onComplete(ready);
  }
}

class Require {
  static ServiceInterceptor authnWithIn(int secs) {
    return (vertx, ctx, body) ->  {
      try {
        User user = (User) ctx.get("user");
        // User must not be expired
        if (user != null && !user.expired()) {
          int now = (int) (System.currentTimeMillis() / 1000L);
          Integer iat = user.get("iat");
          // issue at must be in the past
          if (iat != null && now - iat < secs) {
            return Future.succeededFuture(body);
          }
        }
        return Future.failedFuture(new ReplyException(ReplyFailure.RECIPIENT_FAILURE, 401, "authentication_required"));
      } catch (RuntimeException e) {
        return Future.failedFuture(new ReplyException(ReplyFailure.ERROR, 500, e.getMessage()));
      }
    };
  }
}
