package com.example.bowling.bowlingproduct;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by masterUNG on 9/8/2016 AD.
 */
public class MasterAdapter extends BaseAdapter{

    //Explicit
    private Context context;
    private String[] titleStrings, descriptionStrings,
            priceStrings, iconStrings;

    public MasterAdapter(Context context,
                         String[] titleStrings,
                         String[] descriptionStrings,
                         String[] priceStrings,
                         String[] iconStrings) {
        this.context = context;
        this.titleStrings = titleStrings;
        this.descriptionStrings = descriptionStrings;
        this.priceStrings = priceStrings;
        this.iconStrings = iconStrings;
    }   // Constructor

    @Override
    public int getCount() {
        return titleStrings.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.product_listview, viewGroup, false);

        //Bind Widget
        TextView titleTextView = (TextView) view1.findViewById(R.id.textView);
        TextView descripTextView = (TextView) view1.findViewById(R.id.textView2);
        TextView priceTextView = (TextView) view1.findViewById(R.id.textView3);
        ImageView imageView = (ImageView) view1.findViewById(R.id.imageView);

        //Show View
        titleTextView.setText(titleStrings[i]);
        descripTextView.setText(descriptionStrings[i]);
        priceTextView.setText(priceStrings[i]);
        Picasso.with(context).load(iconStrings[i]).resize(150, 180).into(imageView);

        return view1;
    }
}   // Main Class