package net.jbw.openproject.client.api.rxjava;


import java.util.*;

import rx.Single;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;


public class RolesApi {

	private final net.jbw.openproject.client.api.RolesApi delegate;

	public RolesApi(net.jbw.openproject.client.api.RolesApi delegate) {
	    this.delegate = delegate;
    }

	public net.jbw.openproject.client.api.RolesApi getDelegate() {
	    return delegate;
	}

    /**
     * List roles
     * List all defined roles. This includes built in roles like &#39;Anonymous&#39; and &#39;Non member&#39;.
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3RolesGet(Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3RolesGet(resultHandler);
    }

    /**
     * List roles
     * List all defined roles. This includes built in roles like &#39;Anonymous&#39; and &#39;Non member&#39;.
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3RolesGet() {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3RolesGet(fut);
        }));
    }
    /**
     * View role
     * Fetch an individual role.
     * @param id role id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3RolesIdGet(Integer id, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3RolesIdGet(id, resultHandler);
    }

    /**
     * View role
     * Fetch an individual role.
     * @param id role id (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3RolesIdGet(Integer id) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3RolesIdGet(id, fut);
        }));
    }

    public static RolesApi newInstance(net.jbw.openproject.client.api.RolesApi arg) {
        return arg != null ? new RolesApi(arg) : null;
    }
}
