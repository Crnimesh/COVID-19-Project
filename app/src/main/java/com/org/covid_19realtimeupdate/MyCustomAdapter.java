package com.org.covid_19realtimeupdate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyCustomAdapter extends ArrayAdapter<ModelCountryName> {
    private Context context;
    private List<ModelCountryName>modelCountryNameList;

    public MyCustomAdapter(Context context, List<ModelCountryName>modelCountryNameList) {
        super(context, R.layout.list_custom_item,modelCountryNameList);

        this.context = context;
        this.modelCountryNameList = modelCountryNameList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_custom_item,null,true);
        TextView tvCountryName = view.findViewById(R.id.tvCountryName);
        ImageView imageView = view.findViewById(R.id.imageFlag);
        tvCountryName.setText(modelCountryNameList.get(position).getCountry());
        Glide.with(context).load(modelCountryNameList.get(position).getFlag()).into(imageView);

        return super.getView(position, convertView, parent);
    }
}
