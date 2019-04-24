package tech.jaya.recipes.controllers.request

import tech.jaya.recipes.domain.Recipe

data class RecipeRequest(
        val name: String,
        val description: String,
        val image: String
)

fun RecipeRequest.toDomain() =
        Recipe(name = this.name, description = this.description, image = this.image)
