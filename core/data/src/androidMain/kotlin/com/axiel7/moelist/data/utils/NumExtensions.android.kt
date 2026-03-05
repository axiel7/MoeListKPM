package com.axiel7.moelist.data.utils

import java.text.NumberFormat

actual fun formatNumber(number: Number): String? {
    return runCatching {  NumberFormat.getInstance().format(number) }.getOrNull()
}