package com.example.elswefi.smellslikebakin.model;

/**
 * Created by elswe on 15-Apr-18 At 7:10 AM.
 */

public class IngredientsFragment extends RecipeFragment {
    @Override
    public String[] GetContent(int mIndex) {
        return Recipes.ingredients[mIndex].split("`");
    }
}
