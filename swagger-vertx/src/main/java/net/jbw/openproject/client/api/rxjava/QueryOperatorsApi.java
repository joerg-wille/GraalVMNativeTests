package net.jbw.openproject.client.api.rxjava;


import java.util.*;

import rx.Single;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;


public class QueryOperatorsApi {

	private final net.jbw.openproject.client.api.QueryOperatorsApi delegate;

	public QueryOperatorsApi(net.jbw.openproject.client.api.QueryOperatorsApi delegate) {
	    this.delegate = delegate;
    }

	public net.jbw.openproject.client.api.QueryOperatorsApi getDelegate() {
	    return delegate;
	}

    /**
     * View Query Operator
     * Retreive an individual QueryOperator as identified by the &#x60;id&#x60; parameter.
     * @param id QueryOperator id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3QueriesOperatorsIdGet(String id, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3QueriesOperatorsIdGet(id, resultHandler);
    }

    /**
     * View Query Operator
     * Retreive an individual QueryOperator as identified by the &#x60;id&#x60; parameter.
     * @param id QueryOperator id (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3QueriesOperatorsIdGet(String id) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3QueriesOperatorsIdGet(id, fut);
        }));
    }

    public static QueryOperatorsApi newInstance(net.jbw.openproject.client.api.QueryOperatorsApi arg) {
        return arg != null ? new QueryOperatorsApi(arg) : null;
    }
}
