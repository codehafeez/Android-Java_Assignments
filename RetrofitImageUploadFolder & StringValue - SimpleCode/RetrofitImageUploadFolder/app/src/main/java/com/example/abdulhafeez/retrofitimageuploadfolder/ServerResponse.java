package com.example.abdulhafeez.retrofitimageuploadfolder;
import com.google.gson.annotations.SerializedName;
public class ServerResponse {

    @SerializedName("success")
    boolean success;
    boolean getSuccess() { return success; }

    @SerializedName("message")
    String message;
    String getMessage() { return message; }
}
