package net.jbw.openproject.client.api.rxjava;


import java.util.*;

import rx.Single;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;


public class CustomObjectsApi {

	private final net.jbw.openproject.client.api.CustomObjectsApi delegate;

	public CustomObjectsApi(net.jbw.openproject.client.api.CustomObjectsApi delegate) {
	    this.delegate = delegate;
    }

	public net.jbw.openproject.client.api.CustomObjectsApi getDelegate() {
	    return delegate;
	}

    /**
     * View Custom Object
     * 
     * @param id The custom object&#39;s identifier (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3CustomObjectsIdGet(Integer id, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3CustomObjectsIdGet(id, resultHandler);
    }

    /**
     * View Custom Object
     * 
     * @param id The custom object&#39;s identifier (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3CustomObjectsIdGet(Integer id) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3CustomObjectsIdGet(id, fut);
        }));
    }

    public static CustomObjectsApi newInstance(net.jbw.openproject.client.api.CustomObjectsApi arg) {
        return arg != null ? new CustomObjectsApi(arg) : null;
    }
}
