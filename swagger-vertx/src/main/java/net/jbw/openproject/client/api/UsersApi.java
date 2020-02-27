package net.jbw.openproject.client.api;

import net.jbw.openproject.client.model.InlineObject5;
import net.jbw.openproject.client.model.InlineObject6;
import net.jbw.openproject.client.model.User;
import net.jbw.openproject.client.model.Users;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;

import java.util.*;

public interface UsersApi {

    void apiV3UsersGet(Integer offset, Integer pageSize, String filters, String sortBy, Handler<AsyncResult<Users>> handler);

    void apiV3UsersIdDelete(Integer id, Handler<AsyncResult<Void>> handler);

    void apiV3UsersIdGet(String id, Handler<AsyncResult<User>> handler);

    void apiV3UsersIdLockDelete(Integer id, Handler<AsyncResult<Void>> handler);

    void apiV3UsersIdLockPost(Integer id, Handler<AsyncResult<Void>> handler);

    void apiV3UsersIdPatch(Integer id, InlineObject5 body, Handler<AsyncResult<Void>> handler);

    void apiV3UsersPost(InlineObject6 body, Handler<AsyncResult<Void>> handler);

}
