package com.neosukisu.neosukisu.domain.usecase

import com.neosukisu.neosukisu.domain.text.TextTransliterator

class TransliterateTextUseCase(private val transliterator: TextTransliterator) {
    operator fun invoke(value: String): String = transliterator.transliterate(value)
}
