package com.neosukisu.neosukisu.domain.usecase

import com.neosukisu.neosukisu.data.AppSettingsRepository
import com.neosukisu.neosukisu.data.startup.ApplicationInitializationRepository
import com.neosukisu.neosukisu.data.startup.StartupRepository

class InitializeApplicationUseCase(
    private val settingsRepository: AppSettingsRepository,
    private val startupRepository: StartupRepository,
    private val initializationRepository: ApplicationInitializationRepository,
) {
    suspend operator fun invoke() {
        runCatching {
            settingsRepository.preload()
            initializationRepository.initialize()
        }.onSuccess {
            startupRepository.markReady()
        }.onFailure { error ->
            startupRepository.markFailed(error)
        }
    }
}
