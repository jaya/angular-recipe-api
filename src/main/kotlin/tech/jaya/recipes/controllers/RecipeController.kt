package tech.jaya.recipes.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.HttpStatus.NO_CONTENT
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import tech.jaya.recipes.controllers.request.RecipeRequest
import tech.jaya.recipes.services.RecipeService
import java.time.Duration

@RestController
@RequestMapping("/recipes")
@CrossOrigin(origins = ["http://localhost:4200"])
class RecipeController(@Autowired private val recipeService: RecipeService) {


    @GetMapping(value = ["", "/"])
    fun getRecipes() = recipeService.findAllRecipes().delayElements(Duration.ofMillis(DELAY_PER_ITEM_MS))

    @ResponseStatus(CREATED)
    @PostMapping(value = ["", "/"])
    fun createRecipe(@RequestBody recipeRequest: RecipeRequest) = recipeService.createRecipe(recipeRequest)

    @PutMapping(value = "/{id}")
    fun updateRecipe(@PathVariable id: String,
                     @RequestBody recipeRequest: RecipeRequest) = recipeService.updateRecipe(id, recipeRequest)

    @GetMapping(value = "/{id}")
    fun getRecipeById(@PathVariable id: String) = recipeService.findRecipeById(id)

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping(value = "/{id}")
    fun removeByID(@PathVariable id: String) = recipeService.deleteRecipeById(id)

    companion object {
        const val DELAY_PER_ITEM_MS = 10000L
    }
}