package com.example.abdulhafeez.retrofitimageuploadfolder;
import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
class AppConfig
{
    // Login_Text_String
    public static final String ROOT_URL = "http://192.168.43.240/xamtaDB";

    // Profile_Image
    private static String BASE_URL = "http://192.168.43.240/";
    static Retrofit getRetrofit()
    {
        return new Retrofit.Builder().baseUrl(AppConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    }
}
