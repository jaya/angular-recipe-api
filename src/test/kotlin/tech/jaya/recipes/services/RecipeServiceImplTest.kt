package tech.jaya.recipes.services

import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import junit.framework.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import tech.jaya.recipes.controllers.request.RecipeRequest

@SpringBootTest
@RunWith(SpringRunner::class)
@AutoConfigureDataMongo
class RecipeServiceImplTest {

    @Autowired
    private lateinit var recipeService: RecipeService

    @Test
    fun createRecipe() {
        val recipe = this.recipeService.createRecipe(RecipeRequest(name = "test", image = "aaa", description = "test-description"))
        assertNotNull(recipe)
        recipe.block()?.also {
            this.recipeService.findRecipeById(it.id)
        }
    }

    @Test
    fun findAllRecipes() {
        this.recipeService.createRecipe(RecipeRequest(name = "test", image = "aaa", description = "test-description"))
        assertTrue(this.recipeService.findAllRecipes().count().block()!! >   0 )
    }

    @Test
    fun updateRecipe() {
        val response = this.recipeService.createRecipe(
                RecipeRequest(name = "test", image = "aaa", description = "test-description")).block()

        val updateRecipe = this.recipeService.updateRecipe(response!!.id,
                RecipeRequest(name = "aaa", description = "aaa", image = "aaa")).block()


        val result = this.recipeService.findRecipeById(response.id).block()

        assertEquals("aaa",result!!.name)
        assertEquals("aaa",result!!.description)
    }

}