package net.jbw.openproject.client.api.rxjava;


import java.util.*;

import rx.Single;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;


public class PrincipalsApi {

	private final net.jbw.openproject.client.api.PrincipalsApi delegate;

	public PrincipalsApi(net.jbw.openproject.client.api.PrincipalsApi delegate) {
	    this.delegate = delegate;
    }

	public net.jbw.openproject.client.api.PrincipalsApi getDelegate() {
	    return delegate;
	}

    /**
     * List principals
     * List all principals. The client can choose to filter the principals similar to how work packages are filtered. In addition to the provided filters, the server will reduce the result set to only contain principals who are members in projects the client is allowed to see.
     * @param filters JSON specifying filter conditions. Accepts the same format as returned by the [queries](#queries) endpoint. Currently supported filters are:  + type: filters principals by their type (*User*, *Group*).  + member: filters principals by the projects they are members in. (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3PrincipalsGet(String filters, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3PrincipalsGet(filters, resultHandler);
    }

    /**
     * List principals
     * List all principals. The client can choose to filter the principals similar to how work packages are filtered. In addition to the provided filters, the server will reduce the result set to only contain principals who are members in projects the client is allowed to see.
     * @param filters JSON specifying filter conditions. Accepts the same format as returned by the [queries](#queries) endpoint. Currently supported filters are:  + type: filters principals by their type (*User*, *Group*).  + member: filters principals by the projects they are members in. (optional)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3PrincipalsGet(String filters) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3PrincipalsGet(filters, fut);
        }));
    }

    public static PrincipalsApi newInstance(net.jbw.openproject.client.api.PrincipalsApi arg) {
        return arg != null ? new PrincipalsApi(arg) : null;
    }
}
