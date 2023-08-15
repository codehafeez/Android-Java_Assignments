package com.example.abdulhafeez.retrofitimageuploadfolder;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.abdulhafeez.retrofitimageuploadfolder.interfaces.login;
import com.example.abdulhafeez.retrofitimageuploadfolder.interfaces.profilePicture;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button btnUpload, btnPickImage;
    String mediaPath;
    ImageView imgView;
    int PICK_IMAGE_REQUEST = 111;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button passValue = (Button) findViewById(R.id.passValue);
        passValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                get_set_ValuesFunctionPhp();
            }
        });

        imgView = (ImageView) findViewById(R.id.preview);
        btnUpload = (Button) findViewById(R.id.upload);
        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { uploadFile(); }
        });
        btnPickImage = (Button) findViewById(R.id.pick_img);
        btnPickImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_PICK);
                startActivityForResult(Intent.createChooser(intent, "Select Image"), PICK_IMAGE_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            mediaPath = cursor.getString(columnIndex);
            imgView.setImageBitmap(BitmapFactory.decodeFile(mediaPath));
            cursor.close();
        } catch (Exception e) { Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show(); }
    }

    private void uploadFile()
    {
        File file = new File(mediaPath);
        RequestBody requestBody = RequestBody.create(MediaType.parse("*/*"), file);
        MultipartBody.Part fileToUpload = MultipartBody.Part.createFormData("file", file.getName(), requestBody);
        RequestBody filename = RequestBody.create(MediaType.parse("text/plain"), file.getName());

        profilePicture getResponse = AppConfig.getRetrofit().create(profilePicture.class);
        Call<ServerResponse> call = getResponse.uploadFileParameter1(fileToUpload, filename);
        call.enqueue(new Callback<ServerResponse>()
        {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                ServerResponse serverResponse = response.body();
                if (serverResponse != null) { Toast.makeText(getApplicationContext(), serverResponse.getMessage(), Toast.LENGTH_SHORT).show(); }
                else { Toast.makeText(getApplicationContext(), serverResponse.toString(), Toast.LENGTH_SHORT).show(); }
            }
            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {}
        });
    }

    private void get_set_ValuesFunctionPhp()
    {
        String username = "Hafeez";
        String password = "123";
        RestAdapter restAdapter=new RestAdapter.Builder().setEndpoint(AppConfig.ROOT_URL).build();
        final login lg=restAdapter.create(login.class);
        lg.log(username,password,new retrofit.Callback<retrofit.client.Response>()
        {
            @Override
            public void success(retrofit.client.Response result, retrofit.client.Response response)
            {
                try {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(result.getBody().in()));
                    String output = reader.readLine();
                    Toast.makeText(getBaseContext(), output, Toast.LENGTH_LONG).show();
                } catch (IOException e) { e.printStackTrace(); }
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(getBaseContext(), error.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
}

