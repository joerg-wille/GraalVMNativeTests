package net.jbw.openproject.client.api;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;

import java.util.*;

public interface CustomObjectsApi {

    void apiV3CustomObjectsIdGet(Integer id, Handler<AsyncResult<Void>> handler);

}
