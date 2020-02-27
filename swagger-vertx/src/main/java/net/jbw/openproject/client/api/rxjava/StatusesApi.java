package net.jbw.openproject.client.api.rxjava;


import java.util.*;

import rx.Single;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;


public class StatusesApi {

	private final net.jbw.openproject.client.api.StatusesApi delegate;

	public StatusesApi(net.jbw.openproject.client.api.StatusesApi delegate) {
	    this.delegate = delegate;
    }

	public net.jbw.openproject.client.api.StatusesApi getDelegate() {
	    return delegate;
	}

    /**
     * List all Statuses
     * 
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3StatusesGet(Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3StatusesGet(resultHandler);
    }

    /**
     * List all Statuses
     * 
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3StatusesGet() {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3StatusesGet(fut);
        }));
    }
    /**
     * View Status
     * 
     * @param id status id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3StatusesIdGet(Integer id, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3StatusesIdGet(id, resultHandler);
    }

    /**
     * View Status
     * 
     * @param id status id (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3StatusesIdGet(Integer id) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3StatusesIdGet(id, fut);
        }));
    }

    public static StatusesApi newInstance(net.jbw.openproject.client.api.StatusesApi arg) {
        return arg != null ? new StatusesApi(arg) : null;
    }
}
