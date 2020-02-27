package net.jbw.openproject.client.api;

import net.jbw.openproject.client.model.WPType;
import net.jbw.openproject.client.model.WPTypes;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;

import java.util.*;

public interface TypesApi {

    void apiV3ProjectsProjectIdTypesGet(Integer projectId, Handler<AsyncResult<WPTypes>> handler);

    void apiV3TypesGet(Handler<AsyncResult<WPTypes>> handler);

    void apiV3TypesIdGet(Integer id, Handler<AsyncResult<WPType>> handler);

}
