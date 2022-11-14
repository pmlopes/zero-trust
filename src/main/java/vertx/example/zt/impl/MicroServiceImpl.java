package vertx.example.zt.impl;

import io.vertx.core.Future;
import vertx.example.zt.MicroService;

public class MicroServiceImpl implements MicroService {

  private static final String BANNER = """
        ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄
        █░░░░░░░░▀█▄▀▄▀██████░▀█▄▀▄▀██████
        ░░░░ ░░░░░░░▀█▄█▄███▀░░░ ▀█▄█▄███

        """;

  @Override
  public Future<String> execute() {
    return Future.succeededFuture(BANNER + "Zero Trust is Awesome!");
  }

  @Override
  public Future<String> executeWithin5secs() {
    return Future.succeededFuture(BANNER + "Zero Trust is Awesome! (5s Fresh Token)");
  }
}
