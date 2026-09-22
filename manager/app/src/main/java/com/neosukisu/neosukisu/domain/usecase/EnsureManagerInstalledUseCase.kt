package com.neosukisu.neosukisu.domain.usecase

import com.neosukisu.neosukisu.data.application.ApplicationControlRepository

class EnsureManagerInstalledUseCase(
    private val repository: ApplicationControlRepository,
) {
    suspend operator fun invoke(): Result<Unit> = repository.ensureManagerInstalled()
}

