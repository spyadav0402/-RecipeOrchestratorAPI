package com.example.recipeapi.dto;

import lombok.Data;
import java.util.List;

@Data
public class RecipeDto {
    private Long id;
    private String name;
    private List<String> ingredients;
    private List<String> instructions;
    private Integer prepTimeMinutes;
    private Integer cookTimeMinutes;
    private Integer servings;
    private String difficulty;
    private String cuisine;
    private Double caloriesPerServing;
    private List<String> tags;
    private String image;
    private Double rating;
    private Integer reviewCount;
    private List<String> mealType;
}