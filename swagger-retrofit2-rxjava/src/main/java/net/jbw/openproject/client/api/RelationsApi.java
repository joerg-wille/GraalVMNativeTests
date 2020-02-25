package net.jbw.openproject.client.api;

import io.reactivex.Observable;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;

public interface RelationsApi {
  /**
   * List Relations
   * Lists all relations according to the given (optional, logically conjunctive) filters and ordered by ID. The response only includes relations between work packages which the user is allowed to see.
   * @param filters JSON specifying filter conditions. Accepts the same format as returned by the [queries](#queries) endpoint. Valid fields to filter by are:  + id - ID of relation  + from - ID of work package from which the filtered relations emanates.  + to - ID of work package to which this related points.  + involved - ID of either the &#x60;from&#x60; or the &#x60;to&#x60; work package.  + type - The type of relation to filter by, e.g. \&quot;follows\&quot;. (optional)
   * @param sortBy JSON specifying sort criteria. Accepts the same format as returned by the [queries](#queries) endpoint. (optional)
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/relations")
  Observable<Void> apiV3RelationsGet(
        @retrofit2.http.Query("filters") String filters                ,     @retrofit2.http.Query("sortBy") String sortBy                
  );

  /**
   * Delete Relation
   * Deletes the relation.
   * @param id Relation ID (required)
   * @return Call&lt;Void&gt;
   */
  @DELETE("api/v3/relations/{id}")
  Observable<Void> apiV3RelationsIdDelete(
            @retrofit2.http.Path("id") Integer id            
  );

  /**
   * Relation edit form
   * 
   * @param id ID of the relation being modified (required)
   * @return Call&lt;Void&gt;
   */
  @POST("api/v3/relations/{id}/form")
  Observable<Void> apiV3RelationsIdFormPost(
            @retrofit2.http.Path("id") Integer id            
  );

  /**
   * View Relation
   * 
   * @param id Relation id (required)
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/relations/{id}")
  Observable<Void> apiV3RelationsIdGet(
            @retrofit2.http.Path("id") Integer id            
  );

  /**
   * Edit Relation
   * When calling this endpoint the client provides a single object, containing the properties and links that it wants to change, in the body. It is only allowed to provide properties or links supporting the **write** operation.  Note that changing the &#x60;type&#x60; of a relation invariably also changes the respective &#x60;reverseType&#x60; as well as the \&quot;name\&quot; of it. The returned Relation object will reflect that change. For instance if you change a Relation&#x27;s &#x60;type&#x60; to \&quot;follows\&quot; then the &#x60;reverseType&#x60; will be changed to &#x60;precedes&#x60;.
   * @param id Relation ID (required)
   * @return Call&lt;Void&gt;
   */
  @PATCH("api/v3/relations/{id}")
  Observable<Void> apiV3RelationsIdPatch(
            @retrofit2.http.Path("id") Integer id            
  );

  /**
   * View relation schema
   * 
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/relations/schema")
  Observable<Void> apiV3RelationsSchemaGet();
    

  /**
   * View relation schema for type
   * 
   * @param type Type of the schema (required)
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/relations/schema/{type}")
  Observable<Void> apiV3RelationsSchemaTypeGet(
            @retrofit2.http.Path("type") String type            
  );

}
