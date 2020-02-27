package net.jbw.openproject.client.api.rxjava;


import java.util.*;

import rx.Single;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;


public class QueryColumnsApi {

	private final net.jbw.openproject.client.api.QueryColumnsApi delegate;

	public QueryColumnsApi(net.jbw.openproject.client.api.QueryColumnsApi delegate) {
	    this.delegate = delegate;
    }

	public net.jbw.openproject.client.api.QueryColumnsApi getDelegate() {
	    return delegate;
	}

    /**
     * View Query Column
     * Retreive an individual QueryColumn as identified by the &#x60;id&#x60; parameter.
     * @param id QueryColumn id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3QueriesColumnsIdGet(String id, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3QueriesColumnsIdGet(id, resultHandler);
    }

    /**
     * View Query Column
     * Retreive an individual QueryColumn as identified by the &#x60;id&#x60; parameter.
     * @param id QueryColumn id (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3QueriesColumnsIdGet(String id) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3QueriesColumnsIdGet(id, fut);
        }));
    }

    public static QueryColumnsApi newInstance(net.jbw.openproject.client.api.QueryColumnsApi arg) {
        return arg != null ? new QueryColumnsApi(arg) : null;
    }
}
