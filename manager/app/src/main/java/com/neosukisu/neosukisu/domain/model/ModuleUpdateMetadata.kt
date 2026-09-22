package com.neosukisu.neosukisu.domain.model

data class ModuleUpdateMetadata(
    val zipUrl: String,
    val version: String,
    val changelog: String,
)
