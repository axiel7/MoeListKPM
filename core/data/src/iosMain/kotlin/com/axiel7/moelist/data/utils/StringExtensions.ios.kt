package com.axiel7.moelist.data.utils

import kotlinx.cinterop.BetaInteropApi
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.addressOf
import kotlinx.cinterop.usePinned
import platform.Foundation.*
import platform.UIKit.*

actual fun String.format(format: String, vararg args: Any?): String {
    // Note: NSString.stringWithFormat in Kotlin can be tricky with varargs.
    // This is a basic bridge; for complex formatting might need a different approach.
    return NSString.stringWithFormat(this, *args)
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