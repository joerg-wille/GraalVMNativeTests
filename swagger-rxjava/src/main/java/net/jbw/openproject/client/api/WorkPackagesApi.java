package net.jbw.openproject.client.api;

import io.reactivex.Observable;
import net.jbw.openproject.client.model.WorkPackage;
import net.jbw.openproject.client.model.WorkPackages;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.POST;

public interface WorkPackagesApi {
  /**
   * Work Package Create Form
   * 
   * @param id ID of the project in which the work package will be created (required)
   * @return Call&lt;Void&gt;
   */
  @POST("api/v3/projects/{id}/work_packages/form")
  Observable<Void> apiV3ProjectsIdWorkPackagesFormPost(
            @retrofit2.http.Path("id") Integer id            
  );

  /**
   * List Work Packages
   * 
   * @param id Project id (required)
   * @param offset Page number inside the requested collection. (optional)
   * @param pageSize Number of elements to display per page. (optional)
   * @param filters JSON specifying filter conditions. Accepts the same format as returned by the [queries](#queries) endpoint. (optional)
   * @param sortBy JSON specifying sort criteria. Accepts the same format as returned by the [queries](#queries) endpoint. (optional)
   * @param groupBy The column to group by. (optional)
   * @param showSums Indicates whether properties should be summed up if they support it. (optional)
   * @return Call&lt;WorkPackages&gt;
   */
  @GET("api/v3/projects/{id}/work_packages")
  Observable<WorkPackages> apiV3ProjectsIdWorkPackagesGet(
            @retrofit2.http.Path("id") Integer id            ,     @retrofit2.http.Query("offset") Integer offset                ,     @retrofit2.http.Query("pageSize") Integer pageSize                ,     @retrofit2.http.Query("filters") String filters                ,     @retrofit2.http.Query("sortBy") String sortBy                ,     @retrofit2.http.Query("groupBy") String groupBy                ,     @retrofit2.http.Query("showSums") Boolean showSums                
  );

  /**
   * Create Work Package
   * When calling this endpoint the client provides a single object, containing at least the properties and links that are required, in the body. The required fields of a WorkPackage can be found in its schema, which is embedded in the respective form. Note that it is only allowed to provide properties or links supporting the write operation.
   * @param body Work package to add to the project (required)
   * @param id Project id (required)
   * @param notify Indicates whether change notifications (e.g. via E-Mail) should be sent. Note that this controls notifications for all users interested in changes to the work package (e.g. watchers, author and assignee), not just the current user. (optional)
   * @return Call&lt;WorkPackage&gt;
   */
  @Headers({
    "Content-Type:*/*"
  })
  @POST("api/v3/projects/{id}/work_packages")
  Observable<WorkPackage> apiV3ProjectsIdWorkPackagesPost(
                    @retrofit2.http.Body WorkPackage body    ,         @retrofit2.http.Path("id") Integer id            ,     @retrofit2.http.Query("notify") Boolean notify                
  );

  /**
   * Available assignees
   * Gets a list of users that can be assigned to work packages in the given project.
   * @param projectId Project id (required)
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/projects/{project_id}/work_packages/available_assignees")
  Observable<Void> apiV3ProjectsProjectIdWorkPackagesAvailableAssigneesGet(
            @retrofit2.http.Path("project_id") Integer projectId            
  );

  /**
   * Available responsibles
   * Gets a list of users that can be assigned as the responsible of a work package in the given project.
   * @param projectId Project id (required)
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/projects/{project_id}/work_packages/available_responsibles")
  Observable<Void> apiV3ProjectsProjectIdWorkPackagesAvailableResponsiblesGet(
            @retrofit2.http.Path("project_id") Integer projectId            
  );

  /**
   * Work Package Create Form
   * 
   * @return Call&lt;Void&gt;
   */
  @POST("api/v3/work_packages/form")
  Observable<Void> apiV3WorkPackagesFormPost();
    

  /**
   * List Work Packages
   * 
   * @param offset Page number inside the requested collection. (optional)
   * @param pageSize Number of elements to display per page. (optional)
   * @param filters JSON specifying filter conditions. Accepts the same format as returned by the [queries](#queries) endpoint. (optional)
   * @param sortBy JSON specifying sort criteria. Accepts the same format as returned by the [queries](#queries) endpoint. (optional)
   * @param groupBy The column to group by. (optional)
   * @param showSums Indicates whether properties should be summed up if they support it. (optional)
   * @return Call&lt;WorkPackages&gt;
   */
  @GET("api/v3/work_packages")
  Observable<WorkPackages> apiV3WorkPackagesGet(
        @retrofit2.http.Query("offset") Integer offset                ,     @retrofit2.http.Query("pageSize") Integer pageSize                ,     @retrofit2.http.Query("filters") String filters                ,     @retrofit2.http.Query("sortBy") String sortBy                ,     @retrofit2.http.Query("groupBy") String groupBy                ,     @retrofit2.http.Query("showSums") Boolean showSums                
  );

