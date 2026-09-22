package com.neosukisu.neosukisu.domain.usecase

import com.neosukisu.neosukisu.data.logging.BugreportRepository
import java.io.File

class GenerateBugreportUseCase(
    private val repository: BugreportRepository,
) {
    operator fun invoke(): File = repository.create()
}
