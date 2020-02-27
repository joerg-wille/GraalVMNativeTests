package net.jbw.openproject.client.api;

import net.jbw.openproject.client.model.InlineObject3;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;

import java.util.*;

public interface QueriesApi {

    void apiV3ProjectsIdQueriesDefaultGet(Integer id, String filters, Integer offset, Integer pageSize, String sortBy, String groupBy, Boolean showSums, Boolean timelineVisible, Boolean showHierarchies, Handler<AsyncResult<Void>> handler);

    void apiV3ProjectsIdQueriesSchemaGet(Long id, Handler<AsyncResult<Void>> handler);

    void apiV3QueriesAvailableProjectsGet(Handler<AsyncResult<Void>> handler);

    void apiV3QueriesDefaultGet(String filters, Integer offset, Integer pageSize, String sortBy, String groupBy, Boolean showSums, Boolean timelineVisible, String timelineZoomLevel, Boolean showHierarchies, Handler<AsyncResult<Void>> handler);

    void apiV3QueriesFormPost(Handler<AsyncResult<Void>> handler);

    void apiV3QueriesGet(String filters, Handler<AsyncResult<Void>> handler);

    void apiV3QueriesIdDelete(Integer id, Handler<AsyncResult<Void>> handler);

    void apiV3QueriesIdGet(Integer id, String filters, Integer offset, Integer pageSize, String sortBy, String groupBy, Boolean showSums, Boolean timelineVisible, String timelineLabels, Boolean showHierarchies, Handler<AsyncResult<Void>> handler);

    void apiV3QueriesIdPatch(Integer id, InlineObject3 body, Handler<AsyncResult<Void>> handler);

    void apiV3QueriesIdStarPatch(Integer id, Handler<AsyncResult<Void>> handler);

    void apiV3QueriesIdUnstarPatch(Integer id, Handler<AsyncResult<Void>> handler);

    void apiV3QueriesPost(Handler<AsyncResult<Void>> handler);

    void apiV3QueriesSchemaGet(Handler<AsyncResult<Void>> handler);

}
