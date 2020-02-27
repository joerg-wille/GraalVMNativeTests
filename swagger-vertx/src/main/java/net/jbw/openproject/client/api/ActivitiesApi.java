package net.jbw.openproject.client.api;

import net.jbw.openproject.client.model.InlineObject;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;

import java.util.*;

public interface ActivitiesApi {

    void apiV3ActivitiesIdGet(Integer id, Handler<AsyncResult<Void>> handler);

    void apiV3ActivitiesIdPatch(Integer id, InlineObject body, Handler<AsyncResult<Void>> handler);

}
