package net.jbw.openproject.client.api.rxjava;


import java.util.*;

import rx.Single;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;


public class QuerySortBysApi {

	private final net.jbw.openproject.client.api.QuerySortBysApi delegate;

	public QuerySortBysApi(net.jbw.openproject.client.api.QuerySortBysApi delegate) {
	    this.delegate = delegate;
    }

	public net.jbw.openproject.client.api.QuerySortBysApi getDelegate() {
	    return delegate;
	}

    /**
     * View Query Sort By
     * Retreive an individual QuerySortBy as identified by the id parameter.
     * @param id QuerySortBy identifier. The identifier is a combination of the column identifier and the direction. (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3QueriesSortBysIdGet(String id, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3QueriesSortBysIdGet(id, resultHandler);
    }

    /**
     * View Query Sort By
     * Retreive an individual QuerySortBy as identified by the id parameter.
     * @param id QuerySortBy identifier. The identifier is a combination of the column identifier and the direction. (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3QueriesSortBysIdGet(String id) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3QueriesSortBysIdGet(id, fut);
        }));
    }

    public static QuerySortBysApi newInstance(net.jbw.openproject.client.api.QuerySortBysApi arg) {
        return arg != null ? new QuerySortBysApi(arg) : null;
    }
}
