package net.jbw.openproject.client.api.rxjava;

import net.jbw.openproject.client.model.WPType;
import net.jbw.openproject.client.model.WPTypes;

import java.util.*;

import rx.Single;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;


public class TypesApi {

	private final net.jbw.openproject.client.api.TypesApi delegate;

	public TypesApi(net.jbw.openproject.client.api.TypesApi delegate) {
	    this.delegate = delegate;
    }

	public net.jbw.openproject.client.api.TypesApi getDelegate() {
	    return delegate;
	}

    /**
     * List types available in a project
     * This endpoint lists the types that are *available* in a given project.
     * @param projectId ID of the project whoose types will be listed (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3ProjectsProjectIdTypesGet(Integer projectId, Handler<AsyncResult<WPTypes>> resultHandler) {
        delegate.apiV3ProjectsProjectIdTypesGet(projectId, resultHandler);
    }

    /**
     * List types available in a project
     * This endpoint lists the types that are *available* in a given project.
     * @param projectId ID of the project whoose types will be listed (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<WPTypes> rxApiV3ProjectsProjectIdTypesGet(Integer projectId) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3ProjectsProjectIdTypesGet(projectId, fut);
        }));
    }
    /**
     * List all Types
     * 
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3TypesGet(Handler<AsyncResult<WPTypes>> resultHandler) {
        delegate.apiV3TypesGet(resultHandler);
    }

    /**
     * List all Types
     * 
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<WPTypes> rxApiV3TypesGet() {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3TypesGet(fut);
        }));
    }
    /**
     * View Type
     * 
     * @param id type id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3TypesIdGet(Integer id, Handler<AsyncResult<WPType>> resultHandler) {
        delegate.apiV3TypesIdGet(id, resultHandler);
    }

    /**
     * View Type
     * 
     * @param id type id (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<WPType> rxApiV3TypesIdGet(Integer id) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3TypesIdGet(id, fut);
        }));
    }

    public static TypesApi newInstance(net.jbw.openproject.client.api.TypesApi arg) {
        return arg != null ? new TypesApi(arg) : null;
    }
}
