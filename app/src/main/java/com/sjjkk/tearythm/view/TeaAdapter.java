package com.sjjkk.tearythm.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sjjkk.tearythm.R;
import com.sjjkk.tearythm.data.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sjjkk on 2017/9/10.
 */

public class TeaAdapter extends BaseAdapter {
    public TeaAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public TeaAdapter() {

    }

    public void setTeas(List<Data.ResultBean> teas) {
        this.teas = teas;
        notifyDataSetChanged();
    }

    List<Data.ResultBean> teas = new ArrayList<>();
    Context mContext;

    @Override
    public int getCount() {
        return teas.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Data.ResultBean tea = teas.get(position);
        View v = null;

        if (convertView != null) {
            v = convertView;
        } else {
            v = LayoutInflater.from(mContext.getApplicationContext()).inflate(
                    R.layout.list_item, null);
        }
        ImageView img = (ImageView) v.findViewById(R.id.image);
        TextView name = (TextView) v.findViewById(R.id.name);
        TextView description = (TextView) v.findViewById(R.id.description);
        Glide.with(mContext).load(tea.getImage_url()).into(img);
        name.setText(tea.getName());
        description.setText(tea.getFunction());


        return v;
    }
}
