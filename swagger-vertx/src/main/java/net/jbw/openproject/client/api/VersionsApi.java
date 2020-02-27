package net.jbw.openproject.client.api;

import net.jbw.openproject.client.model.Version;
import net.jbw.openproject.client.model.Versions;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;

import java.util.*;

public interface VersionsApi {

    void apiV3ProjectsProjectIdVersionsGet(Integer projectId, Handler<AsyncResult<Versions>> handler);

    void apiV3VersionsGet(String filters, Handler<AsyncResult<Versions>> handler);

    void apiV3VersionsIdGet(Integer id, Handler<AsyncResult<Version>> handler);

}
