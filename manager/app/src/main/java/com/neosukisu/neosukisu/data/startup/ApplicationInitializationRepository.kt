package com.neosukisu.neosukisu.data.startup

import android.annotation.SuppressLint
import android.app.Application
import android.system.Os
import coil.Coil
import coil.ImageLoader
import com.neosukisu.neosukisu.data.flash.FlashRepository
import com.neosukisu.neosukisu.data.shell.KsuCliRepository
import com.neosukisu.neosukisu.data.theme.MonetCompatColorSource
import com.topjohnwu.superuser.internal.MainShell
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.io.File

class ApplicationInitializationRepository(
    private val application: Application,
    private val imageLoader: ImageLoader,
    private val applicationScope: CoroutineScope,
    private val flashRepository: FlashRepository,
    private val ksuCliRepository: KsuCliRepository,
    private val monetCompatColorSource: MonetCompatColorSource,
) {
    @SuppressLint("RestrictedApi")
    suspend fun initialize() {
        MainShell.setBuilder(ksuCliRepository.generateMainShellBuilder())
        monetCompatColorSource.initialize()
        Coil.setImageLoader(imageLoader)
        File(application.dataDir, "webroot").mkdirs()
        Os.setenv("TMPDIR", application.cacheDir.absolutePath, true)
        applicationScope.launch {
            runCatching { flashRepository.getInstallEnvironment() }
        }
    }
}
