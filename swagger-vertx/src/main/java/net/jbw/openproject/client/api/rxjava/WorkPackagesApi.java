package net.jbw.openproject.client.api.rxjava;

import net.jbw.openproject.client.model.InlineObject7;
import net.jbw.openproject.client.model.InlineObject8;
import net.jbw.openproject.client.model.WorkPackage;
import net.jbw.openproject.client.model.WorkPackages;

import java.util.*;

import rx.Single;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;


public class WorkPackagesApi {

	private final net.jbw.openproject.client.api.WorkPackagesApi delegate;

	public WorkPackagesApi(net.jbw.openproject.client.api.WorkPackagesApi delegate) {
	    this.delegate = delegate;
    }

	public net.jbw.openproject.client.api.WorkPackagesApi getDelegate() {
	    return delegate;
	}

    /**
     * Work Package Create Form
     * 
     * @param id ID of the project in which the work package will be created (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3ProjectsIdWorkPackagesFormPost(Integer id, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3ProjectsIdWorkPackagesFormPost(id, resultHandler);
    }

    /**
     * Work Package Create Form
     * 
     * @param id ID of the project in which the work package will be created (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3ProjectsIdWorkPackagesFormPost(Integer id) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3ProjectsIdWorkPackagesFormPost(id, fut);
        }));
    }
    /**
     * List Work Packages
     * 
     * @param id Project id (required)
     * @param offset Page number inside the requested collection. (optional, default to 1)
     * @param pageSize Number of elements to display per page. (optional)
     * @param filters JSON specifying filter conditions. Accepts the same format as returned by the [queries](#queries) endpoint. (optional)
     * @param sortBy JSON specifying sort criteria. Accepts the same format as returned by the [queries](#queries) endpoint. (optional)
     * @param groupBy The column to group by. (optional)
     * @param showSums Indicates whether properties should be summed up if they support it. (optional, default to false)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3ProjectsIdWorkPackagesGet(Integer id, Integer offset, Integer pageSize, String filters, String sortBy, String groupBy, Boolean showSums, Handler<AsyncResult<WorkPackages>> resultHandler) {
        delegate.apiV3ProjectsIdWorkPackagesGet(id, offset, pageSize, filters, sortBy, groupBy, showSums, resultHandler);
    }

    /**
     * List Work Packages
     * 
     * @param id Project id (required)
     * @param offset Page number inside the requested collection. (optional, default to 1)
     * @param pageSize Number of elements to display per page. (optional)
     * @param filters JSON specifying filter conditions. Accepts the same format as returned by the [queries](#queries) endpoint. (optional)
     * @param sortBy JSON specifying sort criteria. Accepts the same format as returned by the [queries](#queries) endpoint. (optional)
     * @param groupBy The column to group by. (optional)
     * @param showSums Indicates whether properties should be summed up if they support it. (optional, default to false)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<WorkPackages> rxApiV3ProjectsIdWorkPackagesGet(Integer id, Integer offset, Integer pageSize, String filters, String sortBy, String groupBy, Boolean showSums) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3ProjectsIdWorkPackagesGet(id, offset, pageSize, filters, sortBy, groupBy, showSums, fut);
        }));
    }
    /**
     * Create Work Package
     * When calling this endpoint the client provides a single object, containing at least the properties and links that are required, in the body. The required fields of a WorkPackage can be found in its schema, which is embedded in the respective form. Note that it is only allowed to provide properties or links supporting the write operation.
     * @param id Project id (required)
     * @param workPackage Work package to add to the project (required)
     * @param notify Indicates whether change notifications (e.g. via E-Mail) should be sent. Note that this controls notifications for all users interested in changes to the work package (e.g. watchers, author and assignee), not just the current user. (optional, default to true)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3ProjectsIdWorkPackagesPost(Integer id, WorkPackage workPackage, Boolean notify, Handler<AsyncResult<WorkPackage>> resultHandler) {
        delegate.apiV3ProjectsIdWorkPackagesPost(id, workPackage, notify, resultHandler);
    }

    /**
     * Create Work Package
     * When calling this endpoint the client provides a single object, containing at least the properties and links that are required, in the body. The required fields of a WorkPackage can be found in its schema, which is embedded in the respective form. Note that it is only allowed to provide properties or links supporting the write operation.
     * @param id Project id (required)
     * @param workPackage Work package to add to the project (required)
     * @param notify Indicates whether change notifications (e.g. via E-Mail) should be sent. Note that this controls notifications for all users interested in changes to the work package (e.g. watchers, author and assignee), not just the current user. (optional, default to true)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<WorkPackage> rxApiV3ProjectsIdWorkPackagesPost(Integer id, WorkPackage workPackage, Boolean notify) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3ProjectsIdWorkPackagesPost(id, workPackage, notify, fut);
        }));
    }
    /**
     * Available assignees
     * Gets a list of users that can be assigned to work packages in the given project.
     * @param projectId Project id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3ProjectsProjectIdWorkPackagesAvailableAssigneesGet(Integer projectId, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3ProjectsProjectIdWorkPackagesAvailableAssigneesGet(projectId, resultHandler);
    }

    /**
     * Available assignees
     * Gets a list of users that can be assigned to work packages in the given project.
     * @param projectId Project id (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3ProjectsProjectIdWorkPackagesAvailableAssigneesGet(Integer projectId) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3ProjectsProjectIdWorkPackagesAvailableAssigneesGet(projectId, fut);
        }));
    }
    /**
     * Available responsibles
     * Gets a list of users that can be assigned as the responsible of a work package in the given project.
     * @param projectId Project id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3ProjectsProjectIdWorkPackagesAvailableResponsiblesGet(Integer projectId, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3ProjectsProjectIdWorkPackagesAvailableResponsiblesGet(projectId, resultHandler);
    }

    /**
     * Available responsibles
     * Gets a list of users that can be assigned as the responsible of a work package in the given project.
     * @param projectId Project id (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3ProjectsProjectIdWorkPackagesAvailableResponsiblesGet(Integer projectId) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3ProjectsProjectIdWorkPackagesAvailableResponsiblesGet(projectId, fut);
        }));
    }
    /**
     * Work Package Create Form
     * 
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3WorkPackagesFormPost(Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3WorkPackagesFormPost(resultHandler);
    }

    /**
     * Work Package Create Form
     * 
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3WorkPackagesFormPost() {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3WorkPackagesFormPost(fut);
        }));
    }
    /**
     * List Work Packages
     * 
     * @param offset Page number inside the requested collection. (optional, default to 1)
     * @param pageSize Number of elements to display per page. (optional)
     * @param filters JSON specifying filter conditions. Accepts the same format as returned by the [queries](#queries) endpoint. (optional)
     * @param sortBy JSON specifying sort criteria. Accepts the same format as returned by the [queries](#queries) endpoint. (optional)
     * @param groupBy The column to group by. (optional)
     * @param showSums Indicates whether properties should be summed up if they support it. (optional, default to false)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3WorkPackagesGet(Integer offset, Integer pageSize, String filters, String sortBy, String groupBy, Boolean showSums, Handler<AsyncResult<WorkPackages>> resultHandler) {
        delegate.apiV3WorkPackagesGet(offset, pageSize, filters, sortBy, groupBy, showSums, resultHandler);
    }

    /**
     * List Work Packages
     * 
     * @param offset Page number inside the requested collection. (optional, default to 1)
     * @param pageSize Number of elements to display per page. (optional)
     * @param filters JSON specifying filter conditions. Accepts the same format as returned by the [queries](#queries) endpoint. (optional)
     * @param sortBy JSON specifying sort criteria. Accepts the same format as returned by the [queries](#queries) endpoint. (optional)
     * @param groupBy The column to group by. (optional)
     * @param showSums Indicates whether properties should be summed up if they support it. (optional, default to false)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<WorkPackages> rxApiV3WorkPackagesGet(Integer offset, Integer pageSize, String filters, String sortBy, String groupBy, Boolean showSums) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3WorkPackagesGet(offset, pageSize, filters, sortBy, groupBy, showSums, fut);
        }));
    }
    /**
     * List work package activities
     * 
     * @param id Work package id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3WorkPackagesIdActivitiesGet(Integer id, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3WorkPackagesIdActivitiesGet(id, resultHandler);
    }

    /**
     * List work package activities
     * 
     * @param id Work package id (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3WorkPackagesIdActivitiesGet(Integer id) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3WorkPackagesIdActivitiesGet(id, fut);
        }));
    }
    /**
     * Comment work package
     * Creates an activity for the selected work package and, on success, returns the updated activity.
     * @param id Work package id (required)
     * @param notify Indicates whether change notifications (e.g. via E-Mail) should be sent. Note that this controls notifications for all users interested in changes to the work package (e.g. watchers, author and assignee), not just the current user. (optional, default to true)
     * @param body  (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3WorkPackagesIdActivitiesPost(Integer id, Boolean notify, InlineObject8 body, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3WorkPackagesIdActivitiesPost(id, notify, body, resultHandler);
    }

    /**
     * Comment work package
     * Creates an activity for the selected work package and, on success, returns the updated activity.
     * @param id Work package id (required)
     * @param notify Indicates whether change notifications (e.g. via E-Mail) should be sent. Note that this controls notifications for all users interested in changes to the work package (e.g. watchers, author and assignee), not just the current user. (optional, default to true)
     * @param body  (optional)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3WorkPackagesIdActivitiesPost(Integer id, Boolean notify, InlineObject8 body) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3WorkPackagesIdActivitiesPost(id, notify, body, fut);
        }));
    }
    /**
     * Available projects
     * Gets a list of projects that are available as projects to which the work package can be moved.
     * @param id work package id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3WorkPackagesIdAvailableProjectsGet(Integer id, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3WorkPackagesIdAvailableProjectsGet(id, resultHandler);
    }

    /**
     * Available projects
     * Gets a list of projects that are available as projects to which the work package can be moved.
     * @param id work package id (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3WorkPackagesIdAvailableProjectsGet(Integer id) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3WorkPackagesIdAvailableProjectsGet(id, fut);
        }));
    }
    /**
     * Available relation candidates
     * 
     * @param id ID of workpackage to return (required)
     * @param pageSize Maximum number of candidates to list (default 10) (optional)
     * @param filters JSON specifying filter conditions. Accepts the same format as returned by the [queries](#queries) endpoint. (optional)
     * @param query Shortcut for filtering by ID or subject (optional)
     * @param type Type of relation to find candidates for (default \&quot;relates\&quot;) (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3WorkPackagesIdAvailableRelationCandidatesGet(Long id, Integer pageSize, String filters, String query, String type, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3WorkPackagesIdAvailableRelationCandidatesGet(id, pageSize, filters, query, type, resultHandler);
    }

    /**
     * Available relation candidates
     * 
     * @param id ID of workpackage to return (required)
     * @param pageSize Maximum number of candidates to list (default 10) (optional)
     * @param filters JSON specifying filter conditions. Accepts the same format as returned by the [queries](#queries) endpoint. (optional)
     * @param query Shortcut for filtering by ID or subject (optional)
     * @param type Type of relation to find candidates for (default \&quot;relates\&quot;) (optional)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3WorkPackagesIdAvailableRelationCandidatesGet(Long id, Integer pageSize, String filters, String query, String type) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3WorkPackagesIdAvailableRelationCandidatesGet(id, pageSize, filters, query, type, fut);
        }));
    }
    /**
     * Available watchers
     * Gets a list of users that are able to be watchers of the specified work package.
     * @param id work package id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3WorkPackagesIdAvailableWatchersGet(Integer id, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3WorkPackagesIdAvailableWatchersGet(id, resultHandler);
    }

    /**
     * Available watchers
     * Gets a list of users that are able to be watchers of the specified work package.
     * @param id work package id (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3WorkPackagesIdAvailableWatchersGet(Integer id) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3WorkPackagesIdAvailableWatchersGet(id, fut);
        }));
    }
    /**
     * Delete Work Package
     * Deletes the work package, as well as:  * all associated time entries  * its hierarchy of child work packages
     * @param id Work package id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3WorkPackagesIdDelete(Integer id, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3WorkPackagesIdDelete(id, resultHandler);
    }

    /**
     * Delete Work Package
     * Deletes the work package, as well as:  * all associated time entries  * its hierarchy of child work packages
     * @param id Work package id (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3WorkPackagesIdDelete(Integer id) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3WorkPackagesIdDelete(id, fut);
        }));
    }
    /**
     * Work Package Edit Form
     * 
     * @param id ID of the work package being modified (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3WorkPackagesIdFormPost(Integer id, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3WorkPackagesIdFormPost(id, resultHandler);
    }

    /**
     * Work Package Edit Form
     * 
     * @param id ID of the work package being modified (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3WorkPackagesIdFormPost(Integer id) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3WorkPackagesIdFormPost(id, fut);
        }));
    }
    /**
     * View Work Package
     * 
     * @param id Work package id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3WorkPackagesIdGet(Integer id, Handler<AsyncResult<WorkPackage>> resultHandler) {
        delegate.apiV3WorkPackagesIdGet(id, resultHandler);
    }

    /**
     * View Work Package
     * 
     * @param id Work package id (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<WorkPackage> rxApiV3WorkPackagesIdGet(Integer id) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3WorkPackagesIdGet(id, fut);
        }));
    }
    /**
     * Edit Work Package
     * When calling this endpoint the client provides a single object, containing the properties and links that it wants to change, in the body. Note that it is only allowed to provide properties or links supporting the **write** operation.  Additionally to the fields the client wants to change, it is mandatory to provide the value of &#x60;lockVersion&#x60; which was received by the &#x60;GET&#x60; request this change originates from.  The value of &#x60;lockVersion&#x60; is used to implement [optimistic locking](http://en.wikipedia.org/wiki/Optimistic_concurrency_control).
     * @param id Work package id (required)
     * @param notify Indicates whether change notifications (e.g. via E-Mail) should be sent. Note that this controls notifications for all users interested in changes to the work package (e.g. watchers, author and assignee), not just the current user. (optional, default to true)
     * @param body  (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3WorkPackagesIdPatch(Integer id, Boolean notify, WorkPackage body, Handler<AsyncResult<WorkPackage>> resultHandler) {
        delegate.apiV3WorkPackagesIdPatch(id, notify, body, resultHandler);
    }

    /**
     * Edit Work Package
     * When calling this endpoint the client provides a single object, containing the properties and links that it wants to change, in the body. Note that it is only allowed to provide properties or links supporting the **write** operation.  Additionally to the fields the client wants to change, it is mandatory to provide the value of &#x60;lockVersion&#x60; which was received by the &#x60;GET&#x60; request this change originates from.  The value of &#x60;lockVersion&#x60; is used to implement [optimistic locking](http://en.wikipedia.org/wiki/Optimistic_concurrency_control).
     * @param id Work package id (required)
     * @param notify Indicates whether change notifications (e.g. via E-Mail) should be sent. Note that this controls notifications for all users interested in changes to the work package (e.g. watchers, author and assignee), not just the current user. (optional, default to true)
     * @param body  (optional)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<WorkPackage> rxApiV3WorkPackagesIdPatch(Integer id, Boolean notify, WorkPackage body) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3WorkPackagesIdPatch(id, notify, body, fut);
        }));
    }
    /**
     * Relation create form
     * 
     * @param id ID of the relation being modified (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3WorkPackagesIdRelationsFormPost(Integer id, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3WorkPackagesIdRelationsFormPost(id, resultHandler);
    }

    /**
     * Relation create form
     * 
     * @param id ID of the relation being modified (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3WorkPackagesIdRelationsFormPost(Integer id) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3WorkPackagesIdRelationsFormPost(id, fut);
        }));
    }
    /**
     * Revisions
     * Gets a list of revisions that are linked to this work package, e.g., because it is referenced in the commit message of the revision. Only linked revisions from repositories are shown if the user has the view changesets permission in the defining project.
     * @param id work package id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3WorkPackagesIdRevisionsGet(Integer id, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3WorkPackagesIdRevisionsGet(id, resultHandler);
    }

    /**
     * Revisions
     * Gets a list of revisions that are linked to this work package, e.g., because it is referenced in the commit message of the revision. Only linked revisions from repositories are shown if the user has the view changesets permission in the defining project.
     * @param id work package id (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3WorkPackagesIdRevisionsGet(Integer id) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3WorkPackagesIdRevisionsGet(id, fut);
        }));
    }
    /**
     * Create Work Package
     * When calling this endpoint the client provides a single object, containing at least the properties and links that are required, in the body. The required fields of a WorkPackage can be found in its schema, which is embedded in the respective form. Note that it is only allowed to provide properties or links supporting the write operation.  A project link must be set when creating work packages through this route.
     * @param workPackage Work package to add (a project link is requried) (required)
     * @param notify Indicates whether change notifications (e.g. via E-Mail) should be sent. Note that this controls notifications for all users interested in changes to the work package (e.g. watchers, author and assignee), not just the current user. (optional, default to true)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3WorkPackagesPost(WorkPackage workPackage, Boolean notify, Handler<AsyncResult<WorkPackage>> resultHandler) {
        delegate.apiV3WorkPackagesPost(workPackage, notify, resultHandler);
    }

    /**
     * Create Work Package
     * When calling this endpoint the client provides a single object, containing at least the properties and links that are required, in the body. The required fields of a WorkPackage can be found in its schema, which is embedded in the respective form. Note that it is only allowed to provide properties or links supporting the write operation.  A project link must be set when creating work packages through this route.
     * @param workPackage Work package to add (a project link is requried) (required)
     * @param notify Indicates whether change notifications (e.g. via E-Mail) should be sent. Note that this controls notifications for all users interested in changes to the work package (e.g. watchers, author and assignee), not just the current user. (optional, default to true)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<WorkPackage> rxApiV3WorkPackagesPost(WorkPackage workPackage, Boolean notify) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3WorkPackagesPost(workPackage, notify, fut);
        }));
    }
    /**
     * List Work Package Schemas
     * List work package schemas.
     * @param filters JSON specifying filter conditions. Accepts the same format as returned by the [queries](#queries) endpoint. Currently supported filters are:  + id: The schema&#39;s id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3WorkPackagesSchemasGet(String filters, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3WorkPackagesSchemasGet(filters, resultHandler);
    }

    /**
     * List Work Package Schemas
     * List work package schemas.
     * @param filters JSON specifying filter conditions. Accepts the same format as returned by the [queries](#queries) endpoint. Currently supported filters are:  + id: The schema&#39;s id (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3WorkPackagesSchemasGet(String filters) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3WorkPackagesSchemasGet(filters, fut);
        }));
    }
    /**
     * View Work Package Schema
     * 
     * @param identifier Identifier of the schema (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3WorkPackagesSchemasIdentifierGet(String identifier, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3WorkPackagesSchemasIdentifierGet(identifier, resultHandler);
    }

    /**
     * View Work Package Schema
     * 
     * @param identifier Identifier of the schema (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3WorkPackagesSchemasIdentifierGet(String identifier) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3WorkPackagesSchemasIdentifierGet(identifier, fut);
        }));
    }
    /**
     * List relations
     * Lists all relations this work package is involved in.
     * @param workPackageId Work package id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3WorkPackagesWorkPackageIdRelationsGet(Integer workPackageId, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3WorkPackagesWorkPackageIdRelationsGet(workPackageId, resultHandler);
    }

    /**
     * List relations
     * Lists all relations this work package is involved in.
     * @param workPackageId Work package id (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3WorkPackagesWorkPackageIdRelationsGet(Integer workPackageId) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3WorkPackagesWorkPackageIdRelationsGet(workPackageId, fut);
        }));
    }
    /**
     * Create Relation
     * When calling this endpoint the client provides a single object, containing at least the properties and links that are required, in the body. The required fields of a Relation can be found in its schema, which is embedded in the respective form. Note that it is only allowed to provide properties or links supporting the write operation.
     * @param workPackageId Work package id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3WorkPackagesWorkPackageIdRelationsPost(Integer workPackageId, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3WorkPackagesWorkPackageIdRelationsPost(workPackageId, resultHandler);
    }

    /**
     * Create Relation
     * When calling this endpoint the client provides a single object, containing at least the properties and links that are required, in the body. The required fields of a Relation can be found in its schema, which is embedded in the respective form. Note that it is only allowed to provide properties or links supporting the write operation.
     * @param workPackageId Work package id (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3WorkPackagesWorkPackageIdRelationsPost(Integer workPackageId) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3WorkPackagesWorkPackageIdRelationsPost(workPackageId, fut);
        }));
    }
    /**
     * List watchers
     * 
     * @param workPackageId Work package id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3WorkPackagesWorkPackageIdWatchersGet(Integer workPackageId, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3WorkPackagesWorkPackageIdWatchersGet(workPackageId, resultHandler);
    }

    /**
     * List watchers
     * 
     * @param workPackageId Work package id (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3WorkPackagesWorkPackageIdWatchersGet(Integer workPackageId) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3WorkPackagesWorkPackageIdWatchersGet(workPackageId, fut);
        }));
    }
    /**
     * Remove watcher
     * Removes the specified user from the list of watchers for the given work package.  If the request succeeds, the specified user is not watching the work package anymore.  *Note: This might also be the case, if the specified user did not watch the work package prior to the request.*
     * @param workPackageId Work package id (required)
     * @param id User id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3WorkPackagesWorkPackageIdWatchersIdDelete(Integer workPackageId, Integer id, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3WorkPackagesWorkPackageIdWatchersIdDelete(workPackageId, id, resultHandler);
    }

    /**
     * Remove watcher
     * Removes the specified user from the list of watchers for the given work package.  If the request succeeds, the specified user is not watching the work package anymore.  *Note: This might also be the case, if the specified user did not watch the work package prior to the request.*
     * @param workPackageId Work package id (required)
     * @param id User id (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3WorkPackagesWorkPackageIdWatchersIdDelete(Integer workPackageId, Integer id) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3WorkPackagesWorkPackageIdWatchersIdDelete(workPackageId, id, fut);
        }));
    }
    /**
     * Add watcher
     * Adds a watcher to the specified work package.  The request is expected to contain a single JSON object, that contains a link object under the &#x60;user&#x60; key.  The response will be user added as watcher. In case the user was already watching the work package an &#x60;HTTP 200&#x60; is returned, an &#x60;HTTP 201&#x60; if the user was added as a new watcher.
     * @param workPackageId Work package id (required)
     * @param body  (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3WorkPackagesWorkPackageIdWatchersPost(Integer workPackageId, InlineObject7 body, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3WorkPackagesWorkPackageIdWatchersPost(workPackageId, body, resultHandler);
    }

    /**
     * Add watcher
     * Adds a watcher to the specified work package.  The request is expected to contain a single JSON object, that contains a link object under the &#x60;user&#x60; key.  The response will be user added as watcher. In case the user was already watching the work package an &#x60;HTTP 200&#x60; is returned, an &#x60;HTTP 201&#x60; if the user was added as a new watcher.
     * @param workPackageId Work package id (required)
     * @param body  (optional)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3WorkPackagesWorkPackageIdWatchersPost(Integer workPackageId, InlineObject7 body) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3WorkPackagesWorkPackageIdWatchersPost(workPackageId, body, fut);
        }));
    }

    public static WorkPackagesApi newInstance(net.jbw.openproject.client.api.WorkPackagesApi arg) {
        return arg != null ? new WorkPackagesApi(arg) : null;
    }
}
