package net.jbw.openproject.client.api;

import net.jbw.openproject.client.model.InlineObject1;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;

import java.util.*;

public interface CustomActionsApi {

    void apiV3CustomActionsCustomActionIdExecutePost(Integer customActionId, InlineObject1 body, Handler<AsyncResult<Void>> handler);

    void apiV3CustomActionsCustomActionIdGet(Integer customActionId, Handler<AsyncResult<Void>> handler);

}
