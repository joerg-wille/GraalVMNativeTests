package net.jbw.openproject.client.api;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;

import java.util.*;

public interface SchemasApi {

    void apiV3ExampleSchemaGet(Handler<AsyncResult<Void>> handler);

}
