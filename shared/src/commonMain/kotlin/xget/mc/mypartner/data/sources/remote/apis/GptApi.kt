package xget.mc.mypartner.data.sources.remote.apis

import kotlinx.coroutines.delay
import xget.mc.mypartner.data.model.Choice
import xget.mc.mypartner.data.model.GptChatCompletionResponse
import xget.mc.mypartner.data.model.GptRequest
import xget.mc.mypartner.data.model.MessageDto
import xget.mc.mypartner.data.model.Usage
import xget.mc.mypartner.data.sources.remote.ApiClient
import xget.mc.mypartner.data.utils.Endpoints.CHAT_COMPLETIONS

class GptApi(private val client: ApiClient) {


    suspend fun chatCompletion(request: GptRequest): GptChatCompletionResponse? {

        return client.postResponse(CHAT_COMPLETIONS, request)

        //MOCK
//        delay(2000)
//        return GptChatCompletionResponse(
//            id = "678678",
//            objectName = "",
//            created = 123L,
//            usage = Usage(4342, 3232, 23),
//            choices = listOf(
//                Choice(
//                    1,
//                    MessageDto(
//                        "GPT",
//                        "This is a GPT response for you message , wow , a real response "
//                    ),
//                    "finish"
//                )
//            )
//        )
    }

}