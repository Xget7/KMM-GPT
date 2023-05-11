package xget.mc.mypartner.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GptRequest(
    @SerialName("model") val model: String,
    @SerialName("messages") val messageDtos: List<MessageDto>
)

@Serializable
data class MessageDto(
    @SerialName("role") val role: String,
    @SerialName("content") val content: String
)