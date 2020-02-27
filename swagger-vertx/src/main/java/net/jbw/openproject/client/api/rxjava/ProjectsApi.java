package net.jbw.openproject.client.api.rxjava;

import net.jbw.openproject.client.model.Project;
import net.jbw.openproject.client.model.Projects;

import java.util.*;

import rx.Single;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;


public class ProjectsApi {

	private final net.jbw.openproject.client.api.ProjectsApi delegate;

	public ProjectsApi(net.jbw.openproject.client.api.ProjectsApi delegate) {
	    this.delegate = delegate;
    }

	public net.jbw.openproject.client.api.ProjectsApi getDelegate() {
	    return delegate;
	}

    /**
     * List projects
     * Returns a collection of projects. The collection can be filtered via query parameters similar to how work packages are filtered. In addition to the provided filter, the result set is always limited to only contain projects the client is allowed to see.
     * @param filters JSON specifying filter conditions. Accepts the same format as returned by the [queries](#queries) endpoint. Currently supported filters are:  + ancestor: filters projects by their ancestor. A project is not considered to be it&#39;s own ancestor. (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3ProjectsGet(String filters, Handler<AsyncResult<Projects>> resultHandler) {
        delegate.apiV3ProjectsGet(filters, resultHandler);
    }

    /**
     * List projects
     * Returns a collection of projects. The collection can be filtered via query parameters similar to how work packages are filtered. In addition to the provided filter, the result set is always limited to only contain projects the client is allowed to see.
     * @param filters JSON specifying filter conditions. Accepts the same format as returned by the [queries](#queries) endpoint. Currently supported filters are:  + ancestor: filters projects by their ancestor. A project is not considered to be it&#39;s own ancestor. (optional)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Projects> rxApiV3ProjectsGet(String filters) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3ProjectsGet(filters, fut);
        }));
    }
    /**
     * View project
     * 
     * @param id Project id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3ProjectsIdGet(Integer id, Handler<AsyncResult<Project>> resultHandler) {
        delegate.apiV3ProjectsIdGet(id, resultHandler);
    }

    /**
     * View project
     * 
     * @param id Project id (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Project> rxApiV3ProjectsIdGet(Integer id) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3ProjectsIdGet(id, fut);
        }));
    }
    /**
     * List projects with version
     * This endpoint lists the projects where the given version is available.  The projects returned depend on the sharing settings of the given version, but are also limited to the projects that the current user is allowed to see.
     * @param id Version id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3VersionsIdProjectsGet(Integer id, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3VersionsIdProjectsGet(id, resultHandler);
    }

    /**
     * List projects with version
     * This endpoint lists the projects where the given version is available.  The projects returned depend on the sharing settings of the given version, but are also limited to the projects that the current user is allowed to see.
     * @param id Version id (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3VersionsIdProjectsGet(Integer id) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3VersionsIdProjectsGet(id, fut);
        }));
    }

    public static ProjectsApi newInstance(net.jbw.openproject.client.api.ProjectsApi arg) {
        return arg != null ? new ProjectsApi(arg) : null;
    }
}
