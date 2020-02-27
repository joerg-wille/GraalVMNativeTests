package net.jbw.openproject.client.api;

import net.jbw.openproject.client.model.TimeEntriesActivity;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;

import java.util.*;

public interface TimeEntryActivitiesApi {

    void apiV3TimeEntriesActivitiesIdGet(Integer id, Handler<AsyncResult<TimeEntriesActivity>> handler);

}
