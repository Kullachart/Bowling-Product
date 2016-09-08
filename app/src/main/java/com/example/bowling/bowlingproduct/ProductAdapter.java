package com.example.bowling.bowlingproduct;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bowling.bowlingproduct.R;
import com.squareup.picasso.Picasso;

/**
 * Created by bowlingsakul on 9/8/2016 AD.
 */
public class ProductAdapter extends BaseAdapter{

    //Explicit
    private Context context;
    private String[] titleStrings,descriptionStrings,
            priceStrings, iconStrings;

    public ProductAdapter(Context context,
                          String[] titleStrings,
                          String[] descriptionStrings,
                          String[] priceStrings,
                          String[] iconStrings) {
        this.context = context;
        this.titleStrings = titleStrings;
        this.descriptionStrings = descriptionStrings;
        this.priceStrings = priceStrings;
        this.iconStrings = iconStrings;
    } // Constructor

    @Override
    public int getCount() {
        return titleStrings.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.product_listview, parent, false);

        //Bind Widget
        TextView tilteTextView = (TextView) view.findViewById(R.id.textView);
        TextView descripTextView = (TextView) view.findViewById(R.id.textView2);
        TextView priceTextView = (TextView) view.findViewById(R.id.textView3);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);


        // Show View
        tilteTextView.setText(titleStrings[position]);
        descripTextView.setText(descriptionStrings[position]);
        priceTextView.setText(priceStrings[position]);

        Picasso.with(context).load(iconStrings[position]).resize(150, 180).into(imageView);


        return view;
    }
}//Main Class
