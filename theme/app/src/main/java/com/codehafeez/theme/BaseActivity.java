package com.codehafeez.theme;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
public class BaseActivity extends AppCompatActivity {

    private final static int THEME_BLUE = 1;
    private final static int THEME_RED = 2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        updateTheme();
    }
    public void updateTheme() {
        if (Utility.getTheme(getApplicationContext()) <= THEME_BLUE) {
            setTheme(R.style.AppTheme_Blue);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                getWindow().setStatusBarColor(getResources().getColor(R.color.primaryColorDark_blue));
            }
        } else if (Utility.getTheme(getApplicationContext()) == THEME_RED) {
            setTheme(R.style.AppTheme_Red);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                getWindow().setStatusBarColor(getResources().getColor(R.color.primaryColorDark_red));
            }
        }
    }
}