package com.neosukisu.neosukisu.domain.usecase

import com.neosukisu.neosukisu.data.update.ManagerUpdateRepository
import com.neosukisu.neosukisu.domain.model.ManagerUpdateChannel
import com.neosukisu.neosukisu.domain.model.ManagerUpdateInfo

class CheckManagerUpdateUseCase(
    private val repository: ManagerUpdateRepository,
) {
    suspend operator fun invoke(channel: ManagerUpdateChannel): ManagerUpdateInfo? =
        when (channel) {
            ManagerUpdateChannel.STABLE -> repository.checkStableUpdate()
            ManagerUpdateChannel.BETA -> repository.checkBetaUpdate()
        }
}
