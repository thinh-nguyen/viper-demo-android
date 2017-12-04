package com.meltwater.viperdemo.documents.DataManager;

import com.meltwater.viperdemo.documents.entity.DocumentsPageModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Created by thinhnguyen on 12/3/17.
 */

public interface DocServiceApi {

    @GET("documentService/v3/documents")
    Call<DocumentsPageModel> getDocuments(
            @Header("Authorization") String token, @Query("dupDocsCapSize") Integer dupCap,
            @Query("country") String country, @Query("pageSize") Integer pageSize,
            @Query("groupFrom") Integer groupFrom, @Query("dateEnd") String dateEnd,
            @Query("sortOrder") String sortOrder, @Query("groupOption") String groupOption,
            @Query("dateStart") String startDate, @Query("agents") String agents, @Query("page") Integer page,
            @Query("sortField") String sortField, @Query("additionalFields") String additionalField);

}
