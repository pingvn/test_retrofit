package com.example.intership.mark_i.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.intership.mark_i.R;
import com.example.intership.mark_i.Web.Web;

public class TotalStatisticFragment extends Fragment {
   private Web mWeb;
   private View mView;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.activity_fragment_totalstatistic, container, false);
        mWeb = new Web();
        mWeb.getTotalStatistic(getContext());
        return mView;
    }
}
