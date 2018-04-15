package com.example.elswefi.smellslikebakin.model;

import com.example.elswefi.smellslikebakin.R;

/**
 * Created by elswe on 15-Apr-18 At 7:09 PM.
 */

public class GridAdapter extends RecyclerAdapter {
    private final GridFragment.onGridRecipeSelectedInterface mListener;

    public GridAdapter(GridFragment.onGridRecipeSelectedInterface listener) {
        mListener = listener;
    }
    @Override
    protected int getLayoutId() {
        return R.layout.grid_item;
    }

    @Override
    protected void onRecipeItemSelected(int index) {
        mListener.onGridRecipeItemSelected(index);
    }
}
