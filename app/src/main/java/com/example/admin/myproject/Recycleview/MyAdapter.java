package com.example.admin.myproject.Recycleview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.myproject.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<ItemData> itemsdata;
    public MyAdapter(List<ItemData> itemsData) {
        this.itemsdata = itemsData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_row_design, null);
        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
        }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ItemData data = itemsdata.get(position);
        holder.txtViewTitle.setText(data.getListitem());
        holder.imgViewIcon.setImageResource(data.getImageId());

    }

    @Override
    public int getItemCount() {

        return itemsdata.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView txtViewTitle;
        public ImageView imgViewIcon;

        public ViewHolder(View itemView) {
            super(itemView);

            txtViewTitle = (TextView) itemView.findViewById(R.id.mtext);
            imgViewIcon = (ImageView) itemView.findViewById(R.id.image_pro);
        }
    }
}
