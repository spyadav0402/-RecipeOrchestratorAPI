package com.example.recipeapi.service;

import com.example.recipeapi.dto.ExternalRecipeResponse;
import com.example.recipeapi.exception.ExternalApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class ExternalApiService {

    private final RestTemplate restTemplate;

    @Value("${external.api.recipes.url}")
    private String recipesApiUrl;

    public ExternalApiService() {
        this.restTemplate = new RestTemplate();
    }

    @Retryable(
            retryFor = {RestClientException.class, ExternalApiException.class},
            maxAttempts = 3,
            backoff = @Backoff(delay = 1000, multiplier = 2)
    )
    public ExternalRecipeResponse fetchRecipes() {
        try {
            log.info("Fetching recipes from external API: {}", recipesApiUrl);
            ExternalRecipeResponse response = restTemplate.getForObject(recipesApiUrl, ExternalRecipeResponse.class);

            if (response == null || response.getRecipes() == null) {
                throw new ExternalApiException("Invalid response from external API");
            }

            log.info("Successfully fetched {} recipes from external API", response.getRecipes().size());
            return response;
        } catch (RestClientException e) {
            log.error("Error fetching recipes from external API", e);
            throw new ExternalApiException("Failed to fetch recipes from external API", e);
        }
    }
}