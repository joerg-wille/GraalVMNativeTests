package net.jbw.openproject.client.api.rxjava;


import java.util.*;

import rx.Single;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;


public class ConfigurationApi {

	private final net.jbw.openproject.client.api.ConfigurationApi delegate;

	public ConfigurationApi(net.jbw.openproject.client.api.ConfigurationApi delegate) {
	    this.delegate = delegate;
    }

	public net.jbw.openproject.client.api.ConfigurationApi getDelegate() {
	    return delegate;
	}

    /**
     * View configuration
     * 
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3ConfigurationGet(Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3ConfigurationGet(resultHandler);
    }

    /**
     * View configuration
     * 
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3ConfigurationGet() {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3ConfigurationGet(fut);
        }));
    }

    public static ConfigurationApi newInstance(net.jbw.openproject.client.api.ConfigurationApi arg) {
        return arg != null ? new ConfigurationApi(arg) : null;
    }
}
