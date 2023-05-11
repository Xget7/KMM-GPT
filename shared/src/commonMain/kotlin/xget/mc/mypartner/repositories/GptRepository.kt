package xget.mc.mypartner.repositories

import com.russhwolf.settings.Settings
import com.squareup.sqldelight.db.SqlDriver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import xget.mc.mypartner.data.model.MessageDto
import xget.mc.mypartner.data.sources.MySettings
import xget.mc.mypartner.data.sources.remote.ApiClient
import xget.mc.mypartner.data.sources.remote.apis.GptApi
import xget.mc.mypartner.db.LocalDb

class GptRepository(
    private val useDefaultDispatcher: Boolean = true,
    private val settings: Settings = Settings(),
    val sqlDriver: SqlDriver
) {
    val messageDtos = mutableListOf<MessageDto>()

    private val webservices by lazy { ApiClient() }

    internal val gptApi by lazy { GptApi(webservices) }


    internal val localDb by lazy { LocalDb(sqlDriver) }
    internal val localSettings by lazy { MySettings(settings) }
//    internal val runtimeCache get() = CacheObjects

    // we run each repository function on a Dispatchers.Default coroutine
    // we pass useDefaultDispatcher=false just for the TestRepository instance
    suspend fun <T> withRepoContext(block: suspend () -> T): T {
        return if (useDefaultDispatcher) {
            withContext(Dispatchers.Default) {
                block()
            }
        } else {
            block()
        }
    }
}