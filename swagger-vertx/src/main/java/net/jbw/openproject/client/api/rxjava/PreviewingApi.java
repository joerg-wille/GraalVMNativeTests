package net.jbw.openproject.client.api.rxjava;


import java.util.*;

import rx.Single;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;


public class PreviewingApi {

	private final net.jbw.openproject.client.api.PreviewingApi delegate;

	public PreviewingApi(net.jbw.openproject.client.api.PreviewingApi delegate) {
	    this.delegate = delegate;
    }

	public net.jbw.openproject.client.api.PreviewingApi getDelegate() {
	    return delegate;
	}

    /**
     * Preview plain document
     * 
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3RenderPlainPost(Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3RenderPlainPost(resultHandler);
    }

    /**
     * Preview plain document
     * 
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3RenderPlainPost() {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3RenderPlainPost(fut);
        }));
    }
    /**
     * Preview Textile document
     * 
     * @param context API-Link to the context in which the rendering occurs, for example a specific work package.  If left out only context-agnostic rendering takes place. Please note that OpenProject features textile-extensions that can only work given a context (e.g. display attached images).  **Supported contexts:**  * &#x60;/api/v3/work_packages/{id}&#x60; - an existing work package (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3RenderTextilePost(String context, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3RenderTextilePost(context, resultHandler);
    }

    /**
     * Preview Textile document
     * 
     * @param context API-Link to the context in which the rendering occurs, for example a specific work package.  If left out only context-agnostic rendering takes place. Please note that OpenProject features textile-extensions that can only work given a context (e.g. display attached images).  **Supported contexts:**  * &#x60;/api/v3/work_packages/{id}&#x60; - an existing work package (optional)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3RenderTextilePost(String context) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3RenderTextilePost(context, fut);
        }));
    }

    public static PreviewingApi newInstance(net.jbw.openproject.client.api.PreviewingApi arg) {
        return arg != null ? new PreviewingApi(arg) : null;
    }
}
