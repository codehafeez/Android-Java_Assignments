package com.example.abdulhafeez.fontex;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {

    TextView tv1,tv2,tv3,tv4;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1=(TextView)findViewById(R.id.textView1);
        tv2=(TextView)findViewById(R.id.textView2);
        tv3=(TextView)findViewById(R.id.textView3);
        tv4=(TextView)findViewById(R.id.textView4);

        Typeface face1 = Typeface.createFromAsset(getAssets(), "fonts/FreeScpt.ttf");
        tv1.setTypeface(face1);

        Typeface face2= Typeface.createFromAsset(getAssets(), "fonts/FreestyleScriptPlain.ttf");
        tv2.setTypeface(face2);

        Typeface face3= Typeface.createFromAsset(getAssets(), "fonts/Alegreya-Italic.ttf");
        tv3.setTypeface(face3);

        Typeface face4= Typeface.createFromAsset(getAssets(), "fonts/Alegreya-Regular.ttf");
        tv4.setTypeface(face4);
    }
}
