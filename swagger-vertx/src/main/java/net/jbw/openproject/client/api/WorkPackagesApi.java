package net.jbw.openproject.client.api;

import net.jbw.openproject.client.model.InlineObject7;
import net.jbw.openproject.client.model.InlineObject8;
import net.jbw.openproject.client.model.WorkPackage;
import net.jbw.openproject.client.model.WorkPackages;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;

import java.util.*;

public interface WorkPackagesApi {

    void apiV3ProjectsIdWorkPackagesFormPost(Integer id, Handler<AsyncResult<Void>> handler);

    void apiV3ProjectsIdWorkPackagesGet(Integer id, Integer offset, Integer pageSize, String filters, String sortBy, String groupBy, Boolean showSums, Handler<AsyncResult<WorkPackages>> handler);

    void apiV3ProjectsIdWorkPackagesPost(Integer id, WorkPackage workPackage, Boolean notify, Handler<AsyncResult<WorkPackage>> handler);

    void apiV3ProjectsProjectIdWorkPackagesAvailableAssigneesGet(Integer projectId, Handler<AsyncResult<Void>> handler);

    void apiV3ProjectsProjectIdWorkPackagesAvailableResponsiblesGet(Integer projectId, Handler<AsyncResult<Void>> handler);

    void apiV3WorkPackagesFormPost(Handler<AsyncResult<Void>> handler);

    void apiV3WorkPackagesGet(Integer offset, Integer pageSize, String filters, String sortBy, String groupBy, Boolean showSums, Handler<AsyncResult<WorkPackages>> handler);

    void apiV3WorkPackagesIdActivitiesGet(Integer id, Handler<AsyncResult<Void>> handler);

    void apiV3WorkPackagesIdActivitiesPost(Integer id, Boolean notify, InlineObject8 body, Handler<AsyncResult<Void>> handler);

    void apiV3WorkPackagesIdAvailableProjectsGet(Integer id, Handler<AsyncResult<Void>> handler);

    void apiV3WorkPackagesIdAvailableRelationCandidatesGet(Long id, Integer pageSize, String filters, String query, String type, Handler<AsyncResult<Void>> handler);

    void apiV3WorkPackagesIdAvailableWatchersGet(Integer id, Handler<AsyncResult<Void>> handler);

    void apiV3WorkPackagesIdDelete(Integer id, Handler<AsyncResult<Void>> handler);

    void apiV3WorkPackagesIdFormPost(Integer id, Handler<AsyncResult<Void>> handler);

    void apiV3WorkPackagesIdGet(Integer id, Handler<AsyncResult<WorkPackage>> handler);

    void apiV3WorkPackagesIdPatch(Integer id, Boolean notify, WorkPackage body, Handler<AsyncResult<WorkPackage>> handler);

    void apiV3WorkPackagesIdRelationsFormPost(Integer id, Handler<AsyncResult<Void>> handler);

    void apiV3WorkPackagesIdRevisionsGet(Integer id, Handler<AsyncResult<Void>> handler);

    void apiV3WorkPackagesPost(WorkPackage workPackage, Boolean notify, Handler<AsyncResult<WorkPackage>> handler);

    void apiV3WorkPackagesSchemasGet(String filters, Handler<AsyncResult<Void>> handler);

    void apiV3WorkPackagesSchemasIdentifierGet(String identifier, Handler<AsyncResult<Void>> handler);

    void apiV3WorkPackagesWorkPackageIdRelationsGet(Integer workPackageId, Handler<AsyncResult<Void>> handler);

    void apiV3WorkPackagesWorkPackageIdRelationsPost(Integer workPackageId, Handler<AsyncResult<Void>> handler);

    void apiV3WorkPackagesWorkPackageIdWatchersGet(Integer workPackageId, Handler<AsyncResult<Void>> handler);

    void apiV3WorkPackagesWorkPackageIdWatchersIdDelete(Integer workPackageId, Integer id, Handler<AsyncResult<Void>> handler);

    void apiV3WorkPackagesWorkPackageIdWatchersPost(Integer workPackageId, InlineObject7 body, Handler<AsyncResult<Void>> handler);

}
