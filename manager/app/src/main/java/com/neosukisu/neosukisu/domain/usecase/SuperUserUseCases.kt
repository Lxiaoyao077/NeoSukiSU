package com.neosukisu.neosukisu.domain.usecase

import com.neosukisu.neosukisu.data.packageinfo.SuperUserRepository

class ObserveSuperUserStateUseCase(private val repository: SuperUserRepository) {
    operator fun invoke() = repository.state
}

class RefreshSuperUsersUseCase(private val repository: SuperUserRepository) {
    suspend operator fun invoke() = repository.refresh()
}

class BackupAllowlistUseCase(private val repository: SuperUserRepository) {
    suspend operator fun invoke(uri: String) = repository.backupAllowlist(uri)
}

class ImportAllowlistUseCase(private val repository: SuperUserRepository) {
    suspend operator fun invoke(uri: String) = repository.restoreAllowlist(uri)
}
