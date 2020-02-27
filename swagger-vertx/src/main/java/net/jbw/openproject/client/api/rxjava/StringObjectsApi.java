package net.jbw.openproject.client.api.rxjava;


import java.util.*;

import rx.Single;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;


public class StringObjectsApi {

	private final net.jbw.openproject.client.api.StringObjectsApi delegate;

	public StringObjectsApi(net.jbw.openproject.client.api.StringObjectsApi delegate) {
	    this.delegate = delegate;
    }

	public net.jbw.openproject.client.api.StringObjectsApi getDelegate() {
	    return delegate;
	}

    /**
     * View String Object
     * 
     * @param value The string value being resolved (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3StringObjectsGet(String value, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3StringObjectsGet(value, resultHandler);
    }

    /**
     * View String Object
     * 
     * @param value The string value being resolved (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3StringObjectsGet(String value) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3StringObjectsGet(value, fut);
        }));
    }

    public static StringObjectsApi newInstance(net.jbw.openproject.client.api.StringObjectsApi arg) {
        return arg != null ? new StringObjectsApi(arg) : null;
    }
}
