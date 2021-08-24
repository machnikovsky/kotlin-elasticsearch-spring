package pl.machnikovsky.kotlinbackend.mapper

interface Mapper <D, E> {
    fun fromEntity(entity: E): D
    fun fromDTO(dto: D): E
}