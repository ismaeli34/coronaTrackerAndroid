package com.example.coronatrackerandroid.ui.countries;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.coronatrackerandroid.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CountryDetailsFragment extends Fragment {

    private int  positionCountry;
    TextView tvCountry, tvCases,tvRecovered,tvCritical,tvActive,tvTodayCases,tvTodayDeaths,tvDeaths;
    private static final String TAG = "Ronney";

    public CountryDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_country_details, container, false);
         positionCountry = getArguments().getInt("position");
        Log.d(TAG, ""+positionCountry);

//        Intent intent = getActivity().getIntent();
//        positionCountry = intent.getIntExtra("position",0);
        tvCases=  view.findViewById(R.id.tvCases);
        tvCountry = view.findViewById(R.id.tvCountryName);
        tvRecovered = view.findViewById(R.id.tvRecovered);
        tvCritical = view.findViewById(R.id.tvCritical);
        tvActive = view.findViewById(R.id.tvActive);
        tvTodayCases = view.findViewById(R.id.tvTodayCases);
        tvDeaths = view.findViewById(R.id.tvDeath);

        tvCountry.setText(CountriesFragment.countryModelList.get(positionCountry).getCountry());
        tvCases.setText(CountriesFragment.countryModelList.get(positionCountry).getCases());
        tvRecovered.setText(CountriesFragment.countryModelList.get(positionCountry).getRecovered());
        tvCritical.setText(CountriesFragment.countryModelList.get(positionCountry).getCritical());
        tvActive.setText(CountriesFragment.countryModelList.get(positionCountry).getActive());
        tvTodayCases.setText(CountriesFragment.countryModelList.get(positionCountry).getTodayCases());
        tvDeaths.setText(CountriesFragment.countryModelList.get(positionCountry).getDeaths());





        return view;
    }
}
