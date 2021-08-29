package pl.machnikovsky.kotlinbackend.config

import org.elasticsearch.client.RestHighLevelClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.elasticsearch.client.ClientConfiguration
import org.springframework.data.elasticsearch.client.RestClients
import org.springframework.data.elasticsearch.core.ElasticsearchOperations
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories

@Configuration
@EnableElasticsearchRepositories(basePackages = ["pl.machnikovsky.kotlinbackend.repository"])
@ComponentScan(basePackages = ["pl.machnikovsky.kotlinbackend"])
class EsConfig(@Value("\${elastic.hostname}") val hostname: String,
               @Value("\${elastic.port}") val  port: String) {

    @Bean
    fun client(): RestHighLevelClient {
        val clientConfiguration: ClientConfiguration = ClientConfiguration
            .builder()
            .connectedTo("$hostname:$port")
            .build()

        return RestClients.create(clientConfiguration).rest()
    }

    @Bean
    fun elasticsearchTemplate(): ElasticsearchOperations = ElasticsearchRestTemplate(client())

}
