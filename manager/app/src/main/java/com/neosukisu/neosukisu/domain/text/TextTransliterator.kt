package com.neosukisu.neosukisu.domain.text

fun interface TextTransliterator {
    fun transliterate(value: String): String
}
