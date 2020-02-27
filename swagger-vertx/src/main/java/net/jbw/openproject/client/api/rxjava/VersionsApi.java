package net.jbw.openproject.client.api.rxjava;

import net.jbw.openproject.client.model.Version;
import net.jbw.openproject.client.model.Versions;

import java.util.*;

import rx.Single;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;


public class VersionsApi {

	private final net.jbw.openproject.client.api.VersionsApi delegate;

	public VersionsApi(net.jbw.openproject.client.api.VersionsApi delegate) {
	    this.delegate = delegate;
    }

	public net.jbw.openproject.client.api.VersionsApi getDelegate() {
	    return delegate;
	}

    /**
     * List versions available in a project
     * This endpoint lists the versions that are *available* in a given project. Note that due to sharing this might be more than the versions *defined* by that project.
     * @param projectId ID of the project whoose versions will be listed (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3ProjectsProjectIdVersionsGet(Integer projectId, Handler<AsyncResult<Versions>> resultHandler) {
        delegate.apiV3ProjectsProjectIdVersionsGet(projectId, resultHandler);
    }

    /**
     * List versions available in a project
     * This endpoint lists the versions that are *available* in a given project. Note that due to sharing this might be more than the versions *defined* by that project.
     * @param projectId ID of the project whoose versions will be listed (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Versions> rxApiV3ProjectsProjectIdVersionsGet(Integer projectId) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3ProjectsProjectIdVersionsGet(projectId, fut);
        }));
    }
    /**
     * List versions
     * Returns a collection of versions. The client can choose to filter the versions similar to how work packages are filtered. In addition to the provided filters, the server will reduce the result set to only contain versions, for which the requesting client has sufficient permissions (*view_work_packages*).
     * @param filters JSON specifying filter conditions. Accepts the same format as returned by the [queries](#queries) endpoint. Currently supported filters are:  + sharing: filters versions by how they are shared within the server (*none*, *descendants*, *hierarchy*, *tree*, *system*). (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3VersionsGet(String filters, Handler<AsyncResult<Versions>> resultHandler) {
        delegate.apiV3VersionsGet(filters, resultHandler);
    }

    /**
     * List versions
     * Returns a collection of versions. The client can choose to filter the versions similar to how work packages are filtered. In addition to the provided filters, the server will reduce the result set to only contain versions, for which the requesting client has sufficient permissions (*view_work_packages*).
     * @param filters JSON specifying filter conditions. Accepts the same format as returned by the [queries](#queries) endpoint. Currently supported filters are:  + sharing: filters versions by how they are shared within the server (*none*, *descendants*, *hierarchy*, *tree*, *system*). (optional)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Versions> rxApiV3VersionsGet(String filters) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3VersionsGet(filters, fut);
        }));
    }
    /**
     * View version
     * 
     * @param id version id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3VersionsIdGet(Integer id, Handler<AsyncResult<Version>> resultHandler) {
        delegate.apiV3VersionsIdGet(id, resultHandler);
    }

    /**
     * View version
     * 
     * @param id version id (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Version> rxApiV3VersionsIdGet(Integer id) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3VersionsIdGet(id, fut);
        }));
    }

    public static VersionsApi newInstance(net.jbw.openproject.client.api.VersionsApi arg) {
        return arg != null ? new VersionsApi(arg) : null;
    }
}
