package tech.jaya.recipes.controllers.request

import tech.jaya.recipes.domain.Recipe

data class RecipeResponse(
        val id: String,
        val name: String,
        val description: String,
        val image: String
)

fun Recipe.toResponse() =
        RecipeResponse(id = this.id!!, name = this.name, description = this.description, image = this.image)
