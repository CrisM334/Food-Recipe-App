package com.example.mp6;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MealDetailsActivity extends AppCompatActivity {

    private ImageView mealImage;
    private TextView mealTitle;
    private TextView mealDescription;
    private TextView mealOtherName;
    private TextView mealIngredientsCalories;

    private List<MealItem> menuItems1_7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_details);

        mealImage = findViewById(R.id.meal_image);
        mealTitle = findViewById(R.id.meal_title);
        mealDescription = findViewById(R.id.meal_description);
        mealOtherName = findViewById(R.id.meal_other_name);
        mealIngredientsCalories = findViewById(R.id.meal_ingredients_calories);

        String mealTitleText = getIntent().getStringExtra("mealTitle");

        menuItems1_7 = new ArrayList<>();
        menuItems1_7.add((new MealItem(getString(R.string.item_alfredo_pasta),
                getString(R.string.item_alfredo_pasta_description),
                getString(R.string.item_alfredo_pasta_otherTitle),
                getString(R.string.item_alfredo_pasta_ingCal), R.drawable.pasta,
                "https://www.thekitchn.com/how-to-make-chicken-alfredo-pasta-249767")
        ));

        menuItems1_7.add((new MealItem(getString(R.string.item_lemon_chicken),
                getString(R.string.item_lemon_chicken_description),
                getString(R.string.item_lemon_chicken_otherTitle),
                getString(R.string.item_lemon_chicken_ingCal), R.drawable.chicken,
                "https://natashaskitchen.com/lemon-chicken-recipe/")
        ));

        menuItems1_7.add((new MealItem(getString(R.string.item_cheesecake),
                getString(R.string.item_cheesecake_description),
                getString(R.string.item_cheesecake_otherTitle),
                getString(R.string.item_cheesecake_ingCal), R.drawable.cheesecake,
                "https://sugarspunrun.com/best-cheesecake-recipe/")
        ));

        menuItems1_7.add((new MealItem(getString(R.string.item_frenchFries),
                getString(R.string.item_frenchFries_description),
                getString(R.string.item_frenchFries_otherTitle),
                getString(R.string.item_frenchFries_ingCal), R.drawable.frenchfries,
                "https://thecozycook.com/homemade-french-fries/")
        ));

        menuItems1_7.add((new MealItem(getString(R.string.item_spaghetti),
                getString(R.string.item_spaghetti_description),
                getString(R.string.item_spaghetti_otherTitle),
                getString(R.string.item_spaghetti_ingCal), R.drawable.spaghetti,
                "https://lilluna.com/spaghetti-recipe/")
        ));

        menuItems1_7.add((new MealItem(getString(R.string.item_pizza),
                getString(R.string.item_pizza_description),
                getString(R.string.item_pizza_otherTitle),
                getString(R.string.item_pizza_ingCal), R.drawable.pizza,
                "https://thefoodcharlatan.com/homemade-pizza-recipe/")
        ));

        menuItems1_7.add((new MealItem(getString(R.string.item_ribs),
                getString(R.string.item_ribs_description),
                getString(R.string.item_ribs_otherTitle),
                getString(R.string.item_ribs_ingCal), R.drawable.ribs,
                "https://cafedelites.com/oven-barbecue-ribs/")
        ));

        MealItem mealItem = null;
        for (MealItem item : menuItems1_7) {
            if (item.getFoodName().equals(mealTitleText)) {
                mealItem = item;
                break;
            }
        }

        if (mealItem != null) {
            mealImage.setImageResource(mealItem.getPiccc());
            mealTitle.setText(mealItem.getFoodName());
            mealDescription.setText(mealItem.getFoodDescription());
            mealOtherName.setText(mealItem.getotherName());
            mealIngredientsCalories.setText(mealItem.getfoodIngredientsCalories());
        }
    }
}



