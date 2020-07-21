package com.example.coronatrackerandroid.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.coronatrackerandroid.R;
import com.example.coronatrackerandroid.model.CountryModel;

import java.util.List;

public class CountriesAdapter extends ArrayAdapter<CountryModel> {

    private static final String TAG = "Ronney";
    private Context context;
    private List<CountryModel> countryModelList;


    public CountriesAdapter(@NonNull Context context, List<CountryModel> countryModelList) {
        super(context, R.layout.list_custom_item,countryModelList);
        this.context = context;
        this.countryModelList = countryModelList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_custom_item,null,true);
        TextView tvCountryName = view.findViewById(R.id.tvCountryName);
        ImageView imageView = view.findViewById(R.id.imageFlag);
        Log.d(TAG,""+countryModelList.get(position).getCountry()) ;

        tvCountryName.setText(countryModelList.get(position).getCountry());
        Log.d(TAG,""+countryModelList.get(position).getCountryInfo().getFlag()) ;

        Glide.with(context).load(countryModelList.get(position).getCountryInfo().getFlag()).into(imageView);

        return view;
    }

    
}
