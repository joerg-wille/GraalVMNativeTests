package net.jbw.openproject.client.api;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;

import java.util.*;

public interface StatusesApi {

    void apiV3StatusesGet(Handler<AsyncResult<Void>> handler);

    void apiV3StatusesIdGet(Integer id, Handler<AsyncResult<Void>> handler);

}
