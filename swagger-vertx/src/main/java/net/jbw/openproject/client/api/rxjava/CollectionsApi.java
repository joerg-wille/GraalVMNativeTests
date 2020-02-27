package net.jbw.openproject.client.api.rxjava;


import java.util.*;

import rx.Single;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;


public class CollectionsApi {

	private final net.jbw.openproject.client.api.CollectionsApi delegate;

	public CollectionsApi(net.jbw.openproject.client.api.CollectionsApi delegate) {
	    this.delegate = delegate;
    }

	public net.jbw.openproject.client.api.CollectionsApi getDelegate() {
	    return delegate;
	}

    /**
     * view aggregated result
     * 
     * @param groupBy The column to group by. Note: Aggregation is as of now only supported by the work package collection. You can pass any column name as returned by the [queries](#queries) endpoint. (optional)
     * @param showSums  (optional, default to &quot;false&quot;)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3ExamplesGet(String groupBy, String showSums, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3ExamplesGet(groupBy, showSums, resultHandler);
    }

    /**
     * view aggregated result
     * 
     * @param groupBy The column to group by. Note: Aggregation is as of now only supported by the work package collection. You can pass any column name as returned by the [queries](#queries) endpoint. (optional)
     * @param showSums  (optional, default to &quot;false&quot;)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3ExamplesGet(String groupBy, String showSums) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3ExamplesGet(groupBy, showSums, fut);
        }));
    }

    public static CollectionsApi newInstance(net.jbw.openproject.client.api.CollectionsApi arg) {
        return arg != null ? new CollectionsApi(arg) : null;
    }
}
