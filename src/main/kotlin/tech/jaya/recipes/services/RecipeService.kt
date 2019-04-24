package tech.jaya.recipes.services

import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import tech.jaya.recipes.controllers.request.RecipeRequest
import tech.jaya.recipes.controllers.request.RecipeResponse

interface RecipeService {

    fun createRecipe(recipeRequest: RecipeRequest): Mono<RecipeResponse>

    fun findAllRecipes(): Flux<RecipeResponse>

    fun updateRecipe(id: String, recipeRequest: RecipeRequest): Mono<RecipeResponse>

    fun findRecipeById(id: String): Mono<RecipeResponse>

    fun deleteRecipeById(id: String) : Mono<Void>
}