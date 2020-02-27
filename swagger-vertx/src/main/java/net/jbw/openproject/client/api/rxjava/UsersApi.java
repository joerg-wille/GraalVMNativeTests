package net.jbw.openproject.client.api.rxjava;

import net.jbw.openproject.client.model.InlineObject5;
import net.jbw.openproject.client.model.InlineObject6;
import net.jbw.openproject.client.model.User;
import net.jbw.openproject.client.model.Users;

import java.util.*;

import rx.Single;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;


public class UsersApi {

	private final net.jbw.openproject.client.api.UsersApi delegate;

	public UsersApi(net.jbw.openproject.client.api.UsersApi delegate) {
	    this.delegate = delegate;
    }

	public net.jbw.openproject.client.api.UsersApi getDelegate() {
	    return delegate;
	}

    /**
     * List Users
     * Lists users. Only administrators have permission to do this.
     * @param offset Page number inside the requested collection. (optional, default to 1)
     * @param pageSize Number of elements to display per page. (optional)
     * @param filters JSON specifying filter conditions. Accepts the same format as returned by the [queries](#queries) endpoint. Currently supported filters are:  + status: Status the user has  + group: Name of the group in which to-be-listed users are members.  + name: Filter users in whose first or last names, or email addresses the given string occurs.  + login: User&#39;s login (optional)
     * @param sortBy JSON specifying sort criteria. Accepts the same format as returned by the [queries](#queries) endpoint. (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3UsersGet(Integer offset, Integer pageSize, String filters, String sortBy, Handler<AsyncResult<Users>> resultHandler) {
        delegate.apiV3UsersGet(offset, pageSize, filters, sortBy, resultHandler);
    }

    /**
     * List Users
     * Lists users. Only administrators have permission to do this.
     * @param offset Page number inside the requested collection. (optional, default to 1)
     * @param pageSize Number of elements to display per page. (optional)
     * @param filters JSON specifying filter conditions. Accepts the same format as returned by the [queries](#queries) endpoint. Currently supported filters are:  + status: Status the user has  + group: Name of the group in which to-be-listed users are members.  + name: Filter users in whose first or last names, or email addresses the given string occurs.  + login: User&#39;s login (optional)
     * @param sortBy JSON specifying sort criteria. Accepts the same format as returned by the [queries](#queries) endpoint. (optional)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Users> rxApiV3UsersGet(Integer offset, Integer pageSize, String filters, String sortBy) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3UsersGet(offset, pageSize, filters, sortBy, fut);
        }));
    }
    /**
     * Delete user
     * Permanently deletes the specified user account.
     * @param id User id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3UsersIdDelete(Integer id, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3UsersIdDelete(id, resultHandler);
    }

    /**
     * Delete user
     * Permanently deletes the specified user account.
     * @param id User id (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3UsersIdDelete(Integer id) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3UsersIdDelete(id, fut);
        }));
    }
    /**
     * View user
     * 
     * @param id User id. Use &#x60;me&#x60; to reference current user, if any. (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3UsersIdGet(String id, Handler<AsyncResult<User>> resultHandler) {
        delegate.apiV3UsersIdGet(id, resultHandler);
    }

    /**
     * View user
     * 
     * @param id User id. Use &#x60;me&#x60; to reference current user, if any. (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<User> rxApiV3UsersIdGet(String id) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3UsersIdGet(id, fut);
        }));
    }
    /**
     * Remove Lock
     * 
     * @param id User id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3UsersIdLockDelete(Integer id, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3UsersIdLockDelete(id, resultHandler);
    }

    /**
     * Remove Lock
     * 
     * @param id User id (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3UsersIdLockDelete(Integer id) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3UsersIdLockDelete(id, fut);
        }));
    }
    /**
     * Set Lock
     * 
     * @param id User id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3UsersIdLockPost(Integer id, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3UsersIdLockPost(id, resultHandler);
    }

    /**
     * Set Lock
     * 
     * @param id User id (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3UsersIdLockPost(Integer id) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3UsersIdLockPost(id, fut);
        }));
    }
    /**
     * Update user
     * Updates the user&#39;s writable attributes. When calling this endpoint the client provides a single object, containing at least the properties and links that are required, in the body.
     * @param id User id (required)
     * @param body  (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3UsersIdPatch(Integer id, InlineObject5 body, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3UsersIdPatch(id, body, resultHandler);
    }

    /**
     * Update user
     * Updates the user&#39;s writable attributes. When calling this endpoint the client provides a single object, containing at least the properties and links that are required, in the body.
     * @param id User id (required)
     * @param body  (optional)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3UsersIdPatch(Integer id, InlineObject5 body) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3UsersIdPatch(id, body, fut);
        }));
    }
    /**
     * Create User
     * Creates a new user. Only administrators have permission to do so. When calling this endpoint the client provides a single object, containing at least the properties and links that are required, in the body.  Valid values for &#x60;status&#x60;:  1) \&quot;active\&quot; - In this case a password has to be provided in addition to the other attributes. 2) \&quot;invited\&quot; - In this case nothing but the email address is required. The rest is optional. An invitation will be sent to the user.
     * @param body  (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3UsersPost(InlineObject6 body, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3UsersPost(body, resultHandler);
    }

    /**
     * Create User
     * Creates a new user. Only administrators have permission to do so. When calling this endpoint the client provides a single object, containing at least the properties and links that are required, in the body.  Valid values for &#x60;status&#x60;:  1) \&quot;active\&quot; - In this case a password has to be provided in addition to the other attributes. 2) \&quot;invited\&quot; - In this case nothing but the email address is required. The rest is optional. An invitation will be sent to the user.
     * @param body  (optional)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3UsersPost(InlineObject6 body) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3UsersPost(body, fut);
        }));
    }

    public static UsersApi newInstance(net.jbw.openproject.client.api.UsersApi arg) {
        return arg != null ? new UsersApi(arg) : null;
    }
}
