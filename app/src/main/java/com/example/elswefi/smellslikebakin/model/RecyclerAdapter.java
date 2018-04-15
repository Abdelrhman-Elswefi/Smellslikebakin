package com.example.elswefi.smellslikebakin.model;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.elswefi.smellslikebakin.R;

/**
 * Created by elswe on 05-Apr-18 At 5:02 PM.
 */

public abstract class RecyclerAdapter extends RecyclerView.Adapter{


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(getLayoutId(),parent,
                false);
        return new ViewHolder(view);
    }

    protected abstract int getLayoutId();

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder) holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return Recipes.names.length;
    }


    private class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
         private TextView mRecipeText;
         private ImageView mRecipeImage;
         private int mIndex;
        public ViewHolder(View itemView) {
            super(itemView);
            mRecipeImage = itemView.findViewById(R.id.itemImage);
            mRecipeText = itemView.findViewById(R.id.itemText);
            itemView.setOnClickListener(this);
        }

        public void bindView(int position) {
            mIndex = position;
            mRecipeText.setText(Recipes.names[position]);
            mRecipeImage.setImageResource(Recipes.resourceIds[position]);
        }

        @Override
        public void onClick(View view) {
            onRecipeItemSelected(mIndex);
        }
    }

    protected abstract void onRecipeItemSelected(int index);
}
