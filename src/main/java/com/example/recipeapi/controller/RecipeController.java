package com.example.recipeapi.controller;

import com.example.recipeapi.dto.RecipeDto;
import com.example.recipeapi.service.RecipeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/recipes")
@RequiredArgsConstructor
@Slf4j
@Validated
@Tag(name = "Recipe API", description = "API for managing and searching recipes")
public class RecipeController {

    private final RecipeService recipeService;

    @PostMapping("/load")
    @Operation(summary = "Load recipes from external API", description = "Loads all recipe data from external API into the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Recipes loaded successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Map<String, String>> loadRecipes() {
        log.info("Received request to load recipes from external API");

        recipeService.loadRecipesFromExternalApi();

        return ResponseEntity.ok(Map.of(
                "message", "Recipes loaded successfully",
                "status", "success"
        ));
    }

    @GetMapping("/search")
    @Operation(summary = "Search recipes", description = "Search recipes by name or cuisine using free text search")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Search completed successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid search query")
    })
    public ResponseEntity<List<RecipeDto>> searchRecipes(
            @Parameter(description = "Search query for recipe name or cuisine", required = true)
            @RequestParam("q") @NotBlank String query) {

        log.info("Received search request with query: {}", query);

        List<RecipeDto> recipes = recipeService.searchRecipes(query);

        return ResponseEntity.ok(recipes);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get recipe by ID", description = "Retrieve a specific recipe by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Recipe found"),
            @ApiResponse(responseCode = "404", description = "Recipe not found")
    })
    public ResponseEntity<RecipeDto> getRecipeById(
            @Parameter(description = "Recipe ID", required = true)
            @PathVariable Long id) {

        log.info("Received request to get recipe with id: {}", id);

        RecipeDto recipe = recipeService.getRecipeById(id);

        return ResponseEntity.ok(recipe);
    }

    @GetMapping
    @Operation(summary = "Get all recipes", description = "Retrieve all recipes from the database")
    @ApiResponse(responseCode = "200", description = "Recipes retrieved successfully")
    public ResponseEntity<List<RecipeDto>> getAllRecipes() {
        log.info("Received request to get all recipes");

        List<RecipeDto> recipes = recipeService.getAllRecipes();

        return ResponseEntity.ok(recipes);
    }
}