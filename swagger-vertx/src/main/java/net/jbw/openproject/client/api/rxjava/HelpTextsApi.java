package net.jbw.openproject.client.api.rxjava;


import java.util.*;

import rx.Single;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;


public class HelpTextsApi {

	private final net.jbw.openproject.client.api.HelpTextsApi delegate;

	public HelpTextsApi(net.jbw.openproject.client.api.HelpTextsApi delegate) {
	    this.delegate = delegate;
    }

	public net.jbw.openproject.client.api.HelpTextsApi getDelegate() {
	    return delegate;
	}

    /**
     * List all help texts
     * 
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3HelpTextsGet(Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3HelpTextsGet(resultHandler);
    }

    /**
     * List all help texts
     * 
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3HelpTextsGet() {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3HelpTextsGet(fut);
        }));
    }
    /**
     * View help text
     * 
     * @param id Help text id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3HelpTextsIdGet(Integer id, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3HelpTextsIdGet(id, resultHandler);
    }

    /**
     * View help text
     * 
     * @param id Help text id (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3HelpTextsIdGet(Integer id) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3HelpTextsIdGet(id, fut);
        }));
    }

    public static HelpTextsApi newInstance(net.jbw.openproject.client.api.HelpTextsApi arg) {
        return arg != null ? new HelpTextsApi(arg) : null;
    }
}
