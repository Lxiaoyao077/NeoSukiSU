package com.neosukisu.neosukisu.domain.usecase

import com.neosukisu.neosukisu.data.susfs.SuSFSRepository

class GetSuSFSStatusUseCase(private val repository: SuSFSRepository) {
    suspend operator fun invoke() = repository.getStatus()
}

