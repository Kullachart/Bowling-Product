package com.example.bowling.bowlingproduct;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class ShowlistProduct extends AppCompatActivity {

    //Explicit
    private String categoryString;
    private TextView textView;
    private ListView listView;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showlist_product);
        // Bind Wiget
        textView = (TextView) findViewById(R.id.textView8);
        listView = (ListView) findViewById(R.id.listView);
        button = (Button) findViewById(R.id.button);


        // Get Value from Intene
        categoryString = getIntent().getStringExtra("Category");

        //SHow Text
        textView.setText(categoryString);

    }  // Main Method



} // Main Class
