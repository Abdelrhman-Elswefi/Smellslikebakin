package com.example.elswefi.smellslikebakin.model;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import com.example.elswefi.smellslikebakin.R;

/**
 * Created by elswe on 15-Apr-18 At 2:56 AM.
 */

public abstract class RecipeFragment extends Fragment {
    private static final String KEY_CHECK_BOXES = "key_check_boxes";

    private CheckBox[] mCheckBoxes;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.directions_fragment, container, false);
        int mIndex = getArguments().getInt(ViewPagerFragment.KEY_RECIPE_INDEX);
        String[] content = GetContent(mIndex) ;

        LinearLayout linearLayout = view.findViewById(R.id.recipe_layout);
        mCheckBoxes = new CheckBox[content.length];
        boolean[] checkedBoxes = new boolean[mCheckBoxes.length];
        if (savedInstanceState != null && savedInstanceState.getBooleanArray(KEY_CHECK_BOXES) != null) {
            checkedBoxes = savedInstanceState.getBooleanArray(KEY_CHECK_BOXES);
        }
        setUpCheckBoxes(content , linearLayout ,checkedBoxes);
        return view;
    }

    public abstract String[] GetContent(int mIndex);

    private void setUpCheckBoxes(String[] contents, ViewGroup container, boolean[] checkedBoxes) {
        int i = 0 ;
        for (String content : contents) {
            mCheckBoxes[i] = new CheckBox(getActivity());
            mCheckBoxes[i].setText(content);
            mCheckBoxes[i].setTextSize(20f);
            mCheckBoxes[i].setPadding(8,16,8,16);
            container.addView(mCheckBoxes[i]);
            if (checkedBoxes[i]) {
                mCheckBoxes[i].toggle();
            }
            i++;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        boolean[] stateOfCheckBoxes = new boolean[mCheckBoxes.length];
        int i = 0;
        for (CheckBox checkBox : mCheckBoxes) {
            stateOfCheckBoxes[i] =checkBox.isChecked();
            i++;
        }
        outState.putBooleanArray(KEY_CHECK_BOXES ,stateOfCheckBoxes);
        super.onSaveInstanceState(outState);
    }
}
