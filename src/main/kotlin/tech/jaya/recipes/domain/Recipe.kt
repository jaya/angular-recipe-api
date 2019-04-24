package tech.jaya.recipes.domain

import tech.jaya.recipes.controllers.request.RecipeRequest
import tech.jaya.recipes.controllers.request.RecipeResponse

data class Recipe(
        val id: String? = null,
        val name: String,
        val description: String,
        val image: String
)

