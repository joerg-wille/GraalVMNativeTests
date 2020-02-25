package net.jbw.openproject.client.api;

import io.reactivex.Observable;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface AttachmentsApi {
  /**
   * Delete attachment
   * Permanently deletes the specified attachment.
   * @param id Attachment id (required)
   * @return Call&lt;Void&gt;
   */
  @DELETE("api/v3/attachments/{id}")
  Observable<Void> apiV3AttachmentsIdDelete(
            @retrofit2.http.Path("id") Integer id            
  );

  /**
   * View attachment
   * 
   * @param id Attachment id (required)
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/attachments/{id}")
  Observable<Void> apiV3AttachmentsIdGet(
            @retrofit2.http.Path("id") Integer id            
  );

  /**
   * List attachments
   * 
   * @param id ID of the work package whose attachments will be listed (required)
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/work_packages/{id}/attachments")
  Observable<Void> apiV3WorkPackagesIdAttachmentsGet(
            @retrofit2.http.Path("id") Integer id            
  );

  /**
   * Add attachment
   * To add an attachment to a work package, a client needs to issue a request of type &#x60;multipart/form-data&#x60; with exactly two parts.  The first part *must* be called &#x60;metadata&#x60;. Its content type is expected to be &#x60;application/json&#x60;, the body *must* be a single JSON object, containing at least the &#x60;fileName&#x60; and optionally the attachments &#x60;description&#x60;.  The second part *must* be called &#x60;file&#x60;, its content type *should* match the mime type of the file. The body *must* be the raw content of the file. Note that a &#x60;filename&#x60; must be indicated in the &#x60;Content-Disposition&#x60; of this part, however it will be ignored. Instead the &#x60;fileName&#x60; inside the JSON of the metadata part will be used.
   * @param id ID of the work package to receive the attachment (required)
   * @return Call&lt;Void&gt;
   */
  @POST("api/v3/work_packages/{id}/attachments")
  Observable<Void> apiV3WorkPackagesIdAttachmentsPost(
            @retrofit2.http.Path("id") Integer id            
  );

}
