package com.nhc.nhcmaterialrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by NHC on 16/11/15.
 */
public class AnimationRecyclerViewAdapter extends RecyclerView.Adapter<AnimationRecyclerViewAdapter.ViewHolder> {
    private List<String> data;

    public AnimationRecyclerViewAdapter(List<String> data) {
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
        holder.setItemContent(data.get(position), position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView tvText;
        private String clickItem;
        private int position;

        public ViewHolder(View v) {
            super(v);
            v.setOnClickListener(this);
            tvText = (TextView) v.findViewById(R.id.tv_text);
        }

        public void setItemContent(String text, int position) {
            clickItem = text;
            this.position = position;
            tvText.setText(text);
        }

        @Override
        public void onClick(View v) {
            if (position%2 == 0) {
                data.add(position, data.get(position));
                AnimationRecyclerViewAdapter.this.notifyItemInserted(position);
            }
            else {
                data.remove(position);
                AnimationRecyclerViewAdapter.this.notifyItemRemoved(position);
            }
        }
    }
}
