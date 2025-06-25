package com.example.recipeapi.mapper;

import com.example.recipeapi.dto.RecipeDto;
import com.example.recipeapi.entity.Recipe;
import org.springframework.stereotype.Component;

@Component
public class RecipeMapper {

    public Recipe toEntity(RecipeDto dto) {
        if (dto == null) {
            return null;
        }

        Recipe recipe = new Recipe();
        recipe.setId(dto.getId());
        recipe.setName(dto.getName());
        recipe.setIngredients(dto.getIngredients());
        recipe.setInstructions(dto.getInstructions());
        recipe.setPrepTimeMinutes(dto.getPrepTimeMinutes());
        recipe.setCookTimeMinutes(dto.getCookTimeMinutes());
        recipe.setServings(dto.getServings());
        recipe.setDifficulty(dto.getDifficulty());
        recipe.setCuisine(dto.getCuisine());
        recipe.setCaloriesPerServing(dto.getCaloriesPerServing());
        recipe.setTags(dto.getTags());
        recipe.setImage(dto.getImage());
        recipe.setRating(dto.getRating());
        recipe.setReviewCount(dto.getReviewCount());
        recipe.setMealType(dto.getMealType());

        return recipe;
    }

    public RecipeDto toDto(Recipe entity) {
        if (entity == null) {
            return null;
        }

        RecipeDto dto = new RecipeDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setIngredients(entity.getIngredients());
        dto.setInstructions(entity.getInstructions());
        dto.setPrepTimeMinutes(entity.getPrepTimeMinutes());
        dto.setCookTimeMinutes(entity.getCookTimeMinutes());
        dto.setServings(entity.getServings());
        dto.setDifficulty(entity.getDifficulty());
        dto.setCuisine(entity.getCuisine());
        dto.setCaloriesPerServing(entity.getCaloriesPerServing());
        dto.setTags(entity.getTags());
        dto.setImage(entity.getImage());
        dto.setRating(entity.getRating());
        dto.setReviewCount(entity.getReviewCount());
        dto.setMealType(entity.getMealType());

        return dto;
    }
}