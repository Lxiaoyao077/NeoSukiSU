package com.neosukisu.neosukisu.domain.usecase

import com.neosukisu.neosukisu.data.startup.StartupRepository

class ObserveStartupStateUseCase(
    private val repository: StartupRepository,
) {
    operator fun invoke() = repository.state
}
