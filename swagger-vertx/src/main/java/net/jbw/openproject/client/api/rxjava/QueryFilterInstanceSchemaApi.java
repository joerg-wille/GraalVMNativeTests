package net.jbw.openproject.client.api.rxjava;


import java.util.*;

import rx.Single;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;


public class QueryFilterInstanceSchemaApi {

	private final net.jbw.openproject.client.api.QueryFilterInstanceSchemaApi delegate;

	public QueryFilterInstanceSchemaApi(net.jbw.openproject.client.api.QueryFilterInstanceSchemaApi delegate) {
	    this.delegate = delegate;
    }

	public net.jbw.openproject.client.api.QueryFilterInstanceSchemaApi getDelegate() {
	    return delegate;
	}

    /**
     * List Query Filter Instance Schemas for Project
     * Returns the list of QueryFilterInstanceSchemas defined for a query of the specified project.
     * @param id Id of the project. (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3ProjectsIdQueriesFilterInstanceSchemasGet(Integer id, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3ProjectsIdQueriesFilterInstanceSchemasGet(id, resultHandler);
    }

    /**
     * List Query Filter Instance Schemas for Project
     * Returns the list of QueryFilterInstanceSchemas defined for a query of the specified project.
     * @param id Id of the project. (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3ProjectsIdQueriesFilterInstanceSchemasGet(Integer id) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3ProjectsIdQueriesFilterInstanceSchemasGet(id, fut);
        }));
    }
    /**
     * List Query Filter Instance Schemas
     * Returns the list of QueryFilterInstanceSchemas defined for a global query. That is a query not assigned to a project.
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3QueriesFilterInstanceSchemasGet(Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3QueriesFilterInstanceSchemasGet(resultHandler);
    }

    /**
     * List Query Filter Instance Schemas
     * Returns the list of QueryFilterInstanceSchemas defined for a global query. That is a query not assigned to a project.
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3QueriesFilterInstanceSchemasGet() {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3QueriesFilterInstanceSchemasGet(fut);
        }));
    }
    /**
     * View Query Filter Instance Schema
     * Retreive an individual QueryFilterInstanceSchema as identified by the id parameter.
     * @param identifier QueryFilterInstanceSchema identifier. The identifier is the filter identifier. (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3QueriesFilterInstanceSchemasIdentifierGet(String identifier, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3QueriesFilterInstanceSchemasIdentifierGet(identifier, resultHandler);
    }

    /**
     * View Query Filter Instance Schema
     * Retreive an individual QueryFilterInstanceSchema as identified by the id parameter.
     * @param identifier QueryFilterInstanceSchema identifier. The identifier is the filter identifier. (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3QueriesFilterInstanceSchemasIdentifierGet(String identifier) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3QueriesFilterInstanceSchemasIdentifierGet(identifier, fut);
        }));
    }

    public static QueryFilterInstanceSchemaApi newInstance(net.jbw.openproject.client.api.QueryFilterInstanceSchemaApi arg) {
        return arg != null ? new QueryFilterInstanceSchemaApi(arg) : null;
    }
}
