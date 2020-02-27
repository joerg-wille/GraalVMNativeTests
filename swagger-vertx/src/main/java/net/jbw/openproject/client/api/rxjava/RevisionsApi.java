package net.jbw.openproject.client.api.rxjava;


import java.util.*;

import rx.Single;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;


public class RevisionsApi {

	private final net.jbw.openproject.client.api.RevisionsApi delegate;

	public RevisionsApi(net.jbw.openproject.client.api.RevisionsApi delegate) {
	    this.delegate = delegate;
    }

	public net.jbw.openproject.client.api.RevisionsApi getDelegate() {
	    return delegate;
	}

    /**
     * View revision
     * 
     * @param id Revision id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3RevisionsIdGet(Integer id, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3RevisionsIdGet(id, resultHandler);
    }

    /**
     * View revision
     * 
     * @param id Revision id (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3RevisionsIdGet(Integer id) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3RevisionsIdGet(id, fut);
        }));
    }

    public static RevisionsApi newInstance(net.jbw.openproject.client.api.RevisionsApi arg) {
        return arg != null ? new RevisionsApi(arg) : null;
    }
}
