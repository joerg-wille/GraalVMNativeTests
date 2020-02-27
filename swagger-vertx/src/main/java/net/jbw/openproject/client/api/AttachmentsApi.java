package net.jbw.openproject.client.api;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;

import java.util.*;

public interface AttachmentsApi {

    void apiV3AttachmentsIdDelete(Integer id, Handler<AsyncResult<Void>> handler);

    void apiV3AttachmentsIdGet(Integer id, Handler<AsyncResult<Void>> handler);

    void apiV3WorkPackagesIdAttachmentsGet(Integer id, Handler<AsyncResult<Void>> handler);

    void apiV3WorkPackagesIdAttachmentsPost(Integer id, Handler<AsyncResult<Void>> handler);

}
