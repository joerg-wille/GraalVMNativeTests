package net.jbw.openproject.client.api;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;

import java.util.*;

public interface StringObjectsApi {

    void apiV3StringObjectsGet(String value, Handler<AsyncResult<Void>> handler);

}
