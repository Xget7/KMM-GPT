package xget.mc.mypartner.data.sources.local.chat

import xget.mc.mypartner.db.LocalDb
import xgetmcmypartner.db.Message

fun LocalDb.insertMessage(msg: Message) {
    localDbQueries.insertMessage(
        author = msg.author,
        message = msg.message,
        date = msg.date,
        id = null
    )
}

fun LocalDb.deleteLoadingMessage() {
    localDbQueries.deleteLoadingMessage(
        "-LOADING-LOADING"
    )
}


fun LocalDb.getAllMessages(): List<Message> {
    return localDbQueries.getMessagesList().executeAsList()
}





