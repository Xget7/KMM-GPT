package xget.mc.mypartner.data.sources.remote

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.plugins.timeout
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.withTimeout
import kotlinx.serialization.json.Json
import xget.mc.mypartner.DebugLogger

class ApiClient {

    val baseUrl = "https://api.openai.com/v1/"
    val apiKey = ""

    val debugLogger = DebugLogger("KTOR")

    val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })

        }


        ///Ktor specific logging: reenable if needed to debug requests
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.INFO
        }
        request {
           timeout {
               requestTimeoutMillis = Long.MAX_VALUE
           }
        }


    }


    suspend inline fun <reified T : Any> getResponse(endpoint: String): T? {
        val url = baseUrl + endpoint
        try {
            // please notice, Ktor Client is switching to a background thread under the hood
            // so the http call doesn't happen on the main thread, even if the coroutine has been launched on Dispatchers.Main
            val resp = client.get(url).body<T>()
            debugLogger.log("$url API SUCCESS")
            return resp
        } catch (e: Exception) {
            debugLogger.log("$url API FAILED: " + e.message)
        }
        return null
    }

    suspend inline fun <reified T : Any> postResponse(endpoint: String, body: Any): T? {
        val url = baseUrl + endpoint
        debugLogger.log("$url API URL TO SEND")

        try {
            // please notice, Ktor Client is switching to a background thread under the hood
            // so the http call doesn't happen on the main thread, even if the coroutine has been launched on Dispatchers.Main
            val resp = client.post(url) {
                contentType(ContentType.Application.Json)
                headers{
                    append(
                        HttpHeaders.Authorization, "Bearer $apiKey"
                    )
                }
                setBody(body)
            }.body<T>()
            debugLogger.log("$url API SUCCESS")
            return resp
        } catch (e: Exception) {
            debugLogger.log("$url API FAILED: " + e.message)
        }
        return null
    }


}