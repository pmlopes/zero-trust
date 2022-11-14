package vertx.example.zt;

import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.core.*;

@ProxyGen
public interface MicroService {

  String ADDRESS = MicroService.class.getName();

  Future<String> execute();

  Future<String> executeWithin5secs();

}
