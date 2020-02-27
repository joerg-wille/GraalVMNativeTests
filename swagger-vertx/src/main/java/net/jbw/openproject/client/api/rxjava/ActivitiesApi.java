package net.jbw.openproject.client.api.rxjava;

import net.jbw.openproject.client.model.InlineObject;

import java.util.*;

import rx.Single;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;


public class ActivitiesApi {

	private final net.jbw.openproject.client.api.ActivitiesApi delegate;

	public ActivitiesApi(net.jbw.openproject.client.api.ActivitiesApi delegate) {
	    this.delegate = delegate;
    }

	public net.jbw.openproject.client.api.ActivitiesApi getDelegate() {
	    return delegate;
	}

    /**
     * View activity
     * 
     * @param id Activity id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3ActivitiesIdGet(Integer id, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3ActivitiesIdGet(id, resultHandler);
    }

    /**
     * View activity
     * 
     * @param id Activity id (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3ActivitiesIdGet(Integer id) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3ActivitiesIdGet(id, fut);
        }));
    }
    /**
     * Update activity
     * Updates an activity&#39;s comment and, on success, returns the updated activity.
     * @param id Activity id (required)
     * @param body  (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3ActivitiesIdPatch(Integer id, InlineObject body, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3ActivitiesIdPatch(id, body, resultHandler);
    }

    /**
     * Update activity
     * Updates an activity&#39;s comment and, on success, returns the updated activity.
     * @param id Activity id (required)
     * @param body  (optional)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3ActivitiesIdPatch(Integer id, InlineObject body) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3ActivitiesIdPatch(id, body, fut);
        }));
    }

    public static ActivitiesApi newInstance(net.jbw.openproject.client.api.ActivitiesApi arg) {
        return arg != null ? new ActivitiesApi(arg) : null;
    }
}
