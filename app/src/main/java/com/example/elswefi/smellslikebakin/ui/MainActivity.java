package com.example.elswefi.smellslikebakin.ui;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.elswefi.smellslikebakin.model.DualpaneFragment;
import com.example.elswefi.smellslikebakin.model.GridFragment;
import com.example.elswefi.smellslikebakin.model.ListFragment;
import com.example.elswefi.smellslikebakin.R;
import com.example.elswefi.smellslikebakin.model.ViewPagerFragment;

public class MainActivity extends AppCompatActivity implements ListFragment.onListRecipeSelectedInterface, GridFragment.onGridRecipeSelectedInterface {
    public static final String LIST_FRAGMENT = "list_fragment";
    public static final String VIEWPAGER_FRAGMENT = "viewpager_fragment";
    private static final String DUALPANE_FRAGMENT = "dualpane_fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boolean isTablet = getResources().getBoolean(R.bool.is_tablet);
        if (!isTablet) {
            ListFragment savedFragment = (ListFragment) getSupportFragmentManager()
                    .findFragmentByTag(LIST_FRAGMENT);
            if (savedFragment == null) {
                ListFragment listFragment = new ListFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.placeHolder, listFragment, LIST_FRAGMENT);
                fragmentTransaction.commit();
            }
        } else {
            GridFragment savedFragment = (GridFragment) getSupportFragmentManager()
                    .findFragmentByTag(LIST_FRAGMENT);
            if (savedFragment == null) {
                GridFragment gridFragment = new GridFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.placeHolder, gridFragment,LIST_FRAGMENT);
                fragmentTransaction.commit();
            }
        }



    }

    @Override
    public void onListRecipeItemSelected(int index) {
        ViewPagerFragment Fragment = new ViewPagerFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ViewPagerFragment.KEY_RECIPE_INDEX , index);
        Fragment.setArguments(bundle);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.placeHolder, Fragment, VIEWPAGER_FRAGMENT);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onGridRecipeItemSelected(int index) {
        DualpaneFragment Fragment = new DualpaneFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ViewPagerFragment.KEY_RECIPE_INDEX , index);
        Fragment.setArguments(bundle);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.placeHolder, Fragment, DUALPANE_FRAGMENT);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
