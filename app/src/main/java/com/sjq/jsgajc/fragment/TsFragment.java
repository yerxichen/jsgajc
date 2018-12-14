package com.sjq.jsgajc.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sjq.jsgajc.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TsFragment extends Fragment {


    public TsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ts, container, false);
    }

}
