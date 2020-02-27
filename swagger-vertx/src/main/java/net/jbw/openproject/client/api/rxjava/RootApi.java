package net.jbw.openproject.client.api.rxjava;


import java.util.*;

import rx.Single;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;


public class RootApi {

	private final net.jbw.openproject.client.api.RootApi delegate;

	public RootApi(net.jbw.openproject.client.api.RootApi delegate) {
	    this.delegate = delegate;
    }

	public net.jbw.openproject.client.api.RootApi getDelegate() {
	    return delegate;
	}

    /**
     * View root
     * 
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3Get(Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3Get(resultHandler);
    }

    /**
     * View root
     * 
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3Get() {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3Get(fut);
        }));
    }

    public static RootApi newInstance(net.jbw.openproject.client.api.RootApi arg) {
        return arg != null ? new RootApi(arg) : null;
    }
}
