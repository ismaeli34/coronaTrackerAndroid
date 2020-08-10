package com.example.coronatrackerandroid.adapter;

import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;


import com.example.coronatrackerandroid.R;
import com.example.coronatrackerandroid.model.NewsModel;
import com.example.coronatrackerandroid.ui.news.NewsWebViewActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class NewsRecyclerAdapter extends RecyclerView.Adapter<NewsRecyclerAdapter.Holder>{
    private Context context;
    private List<NewsModel> list;
    NewsModel newsModel;

    public NewsRecyclerAdapter(Context context , List<NewsModel> list){
        this.context=context;
        this.list=list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_news_item,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        NewsModel news = list.get(position);
        newsModel = news;
        holder.txtTitle.setText(news.getTitle());
        holder.txtDesc.setText(news.getDescription());
        holder.txtDate.setText(news.getPublishedAt().substring(0,10));
        Picasso.get().load(news.getUrlToImage()).into(holder.imgNews);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder{

        private CardView cardView;
        private TextView txtTitle,txtDesc,txtDate;
        private ImageView imgNews;

        public Holder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card_news);
            txtTitle = itemView.findViewById(R.id.txtTitleNews);
            txtDesc = itemView.findViewById(R.id.txtDescNewss);
            txtDate = itemView.findViewById(R.id.txtDateNews);
            imgNews = itemView.findViewById(R.id.imgNews);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, NewsWebViewActivity.class);
                    intent.putExtra("url",newsModel.getUrl());
                    context.startActivity(intent);


                }
            });
        }
    }

}
