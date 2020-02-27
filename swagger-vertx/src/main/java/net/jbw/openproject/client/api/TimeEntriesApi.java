package net.jbw.openproject.client.api;

import net.jbw.openproject.client.model.TimeEntries;
import net.jbw.openproject.client.model.TimeEntry;
import net.jbw.openproject.client.model.TimeEntryPost;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;

import java.util.*;

public interface TimeEntriesApi {

    void apiV3TimeEntriesGet(Integer offset, Integer pageSize, String filters, Handler<AsyncResult<TimeEntries>> handler);

    void apiV3TimeEntriesIdGet(Integer id, Handler<AsyncResult<TimeEntry>> handler);

    void apiV3TimeEntriesPost(TimeEntryPost body, Integer offset, Integer pageSize, String filters, String sortBy, Handler<AsyncResult<Void>> handler);

}
