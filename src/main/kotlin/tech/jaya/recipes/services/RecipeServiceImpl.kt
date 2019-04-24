package tech.jaya.recipes.services

import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import tech.jaya.recipes.controllers.request.RecipeRequest
import tech.jaya.recipes.controllers.request.RecipeResponse
import tech.jaya.recipes.controllers.request.toDomain
import tech.jaya.recipes.controllers.request.toResponse
import tech.jaya.recipes.repositories.RecipeRepository

@Service
class RecipeServiceImpl(private val recipeRepository: RecipeRepository) : RecipeService {
    override fun deleteRecipeById(id: String): Mono<Void> = recipeRepository.deleteById(id)

    override fun createRecipe(recipeRequest: RecipeRequest): Mono<RecipeResponse> =
            recipeRepository.save(recipeRequest.toDomain()).map { it.toResponse() }


    override fun findAllRecipes(): Flux<RecipeResponse> = recipeRepository.findAll().map { it.toResponse() }

    override fun updateRecipe(id: String, recipeRequest: RecipeRequest): Mono<RecipeResponse> {
        recipeRepository.findById(id).block()?.also { recipe ->
            return recipeRepository.save(recipeRequest.toDomain().copy(id = recipe.id)).map { it.toResponse() }
        }
        return recipeRepository.save(recipeRequest.toDomain()).map { it.toResponse() }
    }

    override fun findRecipeById(id: String): Mono<RecipeResponse> = recipeRepository.findById(id).map { it.toResponse() }
}