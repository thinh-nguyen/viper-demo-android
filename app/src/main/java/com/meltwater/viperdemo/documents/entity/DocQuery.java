package com.meltwater.viperdemo.documents.entity;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by thinhnguyen on 12/3/17.
 */

public interface DocQuery {

    @GET("documentService/v3/documents")
    Call<DocumentsPage> getDocuments(
            @Header("Authorization") String token, @Query("dupDocsCapSize") Integer dupCap,
            @Query("country") String country, @Query("pageSize") Integer pageSize,
            @Query("groupFrom") Integer groupFrom, @Query("dateEnd") String dateEnd,
            @Query("sortOrder") String sortOrder, @Query("groupOption") String groupOption,
            @Query("dateStart") String startDate, @Query("agents") String agents, @Query("page") Integer page,
            @Query("sortField") String sortField, @Query("additionalFields") String additionalField);

}
