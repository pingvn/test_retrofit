package com.example.intership.mark_i.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.intership.mark_i.DataModelSmallApi.TotalStatistic;
import com.example.intership.mark_i.R;

import java.util.List;

public class TotalStatisticAdapter extends RecyclerView.Adapter<TotalStatisticAdapter.ViewHolder> {
    List<TotalStatistic> mList;

    public TotalStatisticAdapter(List<TotalStatistic> mList) {
        this.mList = mList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_card_total,parent,false);
        return new ViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TotalStatistic element = mList.get(position);
        holder.mTxtPerson.setText(element.getPerson_name());
        holder.mTxtRank.setText(element.getPerson_rank());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView mTxtPerson;
        TextView mTxtRank;

        public ViewHolder(View itemView) {
            super(itemView);
            mTxtPerson = (TextView) itemView.findViewById(R.id.id_txt_person);
            mTxtRank = (TextView) itemView.findViewById(R.id.id_txt_rank);
        }
    }
}
