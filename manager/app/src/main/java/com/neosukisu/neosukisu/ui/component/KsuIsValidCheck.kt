package com.neosukisu.neosukisu.ui.component

import androidx.compose.runtime.Composable
import com.neosukisu.neosukisu.domain.model.KernelStatus

@Composable
inline fun KsuIsValid(
    status: KernelStatus,
    content: @Composable () -> Unit
) {
    if (status.isFullFeatured)
        content()
}
