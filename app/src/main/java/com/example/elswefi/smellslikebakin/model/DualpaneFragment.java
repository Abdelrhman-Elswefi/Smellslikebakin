package com.example.elswefi.smellslikebakin.model;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.elswefi.smellslikebakin.R;

/**
 * Created by elswe on 15-Apr-18 At 8:07 PM.
 */

public class DualpaneFragment extends Fragment {
    private static final String INGREDIENTS_FRAGMENT = "ingredients_fragment";
    private static final String DIRECTIONS_FRAGMENT = "directions_fragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        int index = getArguments().getInt(ViewPagerFragment.KEY_RECIPE_INDEX);
        getActivity().setTitle(Recipes.names[index]);
        View view = inflater.inflate(R.layout.fragment_viewpager, container, false);
        FragmentManager fragmentManager = getChildFragmentManager();
        IngredientsFragment savedIngredientsFragment = (IngredientsFragment) fragmentManager.findFragmentByTag
                (INGREDIENTS_FRAGMENT);
        if (savedIngredientsFragment == null) {
            final IngredientsFragment ingredientFragment = new IngredientsFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(ViewPagerFragment.KEY_RECIPE_INDEX, index);
            ingredientFragment.setArguments(bundle);
            fragmentManager.beginTransaction()
                    .add(R.id.leftPlaceholder, ingredientFragment, INGREDIENTS_FRAGMENT).commit();

        }

        DirectionsFragment savedDirectionsFragment = (DirectionsFragment) fragmentManager.findFragmentByTag
                (DIRECTIONS_FRAGMENT);
        if (savedDirectionsFragment == null) {
            final DirectionsFragment ingredientFragment = new DirectionsFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(ViewPagerFragment.KEY_RECIPE_INDEX, index);
            ingredientFragment.setArguments(bundle);
            fragmentManager.beginTransaction()
                    .add(R.id.rightPlaceholder, ingredientFragment, DIRECTIONS_FRAGMENT).commit();

        }

        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        getActivity().setTitle(getResources().getString(R.string.app_name));
    }
}
