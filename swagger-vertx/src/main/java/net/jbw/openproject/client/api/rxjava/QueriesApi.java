package net.jbw.openproject.client.api.rxjava;

import net.jbw.openproject.client.model.InlineObject3;

import java.util.*;

import rx.Single;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;


public class QueriesApi {

	private final net.jbw.openproject.client.api.QueriesApi delegate;

	public QueriesApi(net.jbw.openproject.client.api.QueriesApi delegate) {
	    this.delegate = delegate;
    }

	public net.jbw.openproject.client.api.QueriesApi getDelegate() {
	    return delegate;
	}

    /**
     * View default query for project
     * Same as [viewing an existing, persisted Query](#queries-query-get) in its response, this resource returns an unpersisted query and by that allows to get the default query configuration. The client may also provide additional parameters which will modify the default query. The query will already be scoped for the project.
     * @param id Id of the project the default query is requested for (required)
     * @param filters JSON specifying filter conditions. The filters provided as parameters are not applied to the query but are instead used to override the query&#39;s persisted filters. All filters also accepted by the work packages endpoint are accepted. (optional)
     * @param offset Page number inside the queries&#39; result collection of work packages. (optional, default to 1)
     * @param pageSize Number of elements to display per page for the queries&#39; result collection of work packages. (optional)
     * @param sortBy JSON specifying sort criteria. The sort criteria is applied to the querie&#39;s result collection of work packages overriding the query&#39;s persisted sort criteria. (optional)
     * @param groupBy The column to group by. The grouping criteria is applied to the to the querie&#39;s result collection of work packages overriding the query&#39;s persisted group criteria. (optional)
     * @param showSums Indicates whether properties should be summed up if they support it. The showSums parameter is applied to the to the querie&#39;s result collection of work packages overriding the query&#39;s persisted sums property. (optional, default to false)
     * @param timelineVisible Indicates whether the timeline should be shown. (optional, default to false)
     * @param showHierarchies Indicates whether the hierarchy mode should be enabled. (optional, default to true)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3ProjectsIdQueriesDefaultGet(Integer id, String filters, Integer offset, Integer pageSize, String sortBy, String groupBy, Boolean showSums, Boolean timelineVisible, Boolean showHierarchies, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3ProjectsIdQueriesDefaultGet(id, filters, offset, pageSize, sortBy, groupBy, showSums, timelineVisible, showHierarchies, resultHandler);
    }

    /**
     * View default query for project
     * Same as [viewing an existing, persisted Query](#queries-query-get) in its response, this resource returns an unpersisted query and by that allows to get the default query configuration. The client may also provide additional parameters which will modify the default query. The query will already be scoped for the project.
     * @param id Id of the project the default query is requested for (required)
     * @param filters JSON specifying filter conditions. The filters provided as parameters are not applied to the query but are instead used to override the query&#39;s persisted filters. All filters also accepted by the work packages endpoint are accepted. (optional)
     * @param offset Page number inside the queries&#39; result collection of work packages. (optional, default to 1)
     * @param pageSize Number of elements to display per page for the queries&#39; result collection of work packages. (optional)
     * @param sortBy JSON specifying sort criteria. The sort criteria is applied to the querie&#39;s result collection of work packages overriding the query&#39;s persisted sort criteria. (optional)
     * @param groupBy The column to group by. The grouping criteria is applied to the to the querie&#39;s result collection of work packages overriding the query&#39;s persisted group criteria. (optional)
     * @param showSums Indicates whether properties should be summed up if they support it. The showSums parameter is applied to the to the querie&#39;s result collection of work packages overriding the query&#39;s persisted sums property. (optional, default to false)
     * @param timelineVisible Indicates whether the timeline should be shown. (optional, default to false)
     * @param showHierarchies Indicates whether the hierarchy mode should be enabled. (optional, default to true)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3ProjectsIdQueriesDefaultGet(Integer id, String filters, Integer offset, Integer pageSize, String sortBy, String groupBy, Boolean showSums, Boolean timelineVisible, Boolean showHierarchies) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3ProjectsIdQueriesDefaultGet(id, filters, offset, pageSize, sortBy, groupBy, showSums, timelineVisible, showHierarchies, fut);
        }));
    }
    /**
     * View schema for project queries
     * Retrieve the schema for project queries.
     * @param id ID of project to return (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3ProjectsIdQueriesSchemaGet(Long id, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3ProjectsIdQueriesSchemaGet(id, resultHandler);
    }

    /**
     * View schema for project queries
     * Retrieve the schema for project queries.
     * @param id ID of project to return (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3ProjectsIdQueriesSchemaGet(Long id) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3ProjectsIdQueriesSchemaGet(id, fut);
        }));
    }
    /**
     * Available projects
     * Gets a list of projects that are available as projects a query can be assigned to.
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3QueriesAvailableProjectsGet(Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3QueriesAvailableProjectsGet(resultHandler);
    }

    /**
     * Available projects
     * Gets a list of projects that are available as projects a query can be assigned to.
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3QueriesAvailableProjectsGet() {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3QueriesAvailableProjectsGet(fut);
        }));
    }
    /**
     * View default query
     * Same as [viewing an existing, persisted Query](#queries-query-get) in its response, this resource returns an unpersisted query and by that allows to get the default query configuration. The client may also provide additional parameters which will modify the default query.
     * @param filters JSON specifying filter conditions. The filters provided as parameters are not applied to the query but are instead used to override the query&#39;s persisted filters. All filters also accepted by the work packages endpoint are accepted. (optional)
     * @param offset Page number inside the queries&#39; result collection of work packages. (optional, default to 1)
     * @param pageSize Number of elements to display per page for the queries&#39; result collection of work packages. (optional)
     * @param sortBy JSON specifying sort criteria. The sort criteria is applied to the querie&#39;s result collection of work packages overriding the query&#39;s persisted sort criteria. (optional)
     * @param groupBy The column to group by. The grouping criteria is applied to the to the querie&#39;s result collection of work packages overriding the query&#39;s persisted group criteria. (optional)
     * @param showSums Indicates whether properties should be summed up if they support it. The showSums parameter is applied to the to the querie&#39;s result collection of work packages overriding the query&#39;s persisted sums property. (optional, default to false)
     * @param timelineVisible Indicates whether the timeline should be shown. (optional, default to false)
     * @param timelineZoomLevel Indicates in what zoom level the timeline should be shown. Valid values are  &#x60;days&#x60;, &#x60;weeks&#x60;, &#x60;months&#x60;, &#x60;quarters&#x60;, and &#x60;years&#x60;. (optional, default to &quot;days&quot;)
     * @param showHierarchies Indicates whether the hierarchy mode should be enabled. (optional, default to true)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3QueriesDefaultGet(String filters, Integer offset, Integer pageSize, String sortBy, String groupBy, Boolean showSums, Boolean timelineVisible, String timelineZoomLevel, Boolean showHierarchies, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3QueriesDefaultGet(filters, offset, pageSize, sortBy, groupBy, showSums, timelineVisible, timelineZoomLevel, showHierarchies, resultHandler);
    }

    /**
     * View default query
     * Same as [viewing an existing, persisted Query](#queries-query-get) in its response, this resource returns an unpersisted query and by that allows to get the default query configuration. The client may also provide additional parameters which will modify the default query.
     * @param filters JSON specifying filter conditions. The filters provided as parameters are not applied to the query but are instead used to override the query&#39;s persisted filters. All filters also accepted by the work packages endpoint are accepted. (optional)
     * @param offset Page number inside the queries&#39; result collection of work packages. (optional, default to 1)
     * @param pageSize Number of elements to display per page for the queries&#39; result collection of work packages. (optional)
     * @param sortBy JSON specifying sort criteria. The sort criteria is applied to the querie&#39;s result collection of work packages overriding the query&#39;s persisted sort criteria. (optional)
     * @param groupBy The column to group by. The grouping criteria is applied to the to the querie&#39;s result collection of work packages overriding the query&#39;s persisted group criteria. (optional)
     * @param showSums Indicates whether properties should be summed up if they support it. The showSums parameter is applied to the to the querie&#39;s result collection of work packages overriding the query&#39;s persisted sums property. (optional, default to false)
     * @param timelineVisible Indicates whether the timeline should be shown. (optional, default to false)
     * @param timelineZoomLevel Indicates in what zoom level the timeline should be shown. Valid values are  &#x60;days&#x60;, &#x60;weeks&#x60;, &#x60;months&#x60;, &#x60;quarters&#x60;, and &#x60;years&#x60;. (optional, default to &quot;days&quot;)
     * @param showHierarchies Indicates whether the hierarchy mode should be enabled. (optional, default to true)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3QueriesDefaultGet(String filters, Integer offset, Integer pageSize, String sortBy, String groupBy, Boolean showSums, Boolean timelineVisible, String timelineZoomLevel, Boolean showHierarchies) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3QueriesDefaultGet(filters, offset, pageSize, sortBy, groupBy, showSums, timelineVisible, timelineZoomLevel, showHierarchies, fut);
        }));
    }
    /**
     * Query Create Form
     * 
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3QueriesFormPost(Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3QueriesFormPost(resultHandler);
    }

    /**
     * Query Create Form
     * 
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3QueriesFormPost() {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3QueriesFormPost(fut);
        }));
    }
    /**
     * List queries
     * Returns a collection of queries. The collection can be filtered via query parameters similar to how work packages are filtered. Please note however, that the filters are applied to the queries and not to the work packages the queries in turn might return.
     * @param filters JSON specifying filter conditions. Accepts the same format as returned by the [queries](#queries) endpoint. Currently supported filters are:  + project: filters queries by the project they are assigned to. If the project filter is passed with the &#x60;!*&#x60; (not any) operator, global queries are returned. (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3QueriesGet(String filters, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3QueriesGet(filters, resultHandler);
    }

    /**
     * List queries
     * Returns a collection of queries. The collection can be filtered via query parameters similar to how work packages are filtered. Please note however, that the filters are applied to the queries and not to the work packages the queries in turn might return.
     * @param filters JSON specifying filter conditions. Accepts the same format as returned by the [queries](#queries) endpoint. Currently supported filters are:  + project: filters queries by the project they are assigned to. If the project filter is passed with the &#x60;!*&#x60; (not any) operator, global queries are returned. (optional)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3QueriesGet(String filters) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3QueriesGet(filters, fut);
        }));
    }
    /**
     * Delete query
     * Delete the query identified by the id parameter
     * @param id Query id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3QueriesIdDelete(Integer id, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3QueriesIdDelete(id, resultHandler);
    }

    /**
     * Delete query
     * Delete the query identified by the id parameter
     * @param id Query id (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3QueriesIdDelete(Integer id) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3QueriesIdDelete(id, fut);
        }));
    }
    /**
     * View query
     * Retreive an individual query as identified by the id parameter. Then end point accepts a number of parameters that can be used to override the resources&#39; persisted parameters.
     * @param id Query id (required)
     * @param filters JSON specifying filter conditions. The filters provided as parameters are not applied to the query but are instead used to override the query&#39;s persisted filters. All filters also accepted by the work packages endpoint are accepted. (optional)
     * @param offset Page number inside the queries&#39; result collection of work packages. (optional, default to 1)
     * @param pageSize Number of elements to display per page for the queries&#39; result collection of work packages. (optional)
     * @param sortBy JSON specifying sort criteria. The sort criteria is applied to the querie&#39;s result collection of work packages overriding the query&#39;s persisted sort criteria. (optional)
     * @param groupBy The column to group by. The grouping criteria is applied to the to the querie&#39;s result collection of work packages overriding the query&#39;s persisted group criteria. (optional)
     * @param showSums Indicates whether properties should be summed up if they support it. The showSums parameter is applied to the to the querie&#39;s result collection of work packages overriding the query&#39;s persisted sums property. (optional, default to false)
     * @param timelineVisible Indicates whether the timeline should be shown. (optional, default to false)
     * @param timelineLabels Overridden labels in the timeline view (optional, default to &quot;{}&quot;)
     * @param showHierarchies Indicates whether the hierarchy mode should be enabled. (optional, default to true)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3QueriesIdGet(Integer id, String filters, Integer offset, Integer pageSize, String sortBy, String groupBy, Boolean showSums, Boolean timelineVisible, String timelineLabels, Boolean showHierarchies, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3QueriesIdGet(id, filters, offset, pageSize, sortBy, groupBy, showSums, timelineVisible, timelineLabels, showHierarchies, resultHandler);
    }

    /**
     * View query
     * Retreive an individual query as identified by the id parameter. Then end point accepts a number of parameters that can be used to override the resources&#39; persisted parameters.
     * @param id Query id (required)
     * @param filters JSON specifying filter conditions. The filters provided as parameters are not applied to the query but are instead used to override the query&#39;s persisted filters. All filters also accepted by the work packages endpoint are accepted. (optional)
     * @param offset Page number inside the queries&#39; result collection of work packages. (optional, default to 1)
     * @param pageSize Number of elements to display per page for the queries&#39; result collection of work packages. (optional)
     * @param sortBy JSON specifying sort criteria. The sort criteria is applied to the querie&#39;s result collection of work packages overriding the query&#39;s persisted sort criteria. (optional)
     * @param groupBy The column to group by. The grouping criteria is applied to the to the querie&#39;s result collection of work packages overriding the query&#39;s persisted group criteria. (optional)
     * @param showSums Indicates whether properties should be summed up if they support it. The showSums parameter is applied to the to the querie&#39;s result collection of work packages overriding the query&#39;s persisted sums property. (optional, default to false)
     * @param timelineVisible Indicates whether the timeline should be shown. (optional, default to false)
     * @param timelineLabels Overridden labels in the timeline view (optional, default to &quot;{}&quot;)
     * @param showHierarchies Indicates whether the hierarchy mode should be enabled. (optional, default to true)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3QueriesIdGet(Integer id, String filters, Integer offset, Integer pageSize, String sortBy, String groupBy, Boolean showSums, Boolean timelineVisible, String timelineLabels, Boolean showHierarchies) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3QueriesIdGet(id, filters, offset, pageSize, sortBy, groupBy, showSums, timelineVisible, timelineLabels, showHierarchies, fut);
        }));
    }
    /**
     * Edit Query
     * When calling this endpoint the client provides a single object, containing the properties and links that it wants to change, in the body. Note that it is only allowed to provide properties or links supporting the **write** operation.
     * @param id Query id (required)
     * @param body  (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3QueriesIdPatch(Integer id, InlineObject3 body, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3QueriesIdPatch(id, body, resultHandler);
    }

    /**
     * Edit Query
     * When calling this endpoint the client provides a single object, containing the properties and links that it wants to change, in the body. Note that it is only allowed to provide properties or links supporting the **write** operation.
     * @param id Query id (required)
     * @param body  (optional)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3QueriesIdPatch(Integer id, InlineObject3 body) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3QueriesIdPatch(id, body, fut);
        }));
    }
    /**
     * Star query
     * 
     * @param id Query id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3QueriesIdStarPatch(Integer id, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3QueriesIdStarPatch(id, resultHandler);
    }

    /**
     * Star query
     * 
     * @param id Query id (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3QueriesIdStarPatch(Integer id) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3QueriesIdStarPatch(id, fut);
        }));
    }
    /**
     * Unstar query
     * 
     * @param id Query id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3QueriesIdUnstarPatch(Integer id, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3QueriesIdUnstarPatch(id, resultHandler);
    }

    /**
     * Unstar query
     * 
     * @param id Query id (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3QueriesIdUnstarPatch(Integer id) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3QueriesIdUnstarPatch(id, fut);
        }));
    }
    /**
     * Create query
     * When calling this endpoint the client provides a single object, containing at least the properties and links that are required, in the body. The required fields of a Query can be found in its schema, which is embedded in the respective form. Note that it is only allowed to provide properties or links supporting the write operation.
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3QueriesPost(Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3QueriesPost(resultHandler);
    }

    /**
     * Create query
     * When calling this endpoint the client provides a single object, containing at least the properties and links that are required, in the body. The required fields of a Query can be found in its schema, which is embedded in the respective form. Note that it is only allowed to provide properties or links supporting the write operation.
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3QueriesPost() {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3QueriesPost(fut);
        }));
    }
    /**
     * View schema for global queries
     * Retrieve the schema for global queries, those, that are not assigned to a project.
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3QueriesSchemaGet(Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3QueriesSchemaGet(resultHandler);
    }

    /**
     * View schema for global queries
     * Retrieve the schema for global queries, those, that are not assigned to a project.
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3QueriesSchemaGet() {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3QueriesSchemaGet(fut);
        }));
    }

    public static QueriesApi newInstance(net.jbw.openproject.client.api.QueriesApi arg) {
        return arg != null ? new QueriesApi(arg) : null;
    }
}
