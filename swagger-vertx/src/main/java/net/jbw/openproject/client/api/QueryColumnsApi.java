package net.jbw.openproject.client.api;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;

import java.util.*;

public interface QueryColumnsApi {

    void apiV3QueriesColumnsIdGet(String id, Handler<AsyncResult<Void>> handler);

}
