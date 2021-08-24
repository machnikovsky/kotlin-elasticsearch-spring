package pl.machnikovsky.kotlinbackend.controller

import org.springframework.web.bind.annotation.*
import pl.machnikovsky.kotlinbackend.model.Blogger
import pl.machnikovsky.kotlinbackend.model.BloggerDTO
import pl.machnikovsky.kotlinbackend.service.BloggerService

@RestController
@RequestMapping("/blogger")
@CrossOrigin
class BloggerController(val bloggerService: BloggerService) {

    @GetMapping("/all")
    fun getAllBloggers(): List<Blogger> = bloggerService.getAllBloggers()

    @GetMapping("/match/{firstName}")
    fun getAllBloggers(@PathVariable("firstName") firstName: String): List<Blogger> =
        bloggerService.findByWildCard(firstName)

    @GetMapping("/{id}")
    fun getBloggerById(@PathVariable("id") id: String) = bloggerService.getBloggerById(id)

    @PostMapping
    fun addNewBlogger(@RequestBody newBlogger: BloggerDTO) = bloggerService.addNewBlogger(newBlogger)
}