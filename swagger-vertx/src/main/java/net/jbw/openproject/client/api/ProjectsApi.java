package net.jbw.openproject.client.api;

import net.jbw.openproject.client.model.Project;
import net.jbw.openproject.client.model.Projects;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;

import java.util.*;

public interface ProjectsApi {

    void apiV3ProjectsGet(String filters, Handler<AsyncResult<Projects>> handler);

    void apiV3ProjectsIdGet(Integer id, Handler<AsyncResult<Project>> handler);

    void apiV3VersionsIdProjectsGet(Integer id, Handler<AsyncResult<Void>> handler);

}
