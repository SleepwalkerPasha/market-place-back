package ru.sharpbang.marketplaceback.baggins.model.response

data class ImageResponse(
    val id: Long,
    val title: String,
    val content: ByteArray
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ImageResponse) return false

        if (id != other.id) return false
        if (title != other.title) return false
        if (!content.contentEquals(other.content)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + title.hashCode()
        result = 31 * result + content.contentHashCode()
        return result
    }
}

