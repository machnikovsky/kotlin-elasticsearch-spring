package pl.machnikovsky.kotlinbackend.model

import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document

@Document(indexName = "blogger")
class Blogger(val firstName: String, val lastName: String) {
    @Id
    val bloggerId: String = ""
}

