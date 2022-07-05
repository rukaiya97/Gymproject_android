package com.example.arrayadapter.Service;

import com.example.arrayadapter.Model.Client;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ClientApi {
    @POST("/api/Client/")
    Call<Client> save(@Body Client client);
}
