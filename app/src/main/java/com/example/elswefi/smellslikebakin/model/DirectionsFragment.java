package com.example.elswefi.smellslikebakin.model;

/**
 * Created by elswe on 15-Apr-18 At 7:11 AM.
 */

public class DirectionsFragment extends RecipeFragment {
    @Override
    public String[] GetContent(int mIndex) {
        return Recipes.directions[mIndex].split("`");
    }
}
