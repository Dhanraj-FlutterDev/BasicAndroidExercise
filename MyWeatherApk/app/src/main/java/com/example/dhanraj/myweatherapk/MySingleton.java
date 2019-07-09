package com.example.dhanraj.myweatherapk;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.toolbox.Volley;

/**
 * Created by Dhanraj on 16-12-2017.
 */

public class MySingleton {

    private static MySingleton myinstance;
    private com.android.volley.RequestQueue requestQueue;
    private static Context myContext;



    private MySingleton(Context context){

        myContext = context;
        requestQueue = getRequestQueue();

    }

    public com.android.volley.RequestQueue getRequestQueue(){
        if(requestQueue == null){
            requestQueue = Volley.newRequestQueue(myContext.getApplicationContext());
        }
        return requestQueue;

    }


    public static synchronized MySingleton getMyinstance(Context context){
        if(myinstance == null)
        {
            myinstance = new MySingleton(context);
        }
        return myinstance;

    }
    public void addToRequestQue(Request request){
        requestQueue.add(request);
    }




}
