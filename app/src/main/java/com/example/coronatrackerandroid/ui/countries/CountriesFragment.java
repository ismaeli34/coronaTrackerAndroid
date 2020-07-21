package com.example.coronatrackerandroid.ui.countries;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.coronatrackerandroid.R;
import com.example.coronatrackerandroid.adapter.CountriesAdapter;
import com.example.coronatrackerandroid.model.CountryModel;
import com.example.coronatrackerandroid.model.GlobalStatistics;
import com.example.coronatrackerandroid.service.GetDataService;
import com.example.coronatrackerandroid.service.RetrofitClientInstance;
import com.leo.simplearcloader.SimpleArcLoader;

import org.eazegraph.lib.models.PieModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountriesFragment extends Fragment {

    private CountriesViewModel countriesViewModel;
    EditText edtSearch;
    ListView listView;
    SimpleArcLoader simpleArcLoader;
    public static List<CountryModel> countryModelList = new ArrayList<>();
    CountryModel countryModel;
    CountriesAdapter countriesAdapter;
    private static final String TAG = "Ronney";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        countriesViewModel =
                ViewModelProviders.of(this).get(CountriesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_countries, container, false);
       edtSearch= root.findViewById(R.id.editSearch);
        listView=root.findViewById(R.id.listView);
        simpleArcLoader=root.findViewById(R.id.loader);
        fetchData();
        countriesViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });
        return root;
    }

    private void fetchData() {
        simpleArcLoader.start();
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<CountryModel>> call = service.getCountries();
        call.enqueue(new Callback<List<CountryModel>>() {
            @Override
            public void onResponse(Call<List<CountryModel>> call, Response<List<CountryModel>> response) {
                if(response.isSuccessful()){
                    generateDataList(response.body());
                    simpleArcLoader.stop();
                    simpleArcLoader.setVisibility(View.GONE);
                }
            }
            @Override
            public void onFailure(Call<List<CountryModel>> call, Throwable t) {

                simpleArcLoader.setVisibility(View.GONE);
                simpleArcLoader.stop();

                Toast.makeText(getActivity(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void generateDataList(List<CountryModel> list) {
        countryModelList = list;
        countriesAdapter= new CountriesAdapter(getActivity(),countryModelList);
        listView.setAdapter(countriesAdapter);
        simpleArcLoader.stop();
        simpleArcLoader.setVisibility(View.GONE);

    }

}
