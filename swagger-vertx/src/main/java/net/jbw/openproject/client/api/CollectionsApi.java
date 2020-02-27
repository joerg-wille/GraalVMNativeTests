package net.jbw.openproject.client.api;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;

import java.util.*;

public interface CollectionsApi {

    void apiV3ExamplesGet(String groupBy, String showSums, Handler<AsyncResult<Void>> handler);

}
