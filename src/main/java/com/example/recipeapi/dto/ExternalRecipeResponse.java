package com.example.recipeapi.dto;

import lombok.Data;
import java.util.List;

@Data
public class ExternalRecipeResponse {
    private List<RecipeDto> recipes;
    private Integer total;
    private Integer skip;
    private Integer limit;
}