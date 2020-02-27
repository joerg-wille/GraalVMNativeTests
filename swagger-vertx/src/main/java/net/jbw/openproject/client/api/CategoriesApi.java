package net.jbw.openproject.client.api;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;

import java.util.*;

public interface CategoriesApi {

    void apiV3CategoriesIdGet(Integer id, Handler<AsyncResult<Void>> handler);

    void apiV3ProjectsProjectIdCategoriesGet(Integer projectId, Handler<AsyncResult<Void>> handler);

}
