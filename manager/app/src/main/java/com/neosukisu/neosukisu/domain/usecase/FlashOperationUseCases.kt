package com.neosukisu.neosukisu.domain.usecase

import com.neosukisu.neosukisu.data.flash.FlashRepository
import com.neosukisu.neosukisu.domain.model.FlashOperation

class ExecuteFlashOperationUseCase(private val repository: FlashRepository) {
    operator fun invoke(operation: FlashOperation) = repository.execute(operation)
}
