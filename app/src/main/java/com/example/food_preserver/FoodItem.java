package com.example.food_preserver;

public class FoodItem {
    private String title;
    private String description;
    private int priority;

    public FoodItem() {
        //empty constructor needed
    }

    public FoodItem(String title, String description, int priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }
}

