package net.jbw.openproject.client.api.rxjava;


import java.util.*;

import rx.Single;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;


public class QueryFiltersApi {

	private final net.jbw.openproject.client.api.QueryFiltersApi delegate;

	public QueryFiltersApi(net.jbw.openproject.client.api.QueryFiltersApi delegate) {
	    this.delegate = delegate;
    }

	public net.jbw.openproject.client.api.QueryFiltersApi getDelegate() {
	    return delegate;
	}

    /**
     * View Query Filter
     * Retreive an individual QueryFilter as identified by the id parameter.
     * @param id QueryFilter identifier. (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3QueriesFiltersIdGet(String id, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3QueriesFiltersIdGet(id, resultHandler);
    }

    /**
     * View Query Filter
     * Retreive an individual QueryFilter as identified by the id parameter.
     * @param id QueryFilter identifier. (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3QueriesFiltersIdGet(String id) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3QueriesFiltersIdGet(id, fut);
        }));
    }

    public static QueryFiltersApi newInstance(net.jbw.openproject.client.api.QueryFiltersApi arg) {
        return arg != null ? new QueryFiltersApi(arg) : null;
    }
}
