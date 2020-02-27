package net.jbw.openproject.client.api;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;

import java.util.*;

public interface QueryOperatorsApi {

    void apiV3QueriesOperatorsIdGet(String id, Handler<AsyncResult<Void>> handler);

}
