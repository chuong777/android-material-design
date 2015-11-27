package com.nhc.nhcmaterialrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by NHC on 16/11/15.
 */
public class BasicRecyclerViewAdapter extends RecyclerView.Adapter<BasicRecyclerViewAdapter.ViewHolder> {
    private List<String> data;

    public BasicRecyclerViewAdapter(List<String> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_basic_recycler_view_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setItemContent(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView tvText;
        private String clickItem;

        public ViewHolder(View v) {
            super(v);
            v.setOnClickListener(this);
            tvText = (TextView) v.findViewById(R.id.tv_text);
        }

        public void setItemContent(String text) {
            clickItem = text;
            tvText.setText(text);
        }

        @Override
        public void onClick(View v) {
            Log.e("nhc", clickItem);
        }
    }
}
