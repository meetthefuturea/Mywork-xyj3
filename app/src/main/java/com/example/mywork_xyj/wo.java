package com.example.mywork_xyj;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.app.Fragment;


public class wo extends Fragment {

    public wo() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //将xml文件压缩至container
        return inflater.inflate(R.layout.fragment_wo, container, false);
    }
}