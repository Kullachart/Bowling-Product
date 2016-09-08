package com.example.bowling.bowlingproduct;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONObject;

public class ShowlistProduct extends AppCompatActivity implements View.OnClickListener {

    //Explicit
    private String categoryString;
    private TextView textView;
    private ListView listView;
    private Button button;
    private String urlJSONString;
    private String[] catStrings;

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

        //Button Controller
        button.setOnClickListener(this);  // Press alt+enter

        //Setup urlJSON
        MainActivity mainActivity = new MainActivity();
        catStrings = mainActivity.getCatStrings();

        if (categoryString.equals(catStrings[0])) {
            urlJSONString = "http://swiftcodingthai.com/bow/get_product_cat1_bowling.php";
        } else if (categoryString.equals(catStrings[1])) {
            urlJSONString = "http://swiftcodingthai.com/bow/get_product_cat2_bowling.php";
        } else if (categoryString.equals(catStrings[2])) {
            urlJSONString = "http://swiftcodingthai.com/bow/get_product_cat3_bowling.php";
        } else {
            urlJSONString = "http://swiftcodingthai.com/bow/get_product_cat4_bowling.php";
        }

        // Create Listview by Data on Server
        SynProduct synProduct = new SynProduct(this, listView, urlJSONString);
        synProduct.execute();


    }  // Main Method


    private class SynProduct extends AsyncTask<Void, Void, String> {


        //Explicit
        private Context context;
        private ListView myListView;
        private String myUrlJSONString;

        public SynProduct(Context context,
                          ListView myListView,
                          String myUrlJSONString) {
            this.context = context;
            this.myListView = myListView;
            this.myUrlJSONString = myUrlJSONString;
        }

        @Override
        protected String doInBackground(Void... params) {
            try {

                OkHttpClient okHttpClient = new OkHttpClient();
                Request.Builder builder = new Request.Builder();
                Request request = builder.url(myUrlJSONString).build();
                Response response = okHttpClient.newCall(request).execute();
                return response.body().string();


            } catch (Exception e) {
                return null;

            }



        }  // doinBack

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.d("BowlingV1", "JSON ===>" + s);

            try {

                JSONArray jsonArray = new JSONArray();
                String[] titleStrings = new String[jsonArray.length()];
                String[] descStrings = new String[jsonArray.length()];
                String[] descShortStrings = new String[jsonArray.length()];
                String[] priceStrings = new String[jsonArray.length()];
                String[] iconStrings = new String[jsonArray.length()];

                for (int i=0;i<jsonArray.length();i+=1) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    titleStrings[i] = jsonObject.getString("Product");
                    descStrings[i] = jsonObject.getString("Description");

                    descShortStrings[i] = descStrings[i].substring(0, 30) + "...";
                    priceStrings[i] = jsonObject.getString("Price" + " Baht");
                    iconStrings[i] = jsonObject.getString("Image");

                }  // For

//                ProductAdapter productAdapter = new ProductAdapter(context,
//                        titleStrings,descShortStrings,priceStrings,iconStrings);
//
//                myListView.setAdapter(productAdapter);

                MasterAdapter masterAdapter = new MasterAdapter(context, titleStrings,
                        descShortStrings, priceStrings, iconStrings);
                myListView.setAdapter(masterAdapter);

            } catch (Exception e) {
                e.printStackTrace();
            }


        }  // On post



    }// Syncproduct




    @Override
    public void onClick(View v) {
        finish();

    }
} // Main Class
