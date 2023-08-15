package inducesmile.com.androidrecyclerview;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getValuesFromDB_toSetProfile();
    }

    public void showListFunction(String[] stringArrayNames, String[] stringArrayImages){
        Integer[] images = {R.drawable.face, R.drawable.face, R.drawable.face, R.drawable.face, R.drawable.face};
        ListView  lst = (ListView)findViewById(R.id.android_list);
        CustomAdapter adapter = new CustomAdapter(this, stringArrayNames, stringArrayImages);
        lst.setAdapter(adapter);
    }

    public void getValuesFromDB_toSetProfile()
    {
        final ArrayList<String> mylistNames = new ArrayList<>();
        final ArrayList<String> mylistImages = new ArrayList<>();
        String myIP = getResources().getString(R.string.programIP);
        String PROFILE_URL = myIP+"xamta/ControllerSearchNewFriend.php";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, PROFILE_URL, new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response)
            {
                try {
                    JSONArray jArray = new JSONArray(response);
                    for(int i=0;i<jArray.length();i++) {
                        JSONObject json_obj = jArray.getJSONObject(i);
                        String firstName = json_obj.optString("firstName");
                        String lastName = json_obj.optString("lastName");
                        String profileImage = json_obj.optString("profileImage");
                        String myIP = getResources().getString(R.string.programIP);
                        String dbImageUrl = myIP+"xamta/"+profileImage;

                        mylistNames.add(firstName+" "+lastName);
                        mylistImages.add(dbImageUrl);
                        String[] stringArrayNames = mylistNames.toArray(new String[0]);
                        String[] stringArrayImages = mylistImages.toArray(new String[0]);
                        showListFunction(stringArrayNames, stringArrayImages);
                    }
                } catch (Exception ex) { Toast.makeText(getApplicationContext(), ex.toString(), Toast.LENGTH_LONG).show(); }
            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) { Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG ).show(); }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<String,String>();
                map.put("searchNewFriend","searchNewFriend");
                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
