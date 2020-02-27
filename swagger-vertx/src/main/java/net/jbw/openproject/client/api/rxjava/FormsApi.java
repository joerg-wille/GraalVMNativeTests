package net.jbw.openproject.client.api.rxjava;

import net.jbw.openproject.client.model.InlineObject2;

import java.util.*;

import rx.Single;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;


public class FormsApi {

	private final net.jbw.openproject.client.api.FormsApi delegate;

	public FormsApi(net.jbw.openproject.client.api.FormsApi delegate) {
	    this.delegate = delegate;
    }

	public net.jbw.openproject.client.api.FormsApi getDelegate() {
	    return delegate;
	}

    /**
     * show or validate form
     * This is an example of how a form might look like. Note that this endpoint does not exist in the actual implementation.
     * @param body  (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3ExampleFormPost(InlineObject2 body, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3ExampleFormPost(body, resultHandler);
    }

    /**
     * show or validate form
     * This is an example of how a form might look like. Note that this endpoint does not exist in the actual implementation.
     * @param body  (optional)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3ExampleFormPost(InlineObject2 body) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3ExampleFormPost(body, fut);
        }));
    }

    public static FormsApi newInstance(net.jbw.openproject.client.api.FormsApi arg) {
        return arg != null ? new FormsApi(arg) : null;
    }
}
