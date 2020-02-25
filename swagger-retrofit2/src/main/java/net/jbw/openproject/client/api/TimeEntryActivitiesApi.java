package net.jbw.openproject.client.api;

import net.jbw.openproject.client.invoker.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;

import net.jbw.openproject.client.model.TimeEntriesActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface TimeEntryActivitiesApi {
  /**
   * View time entries activity
   * 
   * @param id time entries activity id (required)
   * @return Call&lt;TimeEntriesActivity&gt;
   */
  @GET("api/v3/time_entries/activities/{id}")
  Call<TimeEntriesActivity> apiV3TimeEntriesActivitiesIdGet(
            @retrofit2.http.Path("id") Integer id            
  );

}
