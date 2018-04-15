package com.example.elswefi.smellslikebakin.model;

import com.example.elswefi.smellslikebakin.R;

/**
 * Created by elswe on 05-Apr-18 At 5:02 PM.
 */

public class ListAdapter extends RecyclerAdapter {
    private final ListFragment.onListRecipeSelectedInterface mListener;

    public ListAdapter(ListFragment.onListRecipeSelectedInterface listener) {
        mListener = listener;
    }

    @Override
    protected void onRecipeItemSelected(int index) {
        mListener.onListRecipeItemSelected(index);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.list_item;
    }
}
