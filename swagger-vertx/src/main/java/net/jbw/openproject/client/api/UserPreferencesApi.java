package net.jbw.openproject.client.api;

import net.jbw.openproject.client.model.InlineObject4;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;

import java.util.*;

public interface UserPreferencesApi {

    void apiV3MyPreferencesGet(Handler<AsyncResult<Void>> handler);

    void apiV3MyPreferencesPatch(InlineObject4 body, Handler<AsyncResult<Void>> handler);

}
