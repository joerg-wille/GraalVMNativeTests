package net.jbw.openproject.client.api;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;

import java.util.*;

public interface RelationsApi {

    void apiV3RelationsGet(String filters, String sortBy, Handler<AsyncResult<Void>> handler);

    void apiV3RelationsIdDelete(Integer id, Handler<AsyncResult<Void>> handler);

    void apiV3RelationsIdFormPost(Integer id, Handler<AsyncResult<Void>> handler);

    void apiV3RelationsIdGet(Integer id, Handler<AsyncResult<Void>> handler);

    void apiV3RelationsIdPatch(Integer id, Handler<AsyncResult<Void>> handler);

    void apiV3RelationsSchemaGet(Handler<AsyncResult<Void>> handler);

    void apiV3RelationsSchemaTypeGet(String type, Handler<AsyncResult<Void>> handler);

}
