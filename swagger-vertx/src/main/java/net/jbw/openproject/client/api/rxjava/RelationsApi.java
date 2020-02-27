package net.jbw.openproject.client.api.rxjava;


import java.util.*;

import rx.Single;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;


public class RelationsApi {

	private final net.jbw.openproject.client.api.RelationsApi delegate;

	public RelationsApi(net.jbw.openproject.client.api.RelationsApi delegate) {
	    this.delegate = delegate;
    }

	public net.jbw.openproject.client.api.RelationsApi getDelegate() {
	    return delegate;
	}

    /**
     * List Relations
     * Lists all relations according to the given (optional, logically conjunctive) filters and ordered by ID. The response only includes relations between work packages which the user is allowed to see.
     * @param filters JSON specifying filter conditions. Accepts the same format as returned by the [queries](#queries) endpoint. Valid fields to filter by are:  + id - ID of relation  + from - ID of work package from which the filtered relations emanates.  + to - ID of work package to which this related points.  + involved - ID of either the &#x60;from&#x60; or the &#x60;to&#x60; work package.  + type - The type of relation to filter by, e.g. \&quot;follows\&quot;. (optional)
     * @param sortBy JSON specifying sort criteria. Accepts the same format as returned by the [queries](#queries) endpoint. (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3RelationsGet(String filters, String sortBy, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3RelationsGet(filters, sortBy, resultHandler);
    }

    /**
     * List Relations
     * Lists all relations according to the given (optional, logically conjunctive) filters and ordered by ID. The response only includes relations between work packages which the user is allowed to see.
     * @param filters JSON specifying filter conditions. Accepts the same format as returned by the [queries](#queries) endpoint. Valid fields to filter by are:  + id - ID of relation  + from - ID of work package from which the filtered relations emanates.  + to - ID of work package to which this related points.  + involved - ID of either the &#x60;from&#x60; or the &#x60;to&#x60; work package.  + type - The type of relation to filter by, e.g. \&quot;follows\&quot;. (optional)
     * @param sortBy JSON specifying sort criteria. Accepts the same format as returned by the [queries](#queries) endpoint. (optional)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3RelationsGet(String filters, String sortBy) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3RelationsGet(filters, sortBy, fut);
        }));
    }
    /**
     * Delete Relation
     * Deletes the relation.
     * @param id Relation ID (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3RelationsIdDelete(Integer id, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3RelationsIdDelete(id, resultHandler);
    }

    /**
     * Delete Relation
     * Deletes the relation.
     * @param id Relation ID (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3RelationsIdDelete(Integer id) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3RelationsIdDelete(id, fut);
        }));
    }
    /**
     * Relation edit form
     * 
     * @param id ID of the relation being modified (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3RelationsIdFormPost(Integer id, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3RelationsIdFormPost(id, resultHandler);
    }

    /**
     * Relation edit form
     * 
     * @param id ID of the relation being modified (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3RelationsIdFormPost(Integer id) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3RelationsIdFormPost(id, fut);
        }));
    }
    /**
     * View Relation
     * 
     * @param id Relation id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3RelationsIdGet(Integer id, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3RelationsIdGet(id, resultHandler);
    }

    /**
     * View Relation
     * 
     * @param id Relation id (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3RelationsIdGet(Integer id) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3RelationsIdGet(id, fut);
        }));
    }
    /**
     * Edit Relation
     * When calling this endpoint the client provides a single object, containing the properties and links that it wants to change, in the body. It is only allowed to provide properties or links supporting the **write** operation.  Note that changing the &#x60;type&#x60; of a relation invariably also changes the respective &#x60;reverseType&#x60; as well as the \&quot;name\&quot; of it. The returned Relation object will reflect that change. For instance if you change a Relation&#39;s &#x60;type&#x60; to \&quot;follows\&quot; then the &#x60;reverseType&#x60; will be changed to &#x60;precedes&#x60;.
     * @param id Relation ID (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3RelationsIdPatch(Integer id, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3RelationsIdPatch(id, resultHandler);
    }

    /**
     * Edit Relation
     * When calling this endpoint the client provides a single object, containing the properties and links that it wants to change, in the body. It is only allowed to provide properties or links supporting the **write** operation.  Note that changing the &#x60;type&#x60; of a relation invariably also changes the respective &#x60;reverseType&#x60; as well as the \&quot;name\&quot; of it. The returned Relation object will reflect that change. For instance if you change a Relation&#39;s &#x60;type&#x60; to \&quot;follows\&quot; then the &#x60;reverseType&#x60; will be changed to &#x60;precedes&#x60;.
     * @param id Relation ID (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3RelationsIdPatch(Integer id) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3RelationsIdPatch(id, fut);
        }));
    }
    /**
     * View relation schema
     * 
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3RelationsSchemaGet(Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3RelationsSchemaGet(resultHandler);
    }

    /**
     * View relation schema
     * 
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3RelationsSchemaGet() {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3RelationsSchemaGet(fut);
        }));
    }
    /**
     * View relation schema for type
     * 
     * @param type Type of the schema (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3RelationsSchemaTypeGet(String type, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3RelationsSchemaTypeGet(type, resultHandler);
    }

    /**
     * View relation schema for type
     * 
     * @param type Type of the schema (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3RelationsSchemaTypeGet(String type) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3RelationsSchemaTypeGet(type, fut);
        }));
    }

    public static RelationsApi newInstance(net.jbw.openproject.client.api.RelationsApi arg) {
        return arg != null ? new RelationsApi(arg) : null;
    }
}
