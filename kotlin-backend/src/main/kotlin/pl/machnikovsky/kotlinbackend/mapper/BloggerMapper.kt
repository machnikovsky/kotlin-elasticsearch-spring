package pl.machnikovsky.kotlinbackend.mapper

import org.elasticsearch.common.UUIDs
import org.springframework.stereotype.Component
import pl.machnikovsky.kotlinbackend.model.Blogger
import pl.machnikovsky.kotlinbackend.model.BloggerDTO

@Component
class BloggerMapper: Mapper<BloggerDTO, Blogger> {

    override fun fromDTO(dto: BloggerDTO): Blogger =
        Blogger(UUIDs.randomBase64UUID(),
                dto.firstName,
                dto.lastName,
                dto.email)

    override fun fromEntity(entity: Blogger): BloggerDTO =
        BloggerDTO(entity.firstName,
                    entity.lastName,
                    entity.email)
}