package xget.mc.mypartner.data.sources.remote.functions

import xget.mc.mypartner.Utils.GPT_MODEL
import xget.mc.mypartner.data.model.GptRequest
import xget.mc.mypartner.data.model.MessageDto
import xget.mc.mypartner.repositories.GptRepository

suspend fun GptRepository.sendTextForCompletion(message: String) = withRepoContext {

    //NO LARGE CONTEXT FOR GPT
    messageDtos.add(
        MessageDto(
            "user",
            message
        )
    )

    val request = GptRequest(
        model = GPT_MODEL,
        messageDtos = messageDtos.toList()
    )
    gptApi.chatCompletion(request)
}
