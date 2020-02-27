package net.jbw.openproject.client.api.rxjava;

import net.jbw.openproject.client.model.TimeEntriesActivity;

import java.util.*;

import rx.Single;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;


public class TimeEntryActivitiesApi {

	private final net.jbw.openproject.client.api.TimeEntryActivitiesApi delegate;

	public TimeEntryActivitiesApi(net.jbw.openproject.client.api.TimeEntryActivitiesApi delegate) {
	    this.delegate = delegate;
    }

	public net.jbw.openproject.client.api.TimeEntryActivitiesApi getDelegate() {
	    return delegate;
	}

    /**
     * View time entries activity
     * 
     * @param id time entries activity id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3TimeEntriesActivitiesIdGet(Integer id, Handler<AsyncResult<TimeEntriesActivity>> resultHandler) {
        delegate.apiV3TimeEntriesActivitiesIdGet(id, resultHandler);
    }

    /**
     * View time entries activity
     * 
     * @param id time entries activity id (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<TimeEntriesActivity> rxApiV3TimeEntriesActivitiesIdGet(Integer id) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3TimeEntriesActivitiesIdGet(id, fut);
        }));
    }

    public static TimeEntryActivitiesApi newInstance(net.jbw.openproject.client.api.TimeEntryActivitiesApi arg) {
        return arg != null ? new TimeEntryActivitiesApi(arg) : null;
    }
}
