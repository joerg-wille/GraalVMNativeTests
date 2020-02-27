package net.jbw.openproject.client.api.rxjava;

import net.jbw.openproject.client.model.TimeEntries;
import net.jbw.openproject.client.model.TimeEntry;
import net.jbw.openproject.client.model.TimeEntryPost;

import java.util.*;

import rx.Single;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;


public class TimeEntriesApi {

	private final net.jbw.openproject.client.api.TimeEntriesApi delegate;

	public TimeEntriesApi(net.jbw.openproject.client.api.TimeEntriesApi delegate) {
	    this.delegate = delegate;
    }

	public net.jbw.openproject.client.api.TimeEntriesApi getDelegate() {
	    return delegate;
	}

    /**
     * List Time entries
     * Lists time entries. The time entries returned depend on the filters provided and also on the permission of the requesting user.
     * @param offset Page number inside the requested collection. (optional, default to 1)
     * @param pageSize Number of elements to display per page. (optional)
     * @param filters JSON specifying filter conditions. Accepts the same format as returned by the [queries](#queries) endpoint. Currently supported filters are:  + work_package: Filter time entries by work package  + project: Filter time entries by project  + user: Filter time entries by users (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3TimeEntriesGet(Integer offset, Integer pageSize, String filters, Handler<AsyncResult<TimeEntries>> resultHandler) {
        delegate.apiV3TimeEntriesGet(offset, pageSize, filters, resultHandler);
    }

    /**
     * List Time entries
     * Lists time entries. The time entries returned depend on the filters provided and also on the permission of the requesting user.
     * @param offset Page number inside the requested collection. (optional, default to 1)
     * @param pageSize Number of elements to display per page. (optional)
     * @param filters JSON specifying filter conditions. Accepts the same format as returned by the [queries](#queries) endpoint. Currently supported filters are:  + work_package: Filter time entries by work package  + project: Filter time entries by project  + user: Filter time entries by users (optional)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<TimeEntries> rxApiV3TimeEntriesGet(Integer offset, Integer pageSize, String filters) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3TimeEntriesGet(offset, pageSize, filters, fut);
        }));
    }
    /**
     * View time entry
     * 
     * @param id time entry id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3TimeEntriesIdGet(Integer id, Handler<AsyncResult<TimeEntry>> resultHandler) {
        delegate.apiV3TimeEntriesIdGet(id, resultHandler);
    }

    /**
     * View time entry
     * 
     * @param id time entry id (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<TimeEntry> rxApiV3TimeEntriesIdGet(Integer id) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3TimeEntriesIdGet(id, fut);
        }));
    }
    /**
     * Create time entry
     * Creates a new time entry applying the attributes provided in the body. Please note that while there is a fixed set of attributes, custom fields can extend a time entries’ attributes and are accepted by the endpoint.
     * @param body Time Entry to add (a project, activity and workPackage link is requried) (required)
     * @param offset Page number inside the requested collection. (optional, default to 1)
     * @param pageSize Number of elements to display per page. (optional)
     * @param filters JSON specifying filter conditions. Accepts the same format as returned by the [queries](#queries) endpoint. (optional)
     * @param sortBy JSON specifying sort criteria. Accepts the same format as returned by the [queries](#queries) endpoint. (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3TimeEntriesPost(TimeEntryPost body, Integer offset, Integer pageSize, String filters, String sortBy, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3TimeEntriesPost(body, offset, pageSize, filters, sortBy, resultHandler);
    }

    /**
     * Create time entry
     * Creates a new time entry applying the attributes provided in the body. Please note that while there is a fixed set of attributes, custom fields can extend a time entries’ attributes and are accepted by the endpoint.
     * @param body Time Entry to add (a project, activity and workPackage link is requried) (required)
     * @param offset Page number inside the requested collection. (optional, default to 1)
     * @param pageSize Number of elements to display per page. (optional)
     * @param filters JSON specifying filter conditions. Accepts the same format as returned by the [queries](#queries) endpoint. (optional)
     * @param sortBy JSON specifying sort criteria. Accepts the same format as returned by the [queries](#queries) endpoint. (optional)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3TimeEntriesPost(TimeEntryPost body, Integer offset, Integer pageSize, String filters, String sortBy) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3TimeEntriesPost(body, offset, pageSize, filters, sortBy, fut);
        }));
    }

    public static TimeEntriesApi newInstance(net.jbw.openproject.client.api.TimeEntriesApi arg) {
        return arg != null ? new TimeEntriesApi(arg) : null;
    }
}
