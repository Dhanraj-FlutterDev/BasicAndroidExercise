package com.example.dhanraj.starcolor;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    public static int getImageId(Context context, String imageName) {


        return context.getResources().getIdentifier("drawable/" + imageName, null, context.getPackageName());

    }



    public void Back(View view){

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        //intent.putExtra("name",colour.get(position));
        startActivity(intent);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ImageView imageView = (ImageView) findViewById(R.id.imageView);

        Intent intent = getIntent();
        Toast.makeText(this, intent.getStringExtra("name"),Toast.LENGTH_SHORT).show();

        String Colour = intent.getStringExtra("name");

        imageView.setImageResource(getImageId(this, Colour));
        TextView textView = (TextView)findViewById(R.id.changetext);
        //String imgname[] = {"Blue Star","Green Star","Red Star","Yellow Star"};
        //textView.setText();






    }
}
