package com.example.mp6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;

import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private TextView afoodName;
    private TextView afoodDescription;
    private TextView aotherName;
    private TextView afoodIngredientsCalories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        afoodName = (TextView)findViewById(R.id.dish_name);
        afoodDescription = (TextView)findViewById(R.id.ingredients);
        aotherName = (TextView)findViewById(R.id.otherinformation);
        afoodIngredientsCalories = (TextView)findViewById(R.id.ingrCal);

        Intent intent = getIntent();
        String Title = intent.getExtras().getString("foodName");
        String Ingredients = intent.getExtras().getString("foodDescription");
        String MethodTitle = intent.getExtras().getString("otherName");
        String Recipe = intent.getExtras().getString("foodIngredientsCalories");

        afoodName.setText(Title);
        afoodDescription.setText(Ingredients);
        aotherName.setText(MethodTitle);
        afoodIngredientsCalories.setText(Recipe);

    }
}






