package net.jbw.openproject.client.api.rxjava;


import java.util.*;

import rx.Single;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;


public class CategoriesApi {

	private final net.jbw.openproject.client.api.CategoriesApi delegate;

	public CategoriesApi(net.jbw.openproject.client.api.CategoriesApi delegate) {
	    this.delegate = delegate;
    }

	public net.jbw.openproject.client.api.CategoriesApi getDelegate() {
	    return delegate;
	}

    /**
     * View Category
     * 
     * @param id category id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3CategoriesIdGet(Integer id, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3CategoriesIdGet(id, resultHandler);
    }

    /**
     * View Category
     * 
     * @param id category id (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3CategoriesIdGet(Integer id) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3CategoriesIdGet(id, fut);
        }));
    }
    /**
     * List categories of a project
     * 
     * @param projectId ID of the project whoose categories will be listed (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3ProjectsProjectIdCategoriesGet(Integer projectId, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3ProjectsProjectIdCategoriesGet(projectId, resultHandler);
    }

    /**
     * List categories of a project
     * 
     * @param projectId ID of the project whoose categories will be listed (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3ProjectsProjectIdCategoriesGet(Integer projectId) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3ProjectsProjectIdCategoriesGet(projectId, fut);
        }));
    }

    public static CategoriesApi newInstance(net.jbw.openproject.client.api.CategoriesApi arg) {
        return arg != null ? new CategoriesApi(arg) : null;
    }
}
