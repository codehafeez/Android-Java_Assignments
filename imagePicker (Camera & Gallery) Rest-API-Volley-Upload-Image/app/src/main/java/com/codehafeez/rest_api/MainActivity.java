package com.codehafeez.rest_api;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;
public class MainActivity extends AppCompatActivity {

    private ImageView viewImage;
    private final int PICK_FROM_GALLERY = 1;
    private static final int MY_CAMERA_REQUEST_CODE = 100;
    private Bitmap bitmapImage = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewImage = (ImageView) findViewById(R.id.viewImage);


        // (Start) camera permission
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.CAMERA}, MY_CAMERA_REQUEST_CODE);
            }
        }
        // (End) camera permission

        Button uploadImageCamera_Btn = (Button)findViewById(R.id.uploadImageCamera_Btn);
        uploadImageCamera_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, MY_CAMERA_REQUEST_CODE);
            }
        });

        Button uploadImageGallery_Btn = (Button)findViewById(R.id.uploadImageGallery_Btn);
        uploadImageGallery_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, PICK_FROM_GALLERY);
            }
        });

        Button uploadImage_Btn = (Button)findViewById(R.id.uploadImage_Btn);
        uploadImage_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bitmapImage != null){ uploadImageFunction(); }
                else {
                    Toast.makeText(MainActivity.this, "Please select image.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try{
            if (requestCode == MY_CAMERA_REQUEST_CODE) {
                bitmapImage = (Bitmap) data.getExtras().get("data");
                viewImage.setImageBitmap(bitmapImage);
            }
            else if (requestCode == PICK_FROM_GALLERY && resultCode == RESULT_OK) {
                Uri path = data.getData();
                bitmapImage = MediaStore.Images.Media.getBitmap(getContentResolver(), path);
                viewImage.setImageBitmap(bitmapImage);
            }
        } catch (Exception e){ Toast.makeText(this, e+"", Toast.LENGTH_SHORT).show(); }
    }

    private String imageToString(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
        byte[] imageBytes = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(imageBytes, Base64.DEFAULT);
    }

    public void uploadImageFunction(){
        String PROFILE_URL = "https://codehafeez.com/api/upload_image_volley.php";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, PROFILE_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) { Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show(); }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map.put("image", imageToString(bitmapImage));
                map.put("name", "image");
                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
