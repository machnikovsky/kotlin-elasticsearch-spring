package pl.machnikovsky.kotlinbackend.model

import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document

@Document(indexName = "blogger")
data class Blogger(@Id val bloggerId: String,
                   var firstName: String,
                   var lastName: String,
                   var email: String?)


data class BloggerDTO(val firstName: String, val lastName: String, val email: String?)
