package xget.mc.mypartner

expect class DebugLogger (tagString : String) {
    val tag : String
    fun log(message: String)
}