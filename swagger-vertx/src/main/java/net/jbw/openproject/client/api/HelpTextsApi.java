package net.jbw.openproject.client.api;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;

import java.util.*;

public interface HelpTextsApi {

    void apiV3HelpTextsGet(Handler<AsyncResult<Void>> handler);

    void apiV3HelpTextsIdGet(Integer id, Handler<AsyncResult<Void>> handler);

}
