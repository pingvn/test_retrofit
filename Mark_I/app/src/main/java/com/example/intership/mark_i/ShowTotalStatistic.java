package com.example.intership.mark_i;

import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.intership.mark_i.DataModel.TotalStatisticModel;
import com.example.intership.mark_i.Fragments.TotalStatisticFragment;

import java.util.List;

public class ShowTotalStatistic {
    private Spinner mSpinner;
    private Context mContext;
    View mView;

    public ShowTotalStatistic(View view) {
        mSpinner = (Spinner)view.findViewById(R.id.id_total_statistic_secet_site);
    }

    public void genSpinnerSite(List<TotalStatisticModel> mList) {


    }
}
