package com.neosukisu.neosukisu.domain.usecase

import com.neosukisu.neosukisu.data.module.ModuleActionRepository

class ExecuteModuleActionUseCase(
    private val repository: ModuleActionRepository,
) {
    operator fun invoke(moduleId: String) = repository.execute(moduleId)
}

class SaveModuleActionLogUseCase(
    private val repository: ModuleActionRepository,
) {
    suspend operator fun invoke(content: String) = repository.saveLog(content)
}
