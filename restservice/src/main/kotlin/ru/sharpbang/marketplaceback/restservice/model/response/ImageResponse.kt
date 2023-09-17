package ru.sharpbang.marketplaceback.restservice.model.response

data class ImageResponse (
    val title: String,
    val content: ByteArray
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ImageResponse

        if (title != other.title) return false
        return content.contentEquals(other.content)
    }

    override fun hashCode(): Int {
        var result = title.hashCode()
        result = 31 * result + content.contentHashCode()
        return result
    }
}