package com.example.abdulhafeez.retrofitimageuploadfolder.interfaces;
import com.example.abdulhafeez.retrofitimageuploadfolder.ServerResponse;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface profilePicture
{
    @Multipart
    @POST("PhpProjectFiles/upload_image.php")
    Call<ServerResponse> uploadFileParameter1(@Part MultipartBody.Part file, @Part("file") RequestBody name);
}
