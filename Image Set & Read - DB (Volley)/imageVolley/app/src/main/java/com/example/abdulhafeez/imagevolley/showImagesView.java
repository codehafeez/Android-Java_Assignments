package com.example.abdulhafeez.imagevolley;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class showImagesView extends AppCompatActivity {

    String phpProgramURL ="http://192.168.223.142/imageVolleyPhp/Database/LoginController.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_images_view);
        phpControllerShowImage();
    }

    public void phpControllerShowImage()
    {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, phpProgramURL, new Response.Listener<String>(){
            @Override
            public void onResponse(String response) {
                 showImageBase64Code(response);
            }

        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) { Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG ).show(); }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<String,String>();
                map.put("showImageCode","showImageCode");
                return map;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void showImageBase64Code(String imageBase64Code){
        byte[] imageAsBytes = Base64.decode(imageBase64Code.getBytes(), Base64.DEFAULT);
        ImageView imageViewShow = (ImageView) this.findViewById(R.id.imageShow);
        imageViewShow.setImageBitmap(BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.length));
    }
}
