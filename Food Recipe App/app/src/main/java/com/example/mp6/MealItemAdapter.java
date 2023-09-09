package com.example.mp6;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.cardview.widget.CardView;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;



import java.util.List;

public class MealItemAdapter extends RecyclerView.Adapter<MealItemAdapter.MealItemHolder> {
    private List<MealItem> aData;
    private Context aContext;

    public MealItemAdapter(Context aContext, List<MealItem> aData){
        this.aContext = aContext;
        this.aData = aData;
    }
    @NonNull
    @Override
    public MealItemHolder onCreateViewHolder(@NonNull ViewGroup vG, int i) {
        View v;
        LayoutInflater layoutInflater = LayoutInflater.from(aContext);
        v = layoutInflater.inflate(R.layout.cardview1, vG, false);
        return new MealItemHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MealItemHolder mealItemHolder, int position) {
        mealItemHolder.titlee.setText(aData.get(mealItemHolder.getAdapterPosition()).getFoodName());
        mealItemHolder.foodImagee.setImageResource(aData.get(mealItemHolder.getAdapterPosition()).getPiccc());

        mealItemHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = mealItemHolder.getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    Intent intent = new Intent(aContext, DetailActivity.class);
                    intent.putExtra("foodName", aData.get(position).getFoodName());
                    intent.putExtra("foodDescription", aData.get(position).getFoodDescription());
                    intent.putExtra("otherName", aData.get(position).getotherName());
                    intent.putExtra("foodIngredientsCalories", aData.get(position).getfoodIngredientsCalories());
                    intent.putExtra("Piccc", aData.get(position).getPiccc());

                    aContext.startActivity(intent);
                }
            }
        });
        mealItemHolder.cardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int position = mealItemHolder.getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    removeMenuItem(position);
                }
                return true;
            }
        });

        mealItemHolder.titlee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String recipeLink = aData.get(mealItemHolder.getAdapterPosition()).getRecipeUrl();

                Intent IIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(recipeLink));
                aContext.startActivity(IIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return aData.size();
    }

    public class MealItemHolder extends RecyclerView.ViewHolder {
        TextView titlee;
        CardView cardView;
        ImageView foodImagee;

        public MealItemHolder(@NonNull View itemView) {
            super(itemView);
            titlee = itemView.findViewById(R.id.nameOfCardviewUnderIt);
            foodImagee = itemView.findViewById(R.id.imageForCardview);
            cardView = itemView.findViewById(R.id.cardview_id);
        }
    }

    public void removeMenuItem(int location) {
        aData.remove(location);
        notifyItemRemoved(location);
        notifyItemRangeChanged(location, aData.size());
    }
}





