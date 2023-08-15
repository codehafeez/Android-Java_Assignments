package com.codehafeez.notification;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
public class NotifyActivity extends AppCompatActivity {

    public static String notify_title = "notify_title";
    public static String notify_content = "notify_content";
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify);
        textView = findViewById(R.id.notifyText);
        updateUI();
    }

    private void updateUI() {
        String notifyData = getIntent().getExtras().get(notify_title) + " \n" + getIntent().getExtras().get(notify_content);
        textView.setText(notifyData);
    }

}