package com.neosukisu.neosukisu.data.logging

import android.app.Application
import com.neosukisu.neosukisu.data.shell.KsuCliRepository
import java.io.File

class BugreportRepository(
    private val application: Application,
    private val ksuCliRepository: KsuCliRepository,
) {
    fun create(): File = getBugreportFile(application, ksuCliRepository)
}
