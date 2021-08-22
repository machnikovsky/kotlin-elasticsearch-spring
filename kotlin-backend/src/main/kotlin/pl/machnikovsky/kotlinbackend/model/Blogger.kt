package pl.machnikovsky.kotlinbackend.model

import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document

@Document(indexName = "blogger")
data class Blogger(@Id val bloggerId: String, val firstName: String, val lastName: String)

