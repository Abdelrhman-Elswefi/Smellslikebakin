package com.example.elswefi.smellslikebakin.model;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.elswefi.smellslikebakin.R;

/**
 * Created by elswe on 05-Apr-18 At 12:52 PM.
 */

public class GridFragment extends Fragment {

    public interface onGridRecipeSelectedInterface {
        void onGridRecipeItemSelected(int index);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
//        Log.d(LoggingFragment.TAG, "onCreateView");
        onGridRecipeSelectedInterface listener = (onGridRecipeSelectedInterface) getActivity();
        View view = inflater.inflate(R.layout.fragment_recyclerview, container , false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        GridAdapter gridAdapter = new GridAdapter(listener);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        int numColumns = (int) (dpWidth / 200);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(),numColumns);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(gridAdapter);
        return view;
    }
}