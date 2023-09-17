package ru.sharpbang.marketplaceback.restservice.model.request

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class ImageRequest(
    @field:NotBlank
    val title: String,
    @field:NotNull
    val content: ByteArray
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ImageRequest

        if (title != other.title) return false
        return content.contentEquals(other.content)
    }

    override fun hashCode(): Int {
        var result = title.hashCode()
        result = 31 * result + content.contentHashCode()
        return result
    }
}
