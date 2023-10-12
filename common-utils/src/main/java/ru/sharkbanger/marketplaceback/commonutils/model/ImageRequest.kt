package ru.sharkbanger.marketplaceback.commonutils.model

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Positive

data class NewImageRequest(
    @field:NotBlank
    val title: String,
    @field:NotEmpty
    val content: ByteArray,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is NewImageRequest) return false

        if (title != other.title) return false
        if (!content.contentEquals(other.content)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = title.hashCode()
        result = 31 * result + content.contentHashCode()
        return result
    }
}

data class UpdateImageRequest(
    @field:Positive
    val id: Long,
    val title: String?,
    val content: ByteArray?,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is UpdateImageRequest) return false

        if (id != other.id) return false
        if (title != other.title) return false
        if (content != null) {
            if (other.content == null) return false
            if (!content.contentEquals(other.content)) return false
        } else if (other.content != null) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + (title?.hashCode() ?: 0)
        result = 31 * result + (content?.contentHashCode() ?: 0)
        return result
    }
}