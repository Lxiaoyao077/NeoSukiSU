package com.neosukisu.neosukisu.domain.usecase

import com.neosukisu.neosukisu.data.file.ModuleFileRepository

class IsModuleUriAccessibleUseCase(private val repository: ModuleFileRepository) {
    operator fun invoke(uri: String) = repository.isUriAccessible(uri)
}

class TakeModuleUriPermissionUseCase(private val repository: ModuleFileRepository) {
    operator fun invoke(uri: String) = repository.takePersistableUriPermission(uri)
}

class ExtractModuleNameUseCase(private val repository: ModuleFileRepository) {
    operator fun invoke(uri: String) = repository.extractModuleName(uri)
}

class ExtractModuleIdUseCase(private val repository: ModuleFileRepository) {
    operator fun invoke(uri: String) = repository.extractModuleId(uri)
}
