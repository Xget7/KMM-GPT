package xget.mc.mypartner

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform