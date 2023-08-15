package com.example.abdulhafeez.spinner_with_xml_simple;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
public class MainActivity extends AppCompatActivity {

    private Spinner countrySpinner;
    private Spinner countryCodesSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countrySpinner = (Spinner)findViewById(R.id.first_spinner);
        countryCodesSpinner = (Spinner)findViewById(R.id.second_spinner);
        countryCodesSpinner.setEnabled(false);
        ArrayAdapter<CharSequence> countryAdapter = ArrayAdapter.createFromResource(this, R.array.first_spinner, android.R.layout.simple_spinner_item);
        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<CharSequence> countryCodesAdapter = ArrayAdapter.createFromResource(this, R.array.second_spinner, android.R.layout.simple_spinner_item);
        countryCodesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countrySpinner.setAdapter(countryAdapter);
        countrySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) { countryCodesSpinner.setSelection(position); }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
        countryCodesSpinner.setAdapter(countryCodesAdapter);
    }
}