  /**
   * List work package activities
   * 
   * @param id Work package id (required)
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/work_packages/{id}/activities")
  Observable<Void> apiV3WorkPackagesIdActivitiesGet(
            @retrofit2.http.Path("id") Integer id            
  );

  /**
   * Comment work package
   * Creates an activity for the selected work package and, on success, returns the updated activity.
   * @param id Work package id (required)
   * @param body  (optional)
   * @param notify Indicates whether change notifications (e.g. via E-Mail) should be sent. Note that this controls notifications for all users interested in changes to the work package (e.g. watchers, author and assignee), not just the current user. (optional)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:*/*"
  })
  @POST("api/v3/work_packages/{id}/activities")
  Observable<Void> apiV3WorkPackagesIdActivitiesPost(
            @retrofit2.http.Path("id") Integer id            ,                 @retrofit2.http.Body Object body    ,     @retrofit2.http.Query("notify") Boolean notify                
  );

  /**
   * Available projects
   * Gets a list of projects that are available as projects to which the work package can be moved.
   * @param id work package id (required)
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/work_packages/{id}/available_projects")
  Observable<Void> apiV3WorkPackagesIdAvailableProjectsGet(
            @retrofit2.http.Path("id") Integer id            
  );

  /**
   * Available relation candidates
   * 
   * @param id ID of workpackage to return (required)
   * @param pageSize Maximum number of candidates to list (default 10) (optional)
   * @param filters JSON specifying filter conditions. Accepts the same format as returned by the [queries](#queries) endpoint. (optional)
   * @param query Shortcut for filtering by ID or subject (optional)
   * @param type Type of relation to find candidates for (default \&quot;relates\&quot;) (optional)
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/work_packages/{id}/available_relation_candidates")
  Observable<Void> apiV3WorkPackagesIdAvailableRelationCandidatesGet(
            @retrofit2.http.Path("id") Long id            ,     @retrofit2.http.Query("pageSize") Integer pageSize                ,     @retrofit2.http.Query("filters") String filters                ,     @retrofit2.http.Query("query") String query                ,     @retrofit2.http.Query("type") String type                
  );

  /**
   * Available watchers
   * Gets a list of users that are able to be watchers of the specified work package.
   * @param id work package id (required)
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/work_packages/{id}/available_watchers")
  Observable<Void> apiV3WorkPackagesIdAvailableWatchersGet(
            @retrofit2.http.Path("id") Integer id            
  );

  /**
   * Delete Work Package
   * Deletes the work package, as well as:  * all associated time entries  * its hierarchy of child work packages
   * @param id Work package id (required)
   * @return Call&lt;Void&gt;
   */
  @DELETE("api/v3/work_packages/{id}")
  Observable<Void> apiV3WorkPackagesIdDelete(
            @retrofit2.http.Path("id") Integer id            
  );

  /**
   * Work Package Edit Form
   * 
   * @param id ID of the work package being modified (required)
   * @return Call&lt;Void&gt;
   */
  @POST("api/v3/work_packages/{id}/form")
  Observable<Void> apiV3WorkPackagesIdFormPost(
            @retrofit2.http.Path("id") Integer id            
  );

  /**
   * View Work Package
   * 
   * @param id Work package id (required)
   * @return Call&lt;WorkPackage&gt;
   */
  @GET("api/v3/work_packages/{id}")
  Observable<WorkPackage> apiV3WorkPackagesIdGet(
            @retrofit2.http.Path("id") Integer id            
  );

  /**
   * Edit Work Package
   * When calling this endpoint the client provides a single object, containing the properties and links that it wants to change, in the body. Note that it is only allowed to provide properties or links supporting the **write** operation.  Additionally to the fields the client wants to change, it is mandatory to provide the value of &#x60;lockVersion&#x60; which was received by the &#x60;GET&#x60; request this change originates from.  The value of &#x60;lockVersion&#x60; is used to implement [optimistic locking](http://en.wikipedia.org/wiki/Optimistic_concurrency_control).
   * @param id Work package id (required)
   * @param body  (optional)
   * @param notify Indicates whether change notifications (e.g. via E-Mail) should be sent. Note that this controls notifications for all users interested in changes to the work package (e.g. watchers, author and assignee), not just the current user. (optional)
   * @return Call&lt;WorkPackage&gt;
   */
  @Headers({
    "Content-Type:*/*"
  })
  @PATCH("api/v3/work_packages/{id}")
  Observable<WorkPackage> apiV3WorkPackagesIdPatch(
            @retrofit2.http.Path("id") Integer id            ,                 @retrofit2.http.Body WorkPackage body    ,     @retrofit2.http.Query("notify") Boolean notify                
  );

  /**
   * Relation create form
   * 
   * @param id ID of the relation being modified (required)
   * @return Call&lt;Void&gt;
   */
  @POST("api/v3/work_packages/{id}/relations/form")
  Observable<Void> apiV3WorkPackagesIdRelationsFormPost(
            @retrofit2.http.Path("id") Integer id            
  );

  /**
   * Revisions
   * Gets a list of revisions that are linked to this work package, e.g., because it is referenced in the commit message of the revision. Only linked revisions from repositories are shown if the user has the view changesets permission in the defining project.
   * @param id work package id (required)
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/work_packages/{id}/revisions")
  Observable<Void> apiV3WorkPackagesIdRevisionsGet(
            @retrofit2.http.Path("id") Integer id            
  );

  /**
   * Create Work Package
   * When calling this endpoint the client provides a single object, containing at least the properties and links that are required, in the body. The required fields of a WorkPackage can be found in its schema, which is embedded in the respective form. Note that it is only allowed to provide properties or links supporting the write operation.  A project link must be set when creating work packages through this route.
   * @param body Work package to add (a project link is requried) (required)
   * @param notify Indicates whether change notifications (e.g. via E-Mail) should be sent. Note that this controls notifications for all users interested in changes to the work package (e.g. watchers, author and assignee), not just the current user. (optional)
   * @return Call&lt;WorkPackage&gt;
   */
  @Headers({
    "Content-Type:*/*"
  })
  @POST("api/v3/work_packages")
  Observable<WorkPackage> apiV3WorkPackagesPost(
                    @retrofit2.http.Body WorkPackage body    ,     @retrofit2.http.Query("notify") Boolean notify                
  );

  /**
   * List Work Package Schemas
   * List work package schemas.
   * @param filters JSON specifying filter conditions. Accepts the same format as returned by the [queries](#queries) endpoint. Currently supported filters are:  + id: The schema&#x27;s id (required)
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/work_packages/schemas/")
  Observable<Void> apiV3WorkPackagesSchemasGet(
        @retrofit2.http.Query("filters") String filters                
  );

  /**
   * View Work Package Schema
   * 
   * @param identifier Identifier of the schema (required)
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/work_packages/schemas/{identifier}")
  Observable<Void> apiV3WorkPackagesSchemasIdentifierGet(
            @retrofit2.http.Path("identifier") String identifier            
  );

  /**
   * List relations
   * Lists all relations this work package is involved in.
   * @param workPackageId Work package id (required)
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/work_packages/{work_package_id}/relations")
  Observable<Void> apiV3WorkPackagesWorkPackageIdRelationsGet(
            @retrofit2.http.Path("work_package_id") Integer workPackageId            
  );

  /**
   * Create Relation
   * When calling this endpoint the client provides a single object, containing at least the properties and links that are required, in the body. The required fields of a Relation can be found in its schema, which is embedded in the respective form. Note that it is only allowed to provide properties or links supporting the write operation.
   * @param workPackageId Work package id (required)
   * @return Call&lt;Void&gt;
   */
  @POST("api/v3/work_packages/{work_package_id}/relations")
  Observable<Void> apiV3WorkPackagesWorkPackageIdRelationsPost(
            @retrofit2.http.Path("work_package_id") Integer workPackageId            
  );

  /**
   * List watchers
   * 
   * @param workPackageId Work package id (required)
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/work_packages/{work_package_id}/watchers")
  Observable<Void> apiV3WorkPackagesWorkPackageIdWatchersGet(
            @retrofit2.http.Path("work_package_id") Integer workPackageId            
  );

  /**
   * Remove watcher
   * Removes the specified user from the list of watchers for the given work package.  If the request succeeds, the specified user is not watching the work package anymore.  *Note: This might also be the case, if the specified user did not watch the work package prior to the request.*
   * @param workPackageId Work package id (required)
   * @param id User id (required)
   * @return Call&lt;Void&gt;
   */
  @DELETE("api/v3/work_packages/{work_package_id}/watchers/{id}")
  Observable<Void> apiV3WorkPackagesWorkPackageIdWatchersIdDelete(
            @retrofit2.http.Path("work_package_id") Integer workPackageId            ,         @retrofit2.http.Path("id") Integer id            
  );

  /**
   * Add watcher
   * Adds a watcher to the specified work package.  The request is expected to contain a single JSON object, that contains a link object under the &#x60;user&#x60; key.  The response will be user added as watcher. In case the user was already watching the work package an &#x60;HTTP 200&#x60; is returned, an &#x60;HTTP 201&#x60; if the user was added as a new watcher.
   * @param workPackageId Work package id (required)
   * @param body  (optional)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:*/*"
  })
  @POST("api/v3/work_packages/{work_package_id}/watchers")
  Observable<Void> apiV3WorkPackagesWorkPackageIdWatchersPost(
            @retrofit2.http.Path("work_package_id") Integer workPackageId            ,                 @retrofit2.http.Body Object body    
  );

}
