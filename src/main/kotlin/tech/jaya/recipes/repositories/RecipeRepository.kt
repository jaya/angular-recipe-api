package tech.jaya.recipes.repositories

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import tech.jaya.recipes.domain.Recipe

@Repository
interface RecipeRepository : ReactiveMongoRepository<Recipe, String>