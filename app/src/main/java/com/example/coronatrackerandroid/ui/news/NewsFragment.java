package com.example.coronatrackerandroid.ui.news;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.coronatrackerandroid.R;
import com.example.coronatrackerandroid.adapter.NewsRecyclerAdapter;
import com.example.coronatrackerandroid.model.NewsModel;
import com.example.coronatrackerandroid.model.NewsResponse;
import com.example.coronatrackerandroid.service.GetDataService;
import com.example.coronatrackerandroid.service.RetrofitClientInstance;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsFragment extends Fragment {

    private NewsViewModel mViewModel;
    private View view;
    private ArrayList<NewsFragment> list;
    private RecyclerView recyclerView;
    private NewsRecyclerAdapter adapter;
    private SwipeRefreshLayout refreshLayout;
    private Calendar calendar;
    private static final String TAG = "RonneyNews";

    public static NewsFragment newInstance() {
        return new NewsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.news_fragment, container, false);
        init();
        return view;
    }

    private void init() {
        recyclerView = view.findViewById(R.id.recycler_news);
        refreshLayout = view.findViewById(R.id.refresh_news);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        calendar = Calendar.getInstance();
        getNews();

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getNews();

            }


        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(NewsViewModel.class);
        // TODO: Use the ViewModel
    }

    private void getNews() {


        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<NewsResponse> call = service.getNews();
        call.enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                if(response.isSuccessful()) {
                    List<NewsModel> news= response.body().getArticles();

                    Log.d(TAG, "NUMBER OF NEWS RECEIVED "+ news.size());
                    recyclerView.setAdapter(new NewsRecyclerAdapter(getActivity(),news));




                }
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });



    }

}
