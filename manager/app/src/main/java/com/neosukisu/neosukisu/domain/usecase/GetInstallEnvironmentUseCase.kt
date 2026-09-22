package com.neosukisu.neosukisu.domain.usecase

import com.neosukisu.neosukisu.data.flash.FlashRepository
import com.neosukisu.neosukisu.domain.model.InstallEnvironment

class GetInstallEnvironmentUseCase(
    private val repository: FlashRepository,
) {
    fun cached(): InstallEnvironment? = repository.installEnvironment.value

    suspend operator fun invoke(forceRefresh: Boolean = false) =
        repository.getInstallEnvironment(forceRefresh)
}
