package net.jbw.openproject.client.api;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;

import java.util.*;

public interface RolesApi {

    void apiV3RolesGet(Handler<AsyncResult<Void>> handler);

    void apiV3RolesIdGet(Integer id, Handler<AsyncResult<Void>> handler);

}
