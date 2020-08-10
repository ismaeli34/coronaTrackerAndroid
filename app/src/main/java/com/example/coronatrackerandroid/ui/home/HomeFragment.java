package com.example.coronatrackerandroid.ui.home;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
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
import com.google.android.material.chip.Chip;
import com.leo.simplearcloader.SimpleArcLoader;

import org.eazegraph.lib.charts.BarChart;
import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.charts.ValueLineChart;
import org.eazegraph.lib.models.BarModel;
import org.eazegraph.lib.models.PieModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private static final String TAG = "Ronney";
    TextView tvCases,tvRecovered,tvCritical,tvActive,tvTodayCases,tvTodayDeaths,tvTotalDeaths,tvAffectedCountries,tvTodayRecovered,tvTodayActive;
    private HomeViewModel homeViewModel;
    ScrollView scrollView;
    PieChart pieChart;
    BarChart barChart;
    SimpleArcLoader simpleArcLoader;
    Button piechartButton,barChartButton;
    CardView barchartCardView,piechartCardView;
    Boolean toogleCharts = false;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        piechartButton = root.findViewById(R.id.piechartButton);
        barChartButton = root.findViewById(R.id.barChartButton);
        tvCases=  root.findViewById(R.id.tvCases);
        tvRecovered = root.findViewById(R.id.tvRecovered);
//        tvCritical = root.findViewById(R.id.tvCritical);
        tvActive = root.findViewById(R.id.tvActive);

        tvTotalDeaths = root.findViewById(R.id.tvTotalDeath);
        simpleArcLoader = root.findViewById(R.id.loader);
        scrollView = root.findViewById(R.id.scrollStats);
        tvTodayCases = root.findViewById(R.id.todayCases);
        tvTodayDeaths = root.findViewById(R.id.todayDeaths);
        tvTodayRecovered = root.findViewById(R.id.todayRecovered);
        pieChart = root.findViewById(R.id.piechart);
        barChart = root.findViewById(R.id.barchart);
        barchartCardView= root.findViewById(R.id.barchartCardView);
        piechartCardView = root.findViewById(R.id.pieChartCard);
        piechartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pieChart.startAnimation();
                piechartCardView.setVisibility(View.VISIBLE);
                barchartCardView.setVisibility(View.GONE);
                toogleCharts = true;
            }
        });

        barChartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                barChart.startAnimation();
                barchartCardView.setVisibility(View.VISIBLE);
                piechartCardView.setVisibility(View.GONE);
                toogleCharts = false;

            }
        });

        fetchData(toogleCharts);

//        final TextView textView = root.findViewById(R.id.text_home);
//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }

    private void fetchData(final Boolean toogleCharts) {

        simpleArcLoader.start();

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<GlobalStatistics> call = service.getStatisticsResult();
        call.enqueue(new Callback<GlobalStatistics>() {
            @Override
            public void onResponse(Call<GlobalStatistics> call, Response<GlobalStatistics> response) {
                if(response.isSuccessful()){
                   GlobalStatistics data= response.body();
                    int critical = data.getCritical();
                   int cases = data.getCases();
                   int active = data.getActive();
                   int death = data.getDeaths();
                   int recovered = data.getRecovered();
                   int todayCases = data.getTodayCases();
                   int todayDeath = data.getTodayDeaths();
                   int todayRecovered = data.getTodayRecovered();
//                   int todayActive = data.getTodayActive();



                    Log.d(TAG,""+cases);
                    tvActive.setText(""+active);
                    tvCases.setText(""+ cases)  ;
                    tvRecovered.setText(""+recovered);
//                    tvCritical.setText(""+ critical);
                    tvTotalDeaths.setText(""+ death );
                    tvTodayDeaths.setText("" + todayDeath);
                    tvTodayCases.setText("" + todayCases);
                    tvTodayRecovered.setText(""+ todayRecovered);
//                    tvTodayActive.setText(""+ todayActive);
                    simpleArcLoader.stop();
                    simpleArcLoader.setVisibility(View.GONE);
                    scrollView.setVisibility(View.VISIBLE);
                    pieChartinit();
                    barChartInit();
                }
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

    public void  pieChartinit(){
        pieChart.addPieSlice(new PieModel("Cases",Integer.parseInt(tvCases.getText().toString()), Color.parseColor("#FFA726")));
        pieChart.addPieSlice(new PieModel("Recovered",Integer.parseInt(tvRecovered.getText().toString()), Color.parseColor("#66BB6A")));
        pieChart.addPieSlice(new PieModel("Deaths",Integer.parseInt(tvTotalDeaths.getText().toString()), Color.parseColor("#EF5350")));
        pieChart.addPieSlice(new PieModel("Active",Integer.parseInt(tvActive.getText().toString()), Color.parseColor("#42A5F5")));
        pieChart.startAnimation();
    }

    public void barChartInit(){
        barChart.addBar(new BarModel(Float.parseFloat(tvCases.getText().toString()),Color.parseColor("#FFA726")));
        barChart.addBar(new BarModel(Float.parseFloat(tvRecovered.getText().toString()),Color.parseColor("#66BB6A")));
        barChart.addBar(new BarModel(Float.parseFloat(tvTotalDeaths.getText().toString()),Color.parseColor("#EF5350")));
        barChart.addBar(new BarModel(Float.parseFloat(tvActive.getText().toString()),Color.parseColor("#42A5F5")));
        barChart.startAnimation();
    }
}
