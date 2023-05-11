package xget.mc.mypartner

import android.util.Log

actual class DebugLogger actual constructor(tagString: String) {
    actual val tag = tagString
    actual fun log(message: String) {
        Log.d(tag, message)
    }
}