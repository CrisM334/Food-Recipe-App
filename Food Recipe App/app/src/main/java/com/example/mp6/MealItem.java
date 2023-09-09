package com.example.mp6;

public class MealItem {

    private String foodName;
    private String foodDescription;
    private String otherName;
    private String foodIngredientsCalories;
    private int Piccc;

    private String recipeLinkk;

    public MealItem(String title, String descriptionnn, String otherTitle, String ingredientsCalories, int pic, String recipeLink){

        foodName = title;
        foodDescription = descriptionnn;
        otherName = otherTitle;
        foodIngredientsCalories = ingredientsCalories;
        Piccc = pic;

        this.recipeLinkk = recipeLink;
    }

    public  String getFoodName(){

        return foodName;
    }
    public String getFoodDescription(){
        return foodDescription;
    }

    public String getotherName(){
        return otherName;
    }

    public String getfoodIngredientsCalories(){
        return foodIngredientsCalories;
    }

    public int getPiccc(){
        return Piccc;
    }
    public String getRecipeUrl() {
        return recipeLinkk;
    }
}








