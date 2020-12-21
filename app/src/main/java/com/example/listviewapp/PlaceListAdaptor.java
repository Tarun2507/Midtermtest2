package com.example.listviewapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PlaceListAdaptor extends BaseAdapter {
    private List<PlacesofVisit> placesofVisitList;
    LayoutInflater layoutInflater;
    public PlaceListAdaptor(Context context, List<PlacesofVisit> placesList) {
        this.placesofVisitList = placesList;
        layoutInflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return placesofVisitList.size();
    }

    @Override
    public Object getItem(int i) {
        return placesofVisitList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //getting the view and setting the data
        ViewHolder holder = new ViewHolder();
        if(view==null) {
            view = layoutInflater.inflate(R.layout.list_row,null);
            holder.img = view.findViewById(R.id.image);
            holder.name = view.findViewById(R.id.name);
            holder.cost = view.findViewById(R.id.cost);
            view.setTag(holder);
        }
        else
            view.getTag();

        int id = view.getResources().getIdentifier(placesofVisitList.get(i).getImgName(),"drawable",view.getContext().getPackageName());
        holder.img.setImageResource(id);
        holder.name.setText(placesofVisitList.get(i).getName());
        holder.cost.setText(String.valueOf(placesofVisitList.get(i).getPrice()));

        return view;
    }
    static class ViewHolder{
        ImageView img;
        TextView name,cost;
    }
}
