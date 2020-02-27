package net.jbw.openproject.client.api.rxjava;


import java.util.*;

import rx.Single;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;


public class SchemasApi {

	private final net.jbw.openproject.client.api.SchemasApi delegate;

	public SchemasApi(net.jbw.openproject.client.api.SchemasApi delegate) {
	    this.delegate = delegate;
    }

	public net.jbw.openproject.client.api.SchemasApi getDelegate() {
	    return delegate;
	}

    /**
     * view the schema
     * This is an example of how a schema might look like. Note that this endpoint does not exist in the actual implementation.
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3ExampleSchemaGet(Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3ExampleSchemaGet(resultHandler);
    }

    /**
     * view the schema
     * This is an example of how a schema might look like. Note that this endpoint does not exist in the actual implementation.
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3ExampleSchemaGet() {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3ExampleSchemaGet(fut);
        }));
    }

    public static SchemasApi newInstance(net.jbw.openproject.client.api.SchemasApi arg) {
        return arg != null ? new SchemasApi(arg) : null;
    }
}
