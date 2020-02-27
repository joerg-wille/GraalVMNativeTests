package net.jbw.openproject.client.api.rxjava;


import java.util.*;

import rx.Single;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;


public class AttachmentsApi {

	private final net.jbw.openproject.client.api.AttachmentsApi delegate;

	public AttachmentsApi(net.jbw.openproject.client.api.AttachmentsApi delegate) {
	    this.delegate = delegate;
    }

	public net.jbw.openproject.client.api.AttachmentsApi getDelegate() {
	    return delegate;
	}

    /**
     * Delete attachment
     * Permanently deletes the specified attachment.
     * @param id Attachment id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3AttachmentsIdDelete(Integer id, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3AttachmentsIdDelete(id, resultHandler);
    }

    /**
     * Delete attachment
     * Permanently deletes the specified attachment.
     * @param id Attachment id (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3AttachmentsIdDelete(Integer id) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3AttachmentsIdDelete(id, fut);
        }));
    }
    /**
     * View attachment
     * 
     * @param id Attachment id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3AttachmentsIdGet(Integer id, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3AttachmentsIdGet(id, resultHandler);
    }

    /**
     * View attachment
     * 
     * @param id Attachment id (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3AttachmentsIdGet(Integer id) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3AttachmentsIdGet(id, fut);
        }));
    }
    /**
     * List attachments
     * 
     * @param id ID of the work package whose attachments will be listed (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3WorkPackagesIdAttachmentsGet(Integer id, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3WorkPackagesIdAttachmentsGet(id, resultHandler);
    }

    /**
     * List attachments
     * 
     * @param id ID of the work package whose attachments will be listed (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3WorkPackagesIdAttachmentsGet(Integer id) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3WorkPackagesIdAttachmentsGet(id, fut);
        }));
    }
    /**
     * Add attachment
     * To add an attachment to a work package, a client needs to issue a request of type &#x60;multipart/form-data&#x60; with exactly two parts.  The first part *must* be called &#x60;metadata&#x60;. Its content type is expected to be &#x60;application/json&#x60;, the body *must* be a single JSON object, containing at least the &#x60;fileName&#x60; and optionally the attachments &#x60;description&#x60;.  The second part *must* be called &#x60;file&#x60;, its content type *should* match the mime type of the file. The body *must* be the raw content of the file. Note that a &#x60;filename&#x60; must be indicated in the &#x60;Content-Disposition&#x60; of this part, however it will be ignored. Instead the &#x60;fileName&#x60; inside the JSON of the metadata part will be used.
     * @param id ID of the work package to receive the attachment (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3WorkPackagesIdAttachmentsPost(Integer id, Handler<AsyncResult<Void>> resultHandler) {
        delegate.apiV3WorkPackagesIdAttachmentsPost(id, resultHandler);
    }

    /**
     * Add attachment
     * To add an attachment to a work package, a client needs to issue a request of type &#x60;multipart/form-data&#x60; with exactly two parts.  The first part *must* be called &#x60;metadata&#x60;. Its content type is expected to be &#x60;application/json&#x60;, the body *must* be a single JSON object, containing at least the &#x60;fileName&#x60; and optionally the attachments &#x60;description&#x60;.  The second part *must* be called &#x60;file&#x60;, its content type *should* match the mime type of the file. The body *must* be the raw content of the file. Note that a &#x60;filename&#x60; must be indicated in the &#x60;Content-Disposition&#x60; of this part, however it will be ignored. Instead the &#x60;fileName&#x60; inside the JSON of the metadata part will be used.
     * @param id ID of the work package to receive the attachment (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxApiV3WorkPackagesIdAttachmentsPost(Integer id) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV3WorkPackagesIdAttachmentsPost(id, fut);
        }));
    }

    public static AttachmentsApi newInstance(net.jbw.openproject.client.api.AttachmentsApi arg) {
        return arg != null ? new AttachmentsApi(arg) : null;
    }
}
