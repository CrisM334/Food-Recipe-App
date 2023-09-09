package com.example.mp6;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private HomeBroadcastReceiver receiver;
    private IntentFilter filter;

    RecyclerView recyclerView;
    MealItemAdapter adapter;

    List<MealItem> menuItems1_7;

    private static final int ADD_ITEM_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        receiver = new HomeBroadcastReceiver();

        filter = new IntentFilter("com.example.I_AM_HOME");

        FloatingActionButton fabAdd = findViewById(R.id.fab_add);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddItemActivity.class);
                startActivityForResult(intent, ADD_ITEM_REQUEST);
            }
        });

        recyclerView = findViewById(R.id.recyclerView_id);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        menuItems1_7 = new ArrayList<>();
        menuItems1_7.add((new MealItem(getString(R.string.item_alfredo_pasta),
                getString(R.string.item_alfredo_pasta_description),
                getString(R.string.item_alfredo_pasta_otherTitle),
                getString(R.string.item_alfredo_pasta_ingCal), R.drawable.pasta,
                "https://www.thekitchn.com/how-to-make-chicken-alfredo-pasta-249767")
        ));


//Lemon Chicken
        menuItems1_7.add((new MealItem(getString(R.string.item_lemon_chicken),
                getString(R.string.item_lemon_chicken_description),
                getString(R.string.item_lemon_chicken_otherTitle),
                getString(R.string.item_lemon_chicken_ingCal),R.drawable.chicken,
                "https://natashaskitchen.com/lemon-chicken-recipe/")
        ));

//cheesecake
        menuItems1_7.add((new MealItem(getString(R.string.item_cheesecake),
                getString(R.string.item_cheesecake_description),
                getString(R.string.item_cheesecake_otherTitle),
                getString(R.string.item_cheesecake_ingCal),R.drawable.cheesecake,
                "https://sugarspunrun.com/best-cheesecake-recipe/")
        ));


//french Fries
        menuItems1_7.add((new MealItem(getString(R.string.item_frenchFries),
                getString(R.string.item_frenchFries_description),
                getString(R.string.item_frenchFries_otherTitle),
                getString(R.string.item_frenchFries_ingCal),R.drawable.frenchfries,
                "https://thecozycook.com/homemade-french-fries/")
        ));


//spaghetti
        menuItems1_7.add((new MealItem(getString(R.string.item_spaghetti),
                getString(R.string.item_spaghetti_description),
                getString(R.string.item_spaghetti_otherTitle),
                getString(R.string.item_spaghetti_ingCal),R.drawable.spaghetti,
                "https://lilluna.com/spaghetti-recipe/")
        ));


//pizza
        menuItems1_7.add((new MealItem(getString(R.string.item_pizza),
                getString(R.string.item_pizza_description),
                getString(R.string.item_pizza_otherTitle),
                getString(R.string.item_pizza_ingCal),R.drawable.pizza,
                "https://thefoodcharlatan.com/homemade-pizza-recipe/")
        ));


//ribs
        menuItems1_7.add((new MealItem(getString(R.string.item_ribs),
                getString(R.string.item_ribs_description),
                getString(R.string.item_ribs_otherTitle),
                getString(R.string.item_ribs_ingCal),R.drawable.ribs,
                "https://cafedelites.com/oven-barbecue-ribs/")
        ));



        adapter = new MealItemAdapter(this, menuItems1_7);

        int numColumns = getResources().getInteger(R.integer.grid_columns);
        recyclerView.setLayoutManager(new GridLayoutManager(this, numColumns));
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_ITEM_REQUEST && resultCode == RESULT_OK) {
            if (data != null) {
                String title = data.getStringExtra("title");
                String description = data.getStringExtra("description");
                String otherName = data.getStringExtra("otherName");
                String ingredientsCalories = data.getStringExtra("ingredientsCalories");
                String recipeUrl = data.getStringExtra("recipeUrl");

                MealItem newItem = new MealItem(title, description, otherName, ingredientsCalories, R.drawable.food, recipeUrl);
                menuItems1_7.add(newItem);
                adapter.notifyDataSetChanged();

                Toast.makeText(this, "New Meal Item has been added", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.infoButton) {
            infoDialog();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void infoDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Info")
                .setMessage("This is the Foodie App, that will allow you to pick menu items and show their image, title, description, ingredients, calories, and link to online recipe")
                .setPositiveButton("OK", null)
                .show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        receiver = new HomeBroadcastReceiver();
        filter = new IntentFilter("com.example.I_AM_HOME");
        registerReceiver(receiver, filter);
    }

    @Override
    protected void onPause() {
        super.onPause();

        unregisterReceiver(receiver);
    }

    public void broadcastIntent(View view) {
        Intent intent = new Intent();
        intent.setAction("com.example.I_AM_HOME");

        Random random = new Random();
        int index = random.nextInt(menuItems1_7.size());
        MealItem mealItem = menuItems1_7.get(index);
        intent.putExtra("mealTitle", mealItem.getFoodName());

        sendBroadcast(intent);
    }

    public class HomeBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("com.example.I_AM_HOME")) {
                String mealTitle = intent.getStringExtra("mealTitle");

                Intent detailsIntent = new Intent(MainActivity.this, MealDetailsActivity.class);
                detailsIntent.putExtra("mealTitle", mealTitle);
                startActivity(detailsIntent);

                String toastMessage = "Happy Cooking " + mealTitle;
                Toast.makeText(MainActivity.this, toastMessage, Toast.LENGTH_SHORT).show();
            }
        }
    }


}


