package com.example.leonzhang.androiddatastorage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by LeonZhang on 9/28/16.
 */
public class Display extends BaseAdapter {

    private MainActivity mainActivity;
    private List<String> items;

    public Display(MainActivity mainActivity,int resource,List<String> items){
        this.mainActivity=mainActivity;
        this.items=items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String item = items.get(position);
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) mainActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list,null);
        }
        TextView list = (TextView) convertView.findViewById(R.id.textView_list);
        list.setText(item);
        return convertView;
    }
}
