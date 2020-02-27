package net.jbw.openproject.client.api.rxjava;


import java.util.*;

import rx.Single;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;


public class PrioritiesApi {

	private final net.jbw.openproject.client.api.PrioritiesApi delegate;

	public PrioritiesApi(net.jbw.openproject.client.api.PrioritiesApi delegate) {
	    this.delegate = delegate;
    }

	public net.jbw.openproject.client.api.PrioritiesApi getDelegate() {
	    return delegate;
	}

    /**
     * List all Priorities
     * 
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3PrioritiesGet(Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3PrioritiesGet(resultHandler);
    }

    /**
     * List all Priorities
     * 
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3PrioritiesGet() {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3PrioritiesGet(fut);
        }));
    }
    /**
     * View Priority
     * 
     * @param id Priority id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3PrioritiesIdGet(Integer id, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3PrioritiesIdGet(id, resultHandler);
    }

    /**
     * View Priority
     * 
     * @param id Priority id (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3PrioritiesIdGet(Integer id) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3PrioritiesIdGet(id, fut);
        }));
    }

    public static PrioritiesApi newInstance(net.jbw.openproject.client.api.PrioritiesApi arg) {
        return arg != null ? new PrioritiesApi(arg) : null;
    }
}
