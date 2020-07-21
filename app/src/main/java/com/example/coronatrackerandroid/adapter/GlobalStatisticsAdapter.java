package com.example.coronatrackerandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.coronatrackerandroid.R;
import com.example.coronatrackerandroid.model.GlobalStatistics;

import java.util.List;

//public class GlobalStatisticsAdapter extends RecyclerView.Adapter<GlobalStatisticsAdapter.CustomViewHolder> {
//
//    private List<GlobalStatistics> dataList;
//    private Context context;
//
//    public GlobalStatisticsAdapter(Context context, List<GlobalStatistics> dataList){
//        this.context = context;
//        this.dataList = dataList;
//
//    }
//
//    class CustomViewHolder extends RecyclerView.ViewHolder{
//
//        public final View mView;
//
//        TextView txtTitle;
//        private ImageView coverImage;
//
//        CustomViewHolder(View itemView) {
//            super(itemView);
//            mView = itemView;
//            txtTitle = mView.findViewById(R.id.title);
//        }
//
//    }
//
//    @Override
//    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
//        View view = layoutInflater.inflate(R.layout.custom_row, parent, false);
//        return new CustomViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(CustomViewHolder holder, int position) {
//        holder.txtTitle.setText(dataList.get(position).getTitle());
//
//
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return dataList.size();
//    }
//}
