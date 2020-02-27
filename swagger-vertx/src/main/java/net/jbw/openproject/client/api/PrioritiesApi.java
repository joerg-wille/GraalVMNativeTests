package net.jbw.openproject.client.api;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;

import java.util.*;

public interface PrioritiesApi {

    void apiV3PrioritiesGet(Handler<AsyncResult<Void>> handler);

    void apiV3PrioritiesIdGet(Integer id, Handler<AsyncResult<Void>> handler);

}
