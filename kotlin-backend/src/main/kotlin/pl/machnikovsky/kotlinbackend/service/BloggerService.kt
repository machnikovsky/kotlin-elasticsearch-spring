package pl.machnikovsky.kotlinbackend.service

import org.elasticsearch.index.query.QueryBuilders
import org.elasticsearch.index.query.WildcardQueryBuilder
import org.springframework.data.elasticsearch.core.ElasticsearchOperations
import org.springframework.data.elasticsearch.core.SearchHits
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder
import org.springframework.data.elasticsearch.core.query.Query
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import pl.machnikovsky.kotlinbackend.model.Blogger
import pl.machnikovsky.kotlinbackend.repository.BloggerRepository


@Service
class BloggerService(val bloggerRepository: BloggerRepository, val elasticsearchOperations: ElasticsearchOperations) {

    private val bloggerIndex: String = "blogger"

    fun getAllBloggers(): List<Blogger> = bloggerRepository.findAll().toList()
    fun getBloggerById(id: String): Blogger? = bloggerRepository.findByIdOrNull(id)
    fun addNewBlogger(blogger: Blogger): Blogger = bloggerRepository.save(blogger)

    fun findByWildCard(firstName: String): List<Blogger> {
        val queryBuilder = QueryBuilders
            .boolQuery()
            .should(WildcardQueryBuilder("firstName", "*$firstName*"))

        val searchQuery: Query = NativeSearchQueryBuilder()
            .withFilter(queryBuilder)
            .build()

        val hits: SearchHits<Blogger> = elasticsearchOperations
            .search(
                searchQuery, Blogger::class.java,
                IndexCoordinates.of(bloggerIndex)
            )

        return hits.map { it.content }.toList()
    }

}