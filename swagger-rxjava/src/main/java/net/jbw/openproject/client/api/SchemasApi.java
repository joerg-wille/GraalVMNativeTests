package net.jbw.openproject.client.api;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface SchemasApi {
  /**
   * view the schema
   * This is an example of how a schema might look like. Note that this endpoint does not exist in the actual implementation.
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/example/schema")
  Observable<Void> apiV3ExampleSchemaGet();
    

}
