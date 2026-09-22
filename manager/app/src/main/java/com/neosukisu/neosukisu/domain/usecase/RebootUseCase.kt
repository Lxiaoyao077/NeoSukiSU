package com.neosukisu.neosukisu.domain.usecase

import com.neosukisu.neosukisu.data.application.ApplicationControlRepository

class RebootUseCase(
    private val repository: ApplicationControlRepository,
) {
    suspend operator fun invoke(reason: String = "") = repository.reboot(reason)
}
