package com.neosukisu.neosukisu.domain.usecase

import com.neosukisu.neosukisu.data.packageinfo.SuperUserRepository

class GetSuperUserAppGroupUseCase(private val repository: SuperUserRepository) {
    suspend operator fun invoke(uid: Int, primaryPackageName: String) =
        repository.getAppGroup(uid, primaryPackageName)
}
