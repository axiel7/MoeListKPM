package com.axiel7.moelist.data.utils

import kotlinx.cinterop.BetaInteropApi
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.addressOf
import kotlinx.cinterop.usePinned
import platform.Foundation.*
import platform.UIKit.*

actual fun String.format(format: String, vararg args: Any?): String {
    val iosFormat = this.replace("%s", "%@")
    return when (args.size) {
        0 -> iosFormat
        1 -> NSString.stringWithFormat(iosFormat, args[0])
        2 -> NSString.stringWithFormat(iosFormat, args[0], args[1])
        3 -> NSString.stringWithFormat(iosFormat, args[0], args[1], args[2])
        4 -> NSString.stringWithFormat(iosFormat, args[0], args[1], args[2], args[3])
        5 -> NSString.stringWithFormat(iosFormat, args[0], args[1], args[2], args[3], args[4])
        6 -> NSString.stringWithFormat(iosFormat, args[0], args[1], args[2], args[3], args[4], args[5])
        7 -> NSString.stringWithFormat(iosFormat, args[0], args[1], args[2], args[3], args[4], args[5], args[6])
        8 -> NSString.stringWithFormat(iosFormat, args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7])
        else -> iosFormat
    }
}

@OptIn(ExperimentalForeignApi::class, BetaInteropApi::class)
actual fun String.unescapeHtml(): String? {
    val bytes = this.encodeToByteArray()

    // Create NSData from ByteArray manually
    val data = bytes.usePinned { pinned ->
        NSData.dataWithBytes(
            bytes = pinned.addressOf(0),
            length = bytes.size.toULong()
        )
    }
    return NSAttributedString.create(
        data = data,
        options = mapOf(NSDocumentTypeDocumentAttribute to NSHTMLTextDocumentType),
        documentAttributes = null,
        error = null
    )?.string
}