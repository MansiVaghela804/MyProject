package com.example.admin.myproject.Listview;

import android.content.ClipData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.myproject.R;

import java.util.ArrayList;

public class Adapter extends ArrayAdapter<item>{

    ArrayList<item> items;

    private int layoutId;

    public Adapter(@NonNull Context context, int layoutId, ArrayList<item> items) {
        super(context, layoutId, items);
        this.layoutId = layoutId;
        this.items = items;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        item Item = items.get(position);

        ViewHolder viewHolder;

        if (convertView == null) {

            viewHolder = new ViewHolder();

            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(layoutId, parent, false);

            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.image_view);
            viewHolder.textView = (TextView) convertView.findViewById(R.id.text_view);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.textView.setText(Item.getListitem());
        viewHolder.imageView.setImageResource(Item.getImageId());

        return convertView;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    public static class ViewHolder {
        TextView textView;
        ImageView imageView;
    }


}
