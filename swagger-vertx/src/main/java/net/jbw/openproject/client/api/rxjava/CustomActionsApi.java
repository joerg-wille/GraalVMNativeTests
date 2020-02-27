package net.jbw.openproject.client.api.rxjava;

import net.jbw.openproject.client.model.InlineObject1;

import java.util.*;

import rx.Single;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;


public class CustomActionsApi {

	private final net.jbw.openproject.client.api.CustomActionsApi delegate;

	public CustomActionsApi(net.jbw.openproject.client.api.CustomActionsApi delegate) {
	    this.delegate = delegate;
    }

	public net.jbw.openproject.client.api.CustomActionsApi getDelegate() {
	    return delegate;
	}

    /**
     * Execute custom action
     * A POST to this end point executes the custom action on the work package provided in the payload. The altered work package will be returned. In order to avoid executing  the custom action unbeknown to a change that has already taken place, the client has to provide the work package&#39;s current lockVersion.
     * @param customActionId The id of the custom action to execute (required)
     * @param body  (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3CustomActionsCustomActionIdExecutePost(Integer customActionId, InlineObject1 body, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3CustomActionsCustomActionIdExecutePost(customActionId, body, resultHandler);
    }

    /**
     * Execute custom action
     * A POST to this end point executes the custom action on the work package provided in the payload. The altered work package will be returned. In order to avoid executing  the custom action unbeknown to a change that has already taken place, the client has to provide the work package&#39;s current lockVersion.
     * @param customActionId The id of the custom action to execute (required)
     * @param body  (optional)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3CustomActionsCustomActionIdExecutePost(Integer customActionId, InlineObject1 body) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3CustomActionsCustomActionIdExecutePost(customActionId, body, fut);
        }));
    }
    /**
     * View custom action
     * 
     * @param customActionId The id of the custom action to fetch (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3CustomActionsCustomActionIdGet(Integer customActionId, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3CustomActionsCustomActionIdGet(customActionId, resultHandler);
    }

    /**
     * View custom action
     * 
     * @param customActionId The id of the custom action to fetch (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3CustomActionsCustomActionIdGet(Integer customActionId) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3CustomActionsCustomActionIdGet(customActionId, fut);
        }));
    }

    public static CustomActionsApi newInstance(net.jbw.openproject.client.api.CustomActionsApi arg) {
        return arg != null ? new CustomActionsApi(arg) : null;
    }
}
