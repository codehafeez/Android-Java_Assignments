package com.example.abdulhafeez.spinner_country_state;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {

    Spinner Country,State;
    ArrayList<String> list = new ArrayList<>();
    ArrayList<String> CountryId = new ArrayList<>();;
    ArrayList<String> StateList = new ArrayList<>();;
    String selected_country_string, selected_state_string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Country = (Spinner)findViewById(R.id.Country);
        State = (Spinner)findViewById(R.id.State);
        StateList.add("Select State");
        parseXML();


        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Country.setAdapter(spinnerArrayAdapter);
        Country.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                StateList.clear();
                selected_country_string = list.get(position).toString();
                // Toast.makeText(getApplicationContext(), selected_country_string, Toast.LENGTH_LONG).show();
                parseForState(CountryId.get(position).toString());
            }
            @Override public void onNothingSelected(AdapterView<?> parent) {}
        });

        ArrayAdapter<String> spinnerArrayAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, StateList);
        spinnerArrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        State.setAdapter(spinnerArrayAdapter2);
        State.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selected_state_string = StateList.get(position).toString();
                // Toast.makeText(getApplicationContext(), selected_state_string, Toast.LENGTH_LONG).show();
                State.setGravity(position);
            }
            @Override public void onNothingSelected(AdapterView<?> parent) {}
        });
    }

    private void parseXML()
    {
        XmlPullParserFactory parseFactury;
        try{
            parseFactury= XmlPullParserFactory.newInstance();
            XmlPullParser parser=parseFactury.newPullParser();
            InputStream is=getAssets().open("country.xml");
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES,false);
            parser.setInput(is,null);
            processParsing(parser);
        } catch (Exception ex) { Toast.makeText(getApplicationContext(), ex.toString(), Toast.LENGTH_LONG).show(); }
    }

    private void processParsing(XmlPullParser parser)
    {
        try
        {
            ArrayList<TheCountries> countries=new ArrayList<>();
            int eventType=parser.getEventType();
            TheCountries obj_countries=null;
            while(eventType != XmlPullParser.END_DOCUMENT)
            {
                switch (eventType)
                {
                    case XmlPullParser.START_TAG:
                        String elteName = parser.getName();
                        if ("country".equals(elteName)){
                            obj_countries=new TheCountries();
                            countries.add(obj_countries);
                        }
                        else if(obj_countries!=null){
                            if ("name".equals(elteName)){ obj_countries.Country=parser.nextText(); }
                            else if("country_id".equals(elteName)){ obj_countries.Country_id=parser.nextText(); }
                        }
                        break;
                }
                eventType=parser.next();
            }
            printPlayer(countries);
        } catch (Exception ex) { Toast.makeText(getApplicationContext(), ex.toString(), Toast.LENGTH_LONG).show(); }
    }

    private void printPlayer(ArrayList<TheCountries> countries) {
        for (TheCountries c:countries){
            list.add(c.Country.toString());
            CountryId.add(c.Country_id);
        }
    }

    private void parseForState(String s) {
        XmlPullParserFactory parseFactury;
        try{
            parseFactury=XmlPullParserFactory.newInstance();
            XmlPullParser parser=parseFactury.newPullParser();
            InputStream is=getAssets().open("state.xml");
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES,false);
            parser.setInput(is,null);
            processParsingForState(parser,s);
        } catch (Exception ex) { Toast.makeText(getApplicationContext(), ex.toString(), Toast.LENGTH_LONG).show(); }
    }

    private void processParsingForState(XmlPullParser parser,String id) throws IOException,XmlPullParserException
    {
        ArrayList<TheState> state=new ArrayList<>();
        int eventType=parser.getEventType();
        TheState obj_state=null;
        while(eventType != XmlPullParser.END_DOCUMENT)
        {
            switch (eventType){
                case XmlPullParser.START_TAG:
                    String elteName = parser.getName();
                    if ("state_province".equals(elteName)){
                        obj_state=new TheState();
                        state.add(obj_state);
                    }else if(obj_state!=null){
                        if ("name".equals(elteName)){ obj_state.State=parser.nextText(); }
                        else if("country_id".equals(elteName)){ obj_state.C_Id=parser.nextText(); }
                    }
                    break;
            }
            eventType=parser.next();
        }
        printPlayer2(state,id);
    }

    private void printPlayer2(ArrayList<TheState> state,String id) {
        State.setSelection(0);
        StateList.add("Select State");
        for (TheState s:state){
            if (s.C_Id.equals(id)){
                // Toast.makeText(getApplicationContext(), s.State.toString(), Toast.LENGTH_LONG).show();
                StateList.add(s.State.toString()); }
        }
    }













    public void showInformationFunction(View view){
        Toast.makeText(getApplicationContext(),
        "Country : "+selected_country_string
        +"\nState : "+selected_state_string,
        Toast.LENGTH_LONG).show();
    }
}