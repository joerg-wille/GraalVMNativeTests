package net.jbw.openproject.client.api;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;

import java.util.*;

public interface PrincipalsApi {

    void apiV3PrincipalsGet(String filters, Handler<AsyncResult<Void>> handler);

}
