package com.neosukisu.neosukisu.domain.usecase

import com.neosukisu.neosukisu.data.flash.FlashRepository

class CheckFlashModuleMountUseCase(private val repository: FlashRepository) {
    suspend operator fun invoke(uri: String) = repository.moduleNeedsMount(uri)
}
