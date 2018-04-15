package com.example.elswefi.smellslikebakin.model;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.elswefi.smellslikebakin.R;

/**
 * Created by elswe on 05-Apr-18 At 12:52 PM.
 */

public class ListFragment extends Fragment {

    public interface onListRecipeSelectedInterface {
        void onListRecipeItemSelected(int index);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
//        Log.d(LoggingFragment.TAG, "onCreateView");
        onListRecipeSelectedInterface listener = (onListRecipeSelectedInterface) getActivity();
        View view = inflater.inflate(R.layout.fragment_recyclerview, container , false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        ListAdapter listAdapter = new ListAdapter(listener);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(listAdapter);
        return view;
    }
}
