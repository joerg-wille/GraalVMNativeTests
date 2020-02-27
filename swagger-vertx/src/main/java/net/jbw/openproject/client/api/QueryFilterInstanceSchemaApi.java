package net.jbw.openproject.client.api;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;

import java.util.*;

public interface QueryFilterInstanceSchemaApi {

    void apiV3ProjectsIdQueriesFilterInstanceSchemasGet(Integer id, Handler<AsyncResult<Void>> handler);

    void apiV3QueriesFilterInstanceSchemasGet(Handler<AsyncResult<Void>> handler);

    void apiV3QueriesFilterInstanceSchemasIdentifierGet(String identifier, Handler<AsyncResult<Void>> handler);

}
