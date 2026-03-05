package com.axiel7.moelist.data.utils

import org.apache.commons.text.StringEscapeUtils

actual fun String.format(format: String, vararg args: Any?): String {
    return this.format(*args)
}

actual fun String.unescapeHtml(): String? {
    return StringEscapeUtils.unescapeHtml4(this)
}