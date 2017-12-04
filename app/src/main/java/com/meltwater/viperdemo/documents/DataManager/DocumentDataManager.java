package com.meltwater.viperdemo.documents.DataManager;

import com.meltwater.viperdemo.documents.DocumentListContract;
import com.meltwater.viperdemo.documents.entity.DocumentsPageModel;

import android.util.Log;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Callback;

/**
 * Created by thinhnguyen on 12/3/17.
 * Demo
 */

public class DocumentDataManager implements DocumentListContract.DataManagerInput {

    private DocumentListContract.DataManagerOutput interactor;

    private final String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJ1c2VyIjp7Il9pZCI6IjU1MDhkMDgzZTIzZmQ5MjkwOGZmMDlkYSIsImZpcnN0TmFtZSI6IlRoaW5oIiwibGFzdE5hbWUiOiJOZ3V5ZW4iLCJlbWFpbCI6InRoaW5oLm5ndXllbkBtZWx0d2F0ZXIuY29tIiwicGFzc3dvcmQiOiIkMmEkMTAkTHVuWUJxcGVVV0YwdUhHTjJxWDhWT1p6WkQyMi43QTBNRU0wck1WeEhmU1NJZE4xZlpVWEMiLCJhY3RpdmVDb21wYW55SWQiOiI1NmU5ODY1OTYzNzNmYjJkY2ViYTE2MGYiLCJpc0ludGVybmFsIjp0cnVlLCJ0aW1lem9uZSI6IkFtZXJpY2EvTG9zX0FuZ2VsZXMiLCJsYW5ndWFnZSI6ImVuIiwiY3JlYXRlZCI6IjIwMTUtMDMtMThUMDE6MTA6MjcuMTUyWiIsIm1vZGlmaWVkIjoiMjAxNy0xMS0yOVQwODowMDozMy44NDZaIn0sImNvbXBhbnkiOnsiX2lkIjoiNTZlOTg2NTk2MzczZmIyZGNlYmExNjBmIiwibmFtZSI6IlRoaW5oIE5ndXllbiAtIEZhaXJoYWlyIiwiY291bnRyeSI6InVzIiwiYWNjb3VudElkIjoxNTk5NjA1LCJvcHBvcnR1bml0eUlkIjoyMDcyNzcxLCJjcmVhdGVkIjoiMjAxNi0wMy0xNlQxNjoxNDoxNy4wMDZaIiwibW9kaWZpZWQiOiIyMDE2LTA4LTE2VDE4OjAxOjIzLjMyM1oifSwiZXhwIjoxNTEyNjI3MTczNTIwfQ.eRtZTTTO5C0BafdbvNvmpWlnGRXNzvgOtXiDNHwEUMIWnrebjzarqHwyXy-gNcN3mGSJFyWsYqTD0tzKO0OLnuruQHPXEiA7FPvW9dB_IQzdno_0jrY07gpCfrpjAziJJf4AaQdO4KKiA38UJ41InLOv8YbRxTSORuLz01MiDzRNFWfjRx22OMZfC5nA630FSGRhz8IjwcV2DPgc6wZlHIIdeaCdWzMP2tMN8BCq-RVhsBxWVgjFfHlN_aczGqJrdCKf8T6M3-Rtf9YuJWTlteMmYQgODX39vivyKhItWb__u-Qbn1SOyjkuIYC4BQSNEyj2HWS_4e5DD-1hqLOZPw";
    private final String baseUrl = "https://ins-services.meltwater.com/";



    public DocumentDataManager(DocumentListContract.DataManagerOutput interactor) {
        this.interactor = interactor;
    }
    @Override
    public void retrieveDocuments(HashMap<String, Object> payload) {

        // Callback
        Callback<DocumentsPageModel> callback = new Callback<DocumentsPageModel>() {
            @Override
            public void onResponse(Call<DocumentsPageModel> call, retrofit2.Response<DocumentsPageModel> response) {
                interactor.didRetrieveDocuments(response.body().getDocuments());
            }

            @Override
            public void onFailure(Call<DocumentsPageModel> call, Throwable t) {
                interactor.onError(t.getMessage());
            }
        };

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {

                Request original = chain.request();

                Request request = original.newBuilder()
                        .header("Authorization", token)
                        .header("Accept", "application/json")
                        .method(original.method(), original.body())
                        .build();

                return chain.proceed(request);
            }
        });

        try {
            OkHttpClient client = httpClient.build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
            retrofit.create(DocServiceApi.class)
                    .getDocuments(token, 5, "us", 20, 0, "2017-11-07T20:00:19.028Z", "DESC",
                            "close", "2017-11-02T19:01:49.000Z", "2102541", 0, "date", "images")
                    .enqueue(callback);
        } catch (Exception e) {
            Log.d("Exception Documents", e.getMessage());
            // Bad argument
            callback.onFailure(null, e);
        }
    }
}
