package pl.machnikovsky.kotlinbackend.repository

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository
import pl.machnikovsky.kotlinbackend.model.Blogger

interface BloggerRepository : ElasticsearchRepository<Blogger, String>