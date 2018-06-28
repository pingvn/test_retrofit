package com.example.intership.mark_i;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.intership.mark_i.Adapters.TotalStatisticAdapter;
import com.example.intership.mark_i.DataModelSmallApi.TotalStatistic;

import java.util.ArrayList;
import java.util.List;

public class ShowTotalStatistic {
    Spinner mSiteSpinner;
    View mView;
    RecyclerView mRecyclerView;
    List<TotalStatistic> list = new ArrayList<>();
    TotalStatisticAdapter mAdapter;

    public ShowTotalStatistic(View mView) {
        mSiteSpinner = (Spinner) mView.findViewById(R.id.id_total_statistic_secet_site);
        mRecyclerView = (RecyclerView) mView.findViewById(R.id.id_TotalRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mView.getContext()));
        mAdapter = new TotalStatisticAdapter(list);
        mRecyclerView.setAdapter(mAdapter);
        this.mView = mView;
    }

    public void putSites(final List<String> list, final List<TotalStatistic> mListTotalStatistic) {
        ArrayAdapter<String> mAdapterSpinner = new ArrayAdapter<String>(mView.getContext(), android.R.layout.simple_spinner_item, list);
        mAdapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSiteSpinner.setAdapter(mAdapterSpinner);
        mSiteSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                showTotalStatistic(findSiteId(list.get(position), mListTotalStatistic), mListTotalStatistic);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void showTotalStatistic(String siteID, List<TotalStatistic> mListTotalStatistic) {
        this.list.clear();
        this.list.addAll(sortbySiteId(siteID, mListTotalStatistic));
        mRecyclerView.getAdapter().notifyDataSetChanged();
    }

    private String findSiteId(String mSiteName, List<TotalStatistic> mListTotalStatistic) {
        for (int i = 0; i < mListTotalStatistic.size(); i++) {
            if (mListTotalStatistic.get(i).getSite_name().equals(mSiteName)) {
                return mListTotalStatistic.get(i).getSite_id();
            }
        }
        return "";
    }

    private List<TotalStatistic> sortbySiteId(String siteID, List<TotalStatistic> mListTotalStatistic) {
        List<TotalStatistic> mList = new ArrayList<>();
        for (int i = 0; i < mListTotalStatistic.size(); i++) {
            if (mListTotalStatistic.get(i).getSite_id().equals(siteID)) {
                mList.add(mListTotalStatistic.get(i));
            }
        }
        return mList;
    }


}
