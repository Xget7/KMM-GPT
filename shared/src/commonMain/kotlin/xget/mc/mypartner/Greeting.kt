package xget.mc.mypartner

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}

object Utils {
    const val GPT_MODEL = "gpt-3.5-turbo"
}