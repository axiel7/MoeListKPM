package com.axiel7.moelist

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform