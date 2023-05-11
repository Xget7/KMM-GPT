package xget.mc.mypartner.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class GptChatCompletionResponse(
    @SerialName("id") val id: String,
    @SerialName("object") val objectName: String,
    @SerialName("created") val created: Long,
    @SerialName("choices") val choices: List<Choice>,
    @SerialName("usage") val usage: Usage
)

@Serializable
data class Choice(
    @SerialName("index") val index: Int,
    @SerialName("message") val messageDto: MessageDto,
    @SerialName("finish_reason") val finishReason: String
)

@Serializable
data class Usage(
    @SerialName("prompt_tokens") val promptTokens: Int,
    @SerialName("completion_tokens") val completionTokens: Int,
    @SerialName("total_tokens") val totalTokens: Int
)