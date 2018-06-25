package com.example.intership.mark_i;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import java.util.List;

public class TotalStatistic {
    Spinner mSiteSpinner;
    View mView;
    RecyclerView mRecyclerView;

    public TotalStatistic(View mView) {
        mSiteSpinner = (Spinner)mView.findViewById(R.id.id_total_statistic_secet_site);
        this.mView = mView;
    }
    public void putSites(List<String> list){
        ArrayAdapter<String> mAdapterSpinner = new ArrayAdapter<String>(mView.getContext(),android.R.layout.simple_spinner_item, list);
        mAdapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSiteSpinner.setAdapter(mAdapterSpinner);

    }
}
