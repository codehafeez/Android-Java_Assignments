package com.example.abdulhafeez.retrofitimageuploadfolder.interfaces;
import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;
public interface login {
    @FormUrlEncoded
    @POST("/loginController.php")
    public void log(
            @Field("open_username") String driver_name,
            @Field("open_password") String password,
            Callback<Response> callback);
}
