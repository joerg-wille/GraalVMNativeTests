package net.jbw.openproject.client.api;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;

import java.util.*;

public interface PreviewingApi {

    void apiV3RenderPlainPost(Handler<AsyncResult<Void>> handler);

    void apiV3RenderTextilePost(String context, Handler<AsyncResult<Void>> handler);

}
