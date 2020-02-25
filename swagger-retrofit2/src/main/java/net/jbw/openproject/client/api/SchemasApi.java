package net.jbw.openproject.client.api;

import net.jbw.openproject.client.invoker.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface SchemasApi {
  /**
   * view the schema
   * This is an example of how a schema might look like. Note that this endpoint does not exist in the actual implementation.
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/example/schema")
  Call<Void> apiV3ExampleSchemaGet();
    

}
