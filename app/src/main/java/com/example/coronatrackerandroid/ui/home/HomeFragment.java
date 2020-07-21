package com.example.coronatrackerandroid.ui.home;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coronatrackerandroid.MainActivity;
import com.example.coronatrackerandroid.R;
import com.example.coronatrackerandroid.model.GlobalStatistics;
import com.example.coronatrackerandroid.service.GetDataService;
import com.example.coronatrackerandroid.service.RetrofitClientInstance;
import com.leo.simplearcloader.SimpleArcLoader;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private static final String TAG = "Ronney";
    TextView tvCases,tvRecovered,tvCritical,tvActive,tvTodayCases,tvTodayDeaths,tvTotalDeaths,tvAffectedCountries;
    private HomeViewModel homeViewModel;
    ScrollView scrollView;
    PieChart pieChart;
    SimpleArcLoader simpleArcLoader;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        tvCases=  root.findViewById(R.id.tvCases);
        tvRecovered = root.findViewById(R.id.tvRecovered);
        tvCritical = root.findViewById(R.id.tvCritical);
        tvActive = root.findViewById(R.id.tvActive);
        tvTodayCases = root.findViewById(R.id.tvTodayCases);
        tvTodayDeaths = root.findViewById(R.id.tvTodayDeath);
        tvTotalDeaths = root.findViewById(R.id.tvTotalDeath);
        simpleArcLoader = root.findViewById(R.id.loader);
        scrollView = root.findViewById(R.id.scrollStats);
        pieChart = root.findViewById(R.id.piechart);

        fetchData();

//        final TextView textView = root.findViewById(R.id.text_home);
//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }

    private void fetchData() {

        simpleArcLoader.start();

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<GlobalStatistics> call = service.getStatisticsResult();
        call.enqueue(new Callback<GlobalStatistics>() {
            @Override
            public void onResponse(Call<GlobalStatistics> call, Response<GlobalStatistics> response) {
                if(response.isSuccessful()){
                   GlobalStatistics data= response.body();
                   int cases = data.getCases();
                   int active = data.getActive();
                   int death = data.getDeaths();
                   int recovered = data.getRecovered();
                   int todayCases = data.getTodayCases();
                   int todayDeath = data.getTodayDeaths();
                   int critical = data.getCritical();
                    Log.d(TAG,""+cases);

                    tvActive.setText(""+active);
                    tvCases.setText(""+ cases)  ;
                    tvTodayCases.setText(""+todayCases);
                    tvRecovered.setText(""+recovered);
                    tvTodayDeaths.setText(""+ todayDeath);
                    tvCritical.setText(""+ critical);
                    tvTotalDeaths.setText(""+ death);

                    pieChart.addPieSlice(new PieModel("Cases",Integer.parseInt(tvCases.getText().toString()), Color.parseColor("#FFA726")));
                    pieChart.addPieSlice(new PieModel("Recovered",Integer.parseInt(tvRecovered.getText().toString()), Color.parseColor("#66BB6A")));
                    pieChart.addPieSlice(new PieModel("Deaths",Integer.parseInt(tvTotalDeaths.getText().toString()), Color.parseColor("#EF5350")));
                    pieChart.addPieSlice(new PieModel("Active",Integer.parseInt(tvActive.getText().toString()), Color.parseColor("#42A5F5")));
                    pieChart.startAnimation();
                    simpleArcLoader.stop();
                    simpleArcLoader.setVisibility(View.GONE);
                    scrollView.setVisibility(View.VISIBLE);




                }

//                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<GlobalStatistics> call, Throwable t) {
                simpleArcLoader.setVisibility(View.GONE);
                scrollView.setVisibility(View.VISIBLE);
                simpleArcLoader.stop();

                Toast.makeText(getActivity(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });


    }

    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void generateDataList(GlobalStatistics globaldata) {
        Log.d(TAG,""+globaldata);
//        recyclerView = findViewById(R.id.customRecyclerView);
//        adapter = new CustomAdapter(this,photoList);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(adapter);
    }
}
