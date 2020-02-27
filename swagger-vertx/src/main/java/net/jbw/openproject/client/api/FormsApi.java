package net.jbw.openproject.client.api;

import net.jbw.openproject.client.model.InlineObject2;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;

import java.util.*;

public interface FormsApi {

    void apiV3ExampleFormPost(InlineObject2 body, Handler<AsyncResult<Void>> handler);

}
