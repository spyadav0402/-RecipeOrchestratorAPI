package com.example.recipeapi.service;

import com.example.recipeapi.dto.ExternalRecipeResponse;
import com.example.recipeapi.dto.RecipeDto;
import com.example.recipeapi.entity.Recipe;
import com.example.recipeapi.exception.RecipeNotFoundException;
import com.example.recipeapi.mapper.RecipeMapper;
import com.example.recipeapi.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final ExternalApiService externalApiService;
    private final RecipeMapper recipeMapper;

    @Transactional
    public void loadRecipesFromExternalApi() {
        log.info("Starting to load recipes from external API");

        ExternalRecipeResponse response = externalApiService.fetchRecipes();
        List<Recipe> recipes = response.getRecipes().stream()
                .map(recipeMapper::toEntity)
                .collect(Collectors.toList());

        // Clear existing data and save new data
        recipeRepository.deleteAll();
        recipeRepository.saveAll(recipes);

        log.info("Successfully loaded {} recipes into database", recipes.size());
    }

    public List<RecipeDto> searchRecipes(String query) {
        log.info("Searching recipes with query: {}", query);

        List<Recipe> recipes = recipeRepository.findByNameOrCuisineContainingIgnoreCase(query);

        log.info("Found {} recipes matching query: {}", recipes.size(), query);
        return recipes.stream()
                .map(recipeMapper::toDto)
                .collect(Collectors.toList());
    }

    public RecipeDto getRecipeById(Long id) {
        log.info("Fetching recipe with id: {}", id);

        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new RecipeNotFoundException("Recipe not found with id: " + id));

        return recipeMapper.toDto(recipe);
    }

    public List<RecipeDto> getAllRecipes() {
        log.info("Fetching all recipes");

        List<Recipe> recipes = recipeRepository.findAll();
        return recipes.stream()
                .map(recipeMapper::toDto)
                .collect(Collectors.toList());
    }
}