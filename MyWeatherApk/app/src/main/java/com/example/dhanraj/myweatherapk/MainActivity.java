package com.example.dhanraj.myweatherapk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText city;
    TextView result;

    // http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22
    String baseURL = "http://api.openweathermap.org/data/2.5/weather?q=";
    String API = "&appid=183e2ca7a035f5f022ba11340e24c642";

    // http://api.openweathermap.org/data/2.5/weather?q=Kolhapur,IN&appid=183e2ca7a035f5f022ba11340e24c642

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button = (Button)findViewById(R.id.button);
        city = (EditText)findViewById(R.id.getCIty);
        result = (TextView) findViewById(R.id.result);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String myURL = baseURL + city.getText().toString() + API;
                Log.i("URL","URL : "+myURL);

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, myURL, null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                Log.i("JSON","Json :"+ response);




                                try {
                                    String infoW = response.getString("weather");
                                    //Log.i("Info","InfoW :"+ infoW);

                                    JSONArray ar = new JSONArray(infoW);

                                    for (int i = 0;i<ar.length();i++)
                                    {
                                        JSONObject partialObject = ar.getJSONObject(i);

                                        String myWeather = partialObject.getString("main");

                                        result.setText(myWeather);
                                        Log.i("ID","ID :"+ partialObject.getString("id"));
                                        Log.i("MAIN","MAIN :"+ partialObject.getString("main"));
                                    }

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.i("Error", "Something went wrong"+ error);
                            }
                        }


                );
                MySingleton.getMyinstance(MainActivity.this).addToRequestQue(jsonObjectRequest);


            }
        });






    }
}
