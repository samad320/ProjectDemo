package com.example.projectdemo;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class BoxAdapter extends BaseAdapter {

    private Context context;
    private List<String> boxList;

    public BoxAdapter(Context context, List<String> boxList) {
        this.context = context;
        this.boxList = boxList;
    }

    @Override
    public int getCount() {
        return boxList.size();
    }

    @Override
    public Object getItem(int position) {
        return boxList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_box, parent, false);
            holder = new ViewHolder();
            holder.boxTextView = convertView.findViewById(R.id.boxTextView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        String boxText = boxList.get(position);
        holder.boxTextView.setText(boxText);

        return convertView;
    }

    private static class ViewHolder {
        TextView boxTextView;
    }
}

























///////////////////////////////////////////////////////////////

//import android.content.Context;
//import android.graphics.Color;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.TextView;
//
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.google.android.material.datepicker.YearGridAdapter;
//
//import java.util.List;
//
//public class BoxAdapter extends BaseAdapter {
//
//    private Context context;
//    private List<String> boxList;
//
//    public BoxAdapter(Context context, List<String> boxList) {
//        this.context = context;
//        this.boxList = boxList;
//    }
//
//    @Override
//    public int getCount() {
//        return boxList.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return boxList.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        YearGridAdapter.ViewHolder holder;
//
//        if (convertView == null) {
//            convertView = LayoutInflater.from(context).inflate(R.layout.item_box, parent, false);
//            holder = new YearGridAdapter.ViewHolder();
//            holder.boxTextView = convertView.findViewById(R.id.boxTextView);
//            convertView.setTag(holder);
//        } else {
//            holder = (YearGridAdapter.ViewHolder) convertView.getTag();
//        }
//
//        String boxText = boxList.get(position);
//        holder.boxTextView.setText(boxText);
//
//        return convertView;
//    }
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        ViewHolder holder;
//
//        if (convertView == null) {
//            convertView = LayoutInflater.from(context).inflate(R.layout.item_box, parent, false);
//            holder = new ViewHolder();
//            holder.boxTextView = convertView.findViewById(R.id.boxTextView);
//            convertView.setTag(holder);
//        } else {
//            holder = (ViewHolder) convertView.getTag();
//        }
//
//        // Set the background color of the box
//        Box box = boxList.get(position);
//        if (box.isSelected()) {
//            holder.boxTextView.setBackgroundColor(selectedColor);
//        } else {
//            holder.boxTextView.setBackgroundColor(Color.WHITE);
//        }
//
//        // Set the text inside the box
//        holder.boxTextView.setText(String.valueOf(box.getNumber()));
//
//        return convertView;
//    }
//
//    private static class ViewHolder {
//        TextView boxTextView;
//    }
//}

//public class BoxAdapter extends BaseAdapter {
//    private Context context;
//    private List<Integer> boxList;
//    private int selectedColor;
//
//    public BoxAdapter(Context context, List<Integer> boxList) {
//        this.context = context;
//        this.boxList = boxList;
//        this.selectedColor = Color.RED; // Default color is set to RED
//    }
//
//    @Override
//    public int getCount() {
//        return boxList.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return boxList.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        ViewHolder holder;
//
//        if (convertView == null) {
//            convertView = LayoutInflater.from(context).inflate(R.layout.item_box, parent, false);
//            holder = new ViewHolder();
//            holder.boxTextView = convertView.findViewById(R.id.boxTextView);
//            convertView.setTag(holder);
//        } else {
//            holder = (ViewHolder) convertView.getTag();
//        }
//
//        // Set the background color of the box
//        if (boxList.get(position) % 3 == 0) {
//            if (boxList.get(position) % (maxColorCount / 3) == 0) {
//                holder.boxTextView.setBackgroundColor(selectedColor);
//            } else {
//                holder.boxTextView.setBackgroundColor(Color.WHITE);
//            }
//        } else {
//            holder.boxTextView.setBackgroundColor(Color.WHITE);
//        }
//
//        // Set the text inside the box
//        holder.boxTextView.setText(String.valueOf(boxList.get(position)));
//
//        return convertView;
//    }
//
//    private static class ViewHolder {
//        TextView boxTextView;
//    }
//}
