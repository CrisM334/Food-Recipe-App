package com.example.mp6;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mp6.MealItem;

public class AddItemActivity extends AppCompatActivity {

    private EditText titleEditText;
    private EditText descriptionEditText;
    private EditText otherNameEditText;
    private EditText ingredientsCaloriesEditText;
    private EditText recipeUrlEditText;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        titleEditText = findViewById(R.id.titleEditText);
        descriptionEditText = findViewById(R.id.descriptionEditText);

        otherNameEditText = findViewById(R.id.otherNameEditText);
        ingredientsCaloriesEditText = findViewById(R.id.ingredientsCaloriesEditText);

        recipeUrlEditText = findViewById(R.id.recipeUrlEditText);
        addButton = findViewById(R.id.addButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = titleEditText.getText().toString().trim();
                String description = descriptionEditText.getText().toString().trim();
                String otherName = otherNameEditText.getText().toString().trim();
                String ingredientsCalories = ingredientsCaloriesEditText.getText().toString().trim();
                String recipeUrl = recipeUrlEditText.getText().toString().trim();

                if (!title.isEmpty() && !description.isEmpty() && !otherName.isEmpty() && !ingredientsCalories.isEmpty() && !recipeUrl.isEmpty()) {
                    MealItem newMealItem = new MealItem(title, description, otherName, ingredientsCalories, R.drawable.food, recipeUrl);
                    Intent intent = new Intent();
                    intent.putExtra("title", title);
                    intent.putExtra("description", description);
                    intent.putExtra("otherName", otherName);
                    intent.putExtra("ingredientsCalories", ingredientsCalories);
                    intent.putExtra("recipeUrl", recipeUrl);
                    setResult(RESULT_OK, intent);
                } else {
                    setResult(RESULT_CANCELED);
                }

                finish();
            }
        });
    }
}







