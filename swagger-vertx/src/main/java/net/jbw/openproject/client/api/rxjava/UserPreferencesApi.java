package net.jbw.openproject.client.api.rxjava;

import net.jbw.openproject.client.model.InlineObject4;

import java.util.*;

import rx.Single;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;


public class UserPreferencesApi {

	private final net.jbw.openproject.client.api.UserPreferencesApi delegate;

	public UserPreferencesApi(net.jbw.openproject.client.api.UserPreferencesApi delegate) {
	    this.delegate = delegate;
    }

	public net.jbw.openproject.client.api.UserPreferencesApi getDelegate() {
	    return delegate;
	}

    /**
     * Show my preferences
     * 
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3MyPreferencesGet(Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3MyPreferencesGet(resultHandler);
    }

    /**
     * Show my preferences
     * 
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3MyPreferencesGet() {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3MyPreferencesGet(fut);
        }));
    }
    /**
     * Update UserPreferences
     * When calling this endpoint the client provides a single object, containing the properties that it wants to change, in the body.
     * @param body  (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3MyPreferencesPatch(InlineObject4 body, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3MyPreferencesPatch(body, resultHandler);
    }

    /**
     * Update UserPreferences
     * When calling this endpoint the client provides a single object, containing the properties that it wants to change, in the body.
     * @param body  (optional)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3MyPreferencesPatch(InlineObject4 body) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3MyPreferencesPatch(body, fut);
        }));
    }

    public static UserPreferencesApi newInstance(net.jbw.openproject.client.api.UserPreferencesApi arg) {
        return arg != null ? new UserPreferencesApi(arg) : null;
    }
}
