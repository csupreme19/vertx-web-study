package study.vertxwebstudy;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;

public class MainVerticle extends AbstractVerticle {

  @Override
  public void start() throws Exception {

    Router router = Router.router(vertx);
    router.route().handler(ctx -> {
      HttpServerResponse response = ctx.response();
      response.setChunked(true);
      response.write("hello world!\n");
      response.end();
    });

    vertx.createHttpServer()
      .requestHandler(router)
      .listen(8080);

  }
}


