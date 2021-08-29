package pl.machnikovsky.kotlinbackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import pl.machnikovsky.kotlinbackend.config.EsConfig

@SpringBootApplication
@ConfigurationPropertiesScan
class KotlinBackendApplication

fun main(args: Array<String>) {
    runApplication<KotlinBackendApplication>(*args)
}
