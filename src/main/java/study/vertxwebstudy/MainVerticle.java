package study.vertxwebstudy;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;

public class MainVerticle extends AbstractVerticle {

  @Override
  public void start() throws Exception {

    Router router = Router.router(vertx);
    Route route = router.route();

    route.handler(ctx -> {
      HttpServerResponse response = ctx.response();
      response.setChunked(true);
      response.write("hello world!\n");

      ctx.vertx().setTimer(3000, tid -> {
        ctx.next();
      });
    }).handler(ctx -> {
      HttpServerResponse response = ctx.response();
      response.write("such a beautiful world.\n");

      ctx.vertx().setTimer(3000, tid -> {
        ctx.next();
      });
    }).handler(ctx -> {
      HttpServerResponse response = ctx.response();
      response.write("bye world!\n");
      response.end();
    });

    vertx.createHttpServer()
      .requestHandler(router)
      .listen(8080);

  }
}


