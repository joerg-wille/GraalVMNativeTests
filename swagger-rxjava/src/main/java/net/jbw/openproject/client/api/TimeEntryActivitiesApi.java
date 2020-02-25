package net.jbw.openproject.client.api;

import io.reactivex.Observable;
import net.jbw.openproject.client.model.TimeEntriesActivity;
import retrofit2.http.GET;

public interface TimeEntryActivitiesApi {
  /**
   * View time entries activity
   * 
   * @param id time entries activity id (required)
   * @return Call&lt;TimeEntriesActivity&gt;
   */
  @GET("api/v3/time_entries/activities/{id}")
  Observable<TimeEntriesActivity> apiV3TimeEntriesActivitiesIdGet(
            @retrofit2.http.Path("id") Integer id            
  );

}
