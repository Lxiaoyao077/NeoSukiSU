package com.neosukisu.neosukisu.di

import coil.ImageLoader
import com.neosukisu.neosukisu.BuildConfig
import com.neosukisu.neosukisu.data.AppSettingsRepository
import com.neosukisu.neosukisu.data.application.ApplicationControlRepository
import com.neosukisu.neosukisu.data.application.DynamicManagerRepository
import com.neosukisu.neosukisu.data.download.DownloadRepository
import com.neosukisu.neosukisu.data.file.ModuleFileRepository
import com.neosukisu.neosukisu.data.flash.FlashRepository
import com.neosukisu.neosukisu.data.kernel.KernelRepository
import com.neosukisu.neosukisu.data.kernel.UmountRepository
import com.neosukisu.neosukisu.data.logging.BugreportRepository
import com.neosukisu.neosukisu.data.logging.SulogRepository
import com.neosukisu.neosukisu.data.module.ModuleActionRepository
import com.neosukisu.neosukisu.data.module.ModuleCatalogRepository
import com.neosukisu.neosukisu.data.module.ModulePreferencesRepository
import com.neosukisu.neosukisu.data.module.ModuleRepository
import com.neosukisu.neosukisu.data.network.NetworkRequestRepository
import com.neosukisu.neosukisu.data.network.NetworkStatusRepository
import com.neosukisu.neosukisu.data.network.WebResourceRepository
import com.neosukisu.neosukisu.data.packageinfo.AppIconDataSource
import com.neosukisu.neosukisu.data.packageinfo.InstalledPackageCache
import com.neosukisu.neosukisu.data.packageinfo.InstalledPackageRepository
import com.neosukisu.neosukisu.data.packageinfo.RootServiceRepository
import com.neosukisu.neosukisu.data.packageinfo.SuperUserRepository
import com.neosukisu.neosukisu.data.profile.ProfileRepository
import com.neosukisu.neosukisu.data.profile.ProfileTemplateRepository
import com.neosukisu.neosukisu.data.settings.LocaleHelper
import com.neosukisu.neosukisu.data.settings.LocaleRepository
import com.neosukisu.neosukisu.data.settings.SettingsPlatformRepository
import com.neosukisu.neosukisu.data.shell.KsuCliRepository
import com.neosukisu.neosukisu.data.shell.ShortcutRepository
import com.neosukisu.neosukisu.data.startup.ApplicationInitializationRepository
import com.neosukisu.neosukisu.data.startup.StartupRepository
import com.neosukisu.neosukisu.data.susfs.SuSFSConfigHelper
import com.neosukisu.neosukisu.data.susfs.SuSFSRepository
import com.neosukisu.neosukisu.data.system.HomeRuntimeRepository
import com.neosukisu.neosukisu.data.system.HomeStateRepository
import com.neosukisu.neosukisu.data.text.HanziToPinyin
import com.neosukisu.neosukisu.data.theme.MonetCompatColorSource
import com.neosukisu.neosukisu.data.theme.ThemeRepository
import com.neosukisu.neosukisu.data.update.ManagerUpdateRepository
import com.neosukisu.neosukisu.data.webui.WebUiRepository
import com.neosukisu.neosukisu.domain.text.TextTransliterator
import com.neosukisu.neosukisu.domain.usecase.AddUmountPathUseCase
import com.neosukisu.neosukisu.domain.usecase.ApplyLanguageUseCase
import com.neosukisu.neosukisu.domain.usecase.BackupAllowlistUseCase
import com.neosukisu.neosukisu.domain.usecase.CalculateInstalledModuleSizeUseCase
import com.neosukisu.neosukisu.domain.usecase.CheckFlashModuleMountUseCase
import com.neosukisu.neosukisu.domain.usecase.CheckManagerUpdateUseCase
import com.neosukisu.neosukisu.domain.usecase.CleanSulogUseCase
import com.neosukisu.neosukisu.domain.usecase.ClearDynamicManagerUseCase
import com.neosukisu.neosukisu.domain.usecase.ConfigureSuLogUseCase
import com.neosukisu.neosukisu.domain.usecase.ControlAppUseCase
import com.neosukisu.neosukisu.domain.usecase.DeleteProfileTemplateUseCase
import com.neosukisu.neosukisu.domain.usecase.EnableSulogUseCase
import com.neosukisu.neosukisu.domain.usecase.EnqueueDownloadUseCase
import com.neosukisu.neosukisu.domain.usecase.EnqueueManagerUpdateUseCase
import com.neosukisu.neosukisu.domain.usecase.EnsureManagerInstalledUseCase
import com.neosukisu.neosukisu.domain.usecase.ExecuteFlashOperationUseCase
import com.neosukisu.neosukisu.domain.usecase.ExecuteModuleActionUseCase
import com.neosukisu.neosukisu.domain.usecase.ExportProfileTemplatesUseCase
import com.neosukisu.neosukisu.domain.usecase.ExtractModuleIdUseCase
import com.neosukisu.neosukisu.domain.usecase.ExtractModuleNameUseCase
import com.neosukisu.neosukisu.domain.usecase.FetchRemoteTextUseCase
import com.neosukisu.neosukisu.domain.usecase.GenerateBugreportUseCase
import com.neosukisu.neosukisu.domain.usecase.GetAppProfileUseCase
import com.neosukisu.neosukisu.domain.usecase.GetAppSepolicyUseCase
import com.neosukisu.neosukisu.domain.usecase.GetBooleanPreferenceUseCase
import com.neosukisu.neosukisu.domain.usecase.GetCatalogModuleUseCase
import com.neosukisu.neosukisu.domain.usecase.GetDefaultUmountModulesUseCase
import com.neosukisu.neosukisu.domain.usecase.GetHomeBasicInfoUseCase
import com.neosukisu.neosukisu.domain.usecase.GetInstallEnvironmentUseCase
import com.neosukisu.neosukisu.domain.usecase.GetKernelFeatureSettingsUseCase
import com.neosukisu.neosukisu.domain.usecase.GetKernelStatusUseCase
import com.neosukisu.neosukisu.domain.usecase.GetManagerRuntimeInfoUseCase
import com.neosukisu.neosukisu.domain.usecase.GetPlatformFeatureStatusUseCase
import com.neosukisu.neosukisu.domain.usecase.GetProfileTemplateUseCase
import com.neosukisu.neosukisu.domain.usecase.GetStringPreferenceUseCase
import com.neosukisu.neosukisu.domain.usecase.GetStringSetPreferenceUseCase
import com.neosukisu.neosukisu.domain.usecase.GetSuSFSStatusUseCase
import com.neosukisu.neosukisu.domain.usecase.GetSuperUserAppGroupUseCase
import com.neosukisu.neosukisu.domain.usecase.ImportAllowlistUseCase
import com.neosukisu.neosukisu.domain.usecase.ImportProfileTemplatesUseCase
import com.neosukisu.neosukisu.domain.usecase.InitializeApplicationUseCase
import com.neosukisu.neosukisu.domain.usecase.IsLateLoadModeUseCase
import com.neosukisu.neosukisu.domain.usecase.IsModuleUriAccessibleUseCase
import com.neosukisu.neosukisu.domain.usecase.IsNetworkAvailableUseCase
import com.neosukisu.neosukisu.domain.usecase.IsSystemLanguageSettingsUseCase
import com.neosukisu.neosukisu.domain.usecase.LaunchSystemLanguageSettingsUseCase
import com.neosukisu.neosukisu.domain.usecase.LoadSettingsPlatformUseCase
import com.neosukisu.neosukisu.domain.usecase.ObserveCatalogModulesUseCase
import com.neosukisu.neosukisu.domain.usecase.ObserveDownloadUseCase
import com.neosukisu.neosukisu.domain.usecase.ObserveDynamicManagerStateUseCase
import com.neosukisu.neosukisu.domain.usecase.ObserveInstalledModulesUseCase
import com.neosukisu.neosukisu.domain.usecase.ObserveKernelFlashUseCase
import com.neosukisu.neosukisu.domain.usecase.ObserveModuleCatalogOfflineUseCase
import com.neosukisu.neosukisu.domain.usecase.ObserveModuleCatalogRefreshingUseCase
import com.neosukisu.neosukisu.domain.usecase.ObserveProfileTemplateOfflineUseCase
import com.neosukisu.neosukisu.domain.usecase.ObserveProfileTemplateRefreshingUseCase
import com.neosukisu.neosukisu.domain.usecase.ObserveProfileTemplatesUseCase
import com.neosukisu.neosukisu.domain.usecase.ObserveStartupStateUseCase
import com.neosukisu.neosukisu.domain.usecase.ObserveSulogStateUseCase
import com.neosukisu.neosukisu.domain.usecase.ObserveSuperUserStateUseCase
import com.neosukisu.neosukisu.domain.usecase.ObserveUmountStateUseCase
import com.neosukisu.neosukisu.domain.usecase.RebootUseCase
import com.neosukisu.neosukisu.domain.usecase.RefreshDynamicManagerUseCase
import com.neosukisu.neosukisu.domain.usecase.RefreshInstalledModulesUseCase
import com.neosukisu.neosukisu.domain.usecase.RefreshModuleCatalogUseCase
import com.neosukisu.neosukisu.domain.usecase.RefreshProfileTemplatesUseCase
import com.neosukisu.neosukisu.domain.usecase.RefreshSulogUseCase
import com.neosukisu.neosukisu.domain.usecase.RefreshSuperUsersUseCase
import com.neosukisu.neosukisu.domain.usecase.RefreshUmountPathsUseCase
import com.neosukisu.neosukisu.domain.usecase.RemovePreferenceUseCase
import com.neosukisu.neosukisu.domain.usecase.RemoveUmountPathUseCase
import com.neosukisu.neosukisu.domain.usecase.SaveModuleActionLogUseCase
import com.neosukisu.neosukisu.domain.usecase.SaveProfileTemplateUseCase
import com.neosukisu.neosukisu.domain.usecase.SelectDynamicManagerUseCase
import com.neosukisu.neosukisu.domain.usecase.SetAppProfileUseCase
import com.neosukisu.neosukisu.domain.usecase.SetAppSepolicyUseCase
import com.neosukisu.neosukisu.domain.usecase.SetBooleanPreferenceUseCase
import com.neosukisu.neosukisu.domain.usecase.SetDefaultUmountModulesUseCase
import com.neosukisu.neosukisu.domain.usecase.SetKernelUmountEnabledUseCase
import com.neosukisu.neosukisu.domain.usecase.SetManualDynamicManagerUseCase
import com.neosukisu.neosukisu.domain.usecase.SetModuleEnabledUseCase
import com.neosukisu.neosukisu.domain.usecase.SetModuleRemovedUseCase
import com.neosukisu.neosukisu.domain.usecase.SetSelinuxHideEnabledUseCase
import com.neosukisu.neosukisu.domain.usecase.SetStringPreferenceUseCase
import com.neosukisu.neosukisu.domain.usecase.SetStringSetPreferenceUseCase
import com.neosukisu.neosukisu.domain.usecase.SetSuEnabledUseCase
import com.neosukisu.neosukisu.domain.usecase.StartKernelFlashUseCase
import com.neosukisu.neosukisu.domain.usecase.SuSFSConfigUseCase
import com.neosukisu.neosukisu.domain.usecase.TakeModuleUriPermissionUseCase
import com.neosukisu.neosukisu.domain.usecase.TransliterateTextUseCase
import com.neosukisu.neosukisu.domain.usecase.UpdateAppearanceUseCase
import com.neosukisu.neosukisu.domain.usecase.UpdateCachedModuleEnabledUseCase
import com.neosukisu.neosukisu.domain.usecase.UpdatePlatformSettingUseCase
import com.neosukisu.neosukisu.domain.usecase.ValidateSepolicyUseCase
import com.neosukisu.neosukisu.ui.activity.util.ThemeUtils
import com.neosukisu.neosukisu.ui.component.ZipFileDetector
import com.neosukisu.neosukisu.ui.theme.BackgroundManager
import com.neosukisu.neosukisu.ui.theme.CardConfig
import com.neosukisu.neosukisu.ui.theme.ThemeConfig
import com.neosukisu.neosukisu.ui.util.module.Shortcut
import com.neosukisu.neosukisu.ui.viewmodel.AppProfileViewModel
import com.neosukisu.neosukisu.ui.viewmodel.DynamicManagerViewModel
import com.neosukisu.neosukisu.ui.viewmodel.ExecuteModuleActionViewModel
import com.neosukisu.neosukisu.ui.viewmodel.FlashViewModel
import com.neosukisu.neosukisu.ui.viewmodel.HomeViewModel
import com.neosukisu.neosukisu.ui.viewmodel.InstallViewModel
import com.neosukisu.neosukisu.ui.viewmodel.KernelFlashViewModel
import com.neosukisu.neosukisu.ui.viewmodel.MainIntentViewModel
import com.neosukisu.neosukisu.ui.viewmodel.ModuleDetailViewModel
import com.neosukisu.neosukisu.ui.viewmodel.ModuleRepoViewModel
import com.neosukisu.neosukisu.ui.viewmodel.ModuleViewModel
import com.neosukisu.neosukisu.ui.viewmodel.SettingsViewModel
import com.neosukisu.neosukisu.ui.viewmodel.SuSFSViewModel
import com.neosukisu.neosukisu.ui.viewmodel.SulogViewModel
import com.neosukisu.neosukisu.ui.viewmodel.SuperUserViewModel
import com.neosukisu.neosukisu.ui.viewmodel.TemplateEditorViewModel
import com.neosukisu.neosukisu.ui.viewmodel.TemplateViewModel
import com.neosukisu.neosukisu.ui.viewmodel.UmountManagerScreenViewModel
import com.neosukisu.neosukisu.ui.webui.MonetColorsProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import me.zhanghai.android.appiconloader.coil.AppIconFetcher
import me.zhanghai.android.appiconloader.coil.AppIconKeyer
import okhttp3.Cache
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module
import java.io.File
import java.util.Locale
import java.util.concurrent.TimeUnit

val applicationScopeQualifier = named("applicationScope")

val coreModule = module {
    single<CoroutineScope>(applicationScopeQualifier) {
        CoroutineScope(SupervisorJob() + Dispatchers.IO)
    }
    single {
        OkHttpClient.Builder()
            .cache(Cache(File(androidApplication().cacheDir, "okhttp"), 10L * 1024L * 1024L))
            .addInterceptor { chain ->
                chain.proceed(
                    chain.request().newBuilder()
                        .header("User-Agent", "NeoSukiSU/${BuildConfig.VERSION_CODE}")
                        .header("Accept-Language", Locale.getDefault().toLanguageTag())
                        .build()
                )
            }
            .connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(5, TimeUnit.SECONDS)
            .writeTimeout(5, TimeUnit.SECONDS)
            .build()
    }
    single {
        val application = androidApplication()
        val iconSize = application.resources.getDimensionPixelSize(android.R.dimen.app_icon_size)
        ImageLoader.Builder(application)
            .components {
                add(AppIconKeyer())
                add(AppIconFetcher.Factory(iconSize, false, application))
            }
            .build()
    }
}

val repositoryModule = module {
    single { KsuCliRepository(androidApplication()) }
    singleOf(::InstalledPackageCache)
    singleOf(::AppIconDataSource)
    singleOf(::RootServiceRepository)
    singleOf(::InstalledPackageRepository)
    single {
        SuperUserRepository(
            application = get(),
            cache = get(),
            installedPackageRepository = get(),
            profileRepository = get(),
            applicationScope = get(applicationScopeQualifier),
        )
    }
    single {
        AppSettingsRepository(
            context = androidApplication(),
            applicationScope = get(applicationScopeQualifier),
        )
    }
    singleOf(::StartupRepository)
    single {
        ApplicationInitializationRepository(
            application = get(),
            imageLoader = get(),
            applicationScope = get(applicationScopeQualifier),
            flashRepository = get(),
            ksuCliRepository = get(),
            monetCompatColorSource = get(),
        )
    }
    singleOf(::ManagerUpdateRepository)
    singleOf(::ApplicationControlRepository)
    singleOf(::DownloadRepository)
    single { FlashRepository(get(), get(applicationScopeQualifier), get(), get()) }
    singleOf(::KernelRepository)
    singleOf(::HomeRuntimeRepository)
    singleOf(::HomeStateRepository)
    singleOf(::NetworkStatusRepository)
    singleOf(::NetworkRequestRepository)
    singleOf(::DynamicManagerRepository)
    singleOf(::SulogRepository)
    singleOf(::BugreportRepository)
    singleOf(::UmountRepository)
    singleOf(::ModuleCatalogRepository)
    singleOf(::ModuleRepository)
    singleOf(::ModulePreferencesRepository)
    singleOf(::ModuleActionRepository)
    singleOf(::WebResourceRepository)
    singleOf(::WebUiRepository)
    singleOf(::ModuleFileRepository)
    singleOf(::ProfileRepository)
    singleOf(::ProfileTemplateRepository)
    singleOf(::SuSFSConfigHelper)
    singleOf(::SuSFSRepository)
    singleOf(::MonetCompatColorSource)
    singleOf(::ThemeRepository)
    single {
        val themeRepository = get<ThemeRepository>()
        ThemeConfig(themeRepository::defaultSeedColor)
    }
    singleOf(::CardConfig)
    singleOf(::BackgroundManager)
    singleOf(::ThemeUtils)
    singleOf(::LocaleHelper)
    singleOf(::LocaleRepository)
    singleOf(::SettingsPlatformRepository)
    singleOf(::ShortcutRepository)
    singleOf(::Shortcut)
    singleOf(::MonetColorsProvider)
    singleOf(::ZipFileDetector)
    single { HanziToPinyin.create() } bind TextTransliterator::class
}

val useCaseModule = module {
    factoryOf(::InitializeApplicationUseCase)
    factoryOf(::GetHomeBasicInfoUseCase)
    factoryOf(::IsNetworkAvailableUseCase)
    factoryOf(::LoadSettingsPlatformUseCase)
    factoryOf(::UpdateAppearanceUseCase)
    factoryOf(::UpdatePlatformSettingUseCase)
    factoryOf(::GetPlatformFeatureStatusUseCase)
    factoryOf(::CheckManagerUpdateUseCase)
    factoryOf(::EnsureManagerInstalledUseCase)
    factoryOf(::RebootUseCase)
    factoryOf(::EnqueueDownloadUseCase)
    factoryOf(::EnqueueManagerUpdateUseCase)
    factoryOf(::ObserveDownloadUseCase)
    factoryOf(::GetKernelStatusUseCase)
    factoryOf(::GetInstallEnvironmentUseCase)
    factoryOf(::ExecuteFlashOperationUseCase)
    factoryOf(::CheckFlashModuleMountUseCase)
    factoryOf(::GetManagerRuntimeInfoUseCase)
    factoryOf(::GetKernelFeatureSettingsUseCase)
    factoryOf(::SetSuEnabledUseCase)
    factoryOf(::SetKernelUmountEnabledUseCase)
    factoryOf(::ConfigureSuLogUseCase)
    factoryOf(::SetSelinuxHideEnabledUseCase)
    factoryOf(::SetDefaultUmountModulesUseCase)
    factoryOf(::IsLateLoadModeUseCase)
    factoryOf(::GetAppProfileUseCase)
    factoryOf(::SetAppProfileUseCase)
    factoryOf(::GetAppSepolicyUseCase)
    factoryOf(::SetAppSepolicyUseCase)
    factoryOf(::ControlAppUseCase)
    factoryOf(::ValidateSepolicyUseCase)
    factoryOf(::GetDefaultUmountModulesUseCase)
    factoryOf(::GetSuSFSStatusUseCase)
    factoryOf(::SuSFSConfigUseCase)
    factoryOf(::ApplyLanguageUseCase)
    factoryOf(::IsSystemLanguageSettingsUseCase)
    factoryOf(::LaunchSystemLanguageSettingsUseCase)
    factoryOf(::GenerateBugreportUseCase)
    factoryOf(::ObserveStartupStateUseCase)
    factoryOf(::GetSuperUserAppGroupUseCase)
    factoryOf(::ObserveCatalogModulesUseCase)
    factoryOf(::ObserveModuleCatalogRefreshingUseCase)
    factoryOf(::ObserveModuleCatalogOfflineUseCase)
    factoryOf(::RefreshModuleCatalogUseCase)
    factoryOf(::GetCatalogModuleUseCase)
    factoryOf(::ObserveProfileTemplatesUseCase)
    factoryOf(::ObserveProfileTemplateRefreshingUseCase)
    factoryOf(::ObserveProfileTemplateOfflineUseCase)
    factoryOf(::RefreshProfileTemplatesUseCase)
    factoryOf(::GetProfileTemplateUseCase)
    factoryOf(::SaveProfileTemplateUseCase)
    factoryOf(::DeleteProfileTemplateUseCase)
    factoryOf(::ImportProfileTemplatesUseCase)
    factoryOf(::ExportProfileTemplatesUseCase)
    factoryOf(::GetBooleanPreferenceUseCase)
    factoryOf(::SetBooleanPreferenceUseCase)
    factoryOf(::GetStringPreferenceUseCase)
    factoryOf(::SetStringPreferenceUseCase)
    factoryOf(::GetStringSetPreferenceUseCase)
    factoryOf(::SetStringSetPreferenceUseCase)
    factoryOf(::ObserveDynamicManagerStateUseCase)
    factoryOf(::RefreshDynamicManagerUseCase)
    factoryOf(::SelectDynamicManagerUseCase)
    factoryOf(::SetManualDynamicManagerUseCase)
    factoryOf(::ClearDynamicManagerUseCase)
    factoryOf(::ObserveSulogStateUseCase)
    factoryOf(::RefreshSulogUseCase)
    factoryOf(::EnableSulogUseCase)
    factoryOf(::CleanSulogUseCase)
    factoryOf(::ObserveUmountStateUseCase)
    factoryOf(::RefreshUmountPathsUseCase)
    factoryOf(::AddUmountPathUseCase)
    factoryOf(::RemoveUmountPathUseCase)
    factoryOf(::ObserveKernelFlashUseCase)
    factoryOf(::StartKernelFlashUseCase)
    factoryOf(::RemovePreferenceUseCase)
    factoryOf(::ObserveSuperUserStateUseCase)
    factoryOf(::RefreshSuperUsersUseCase)
    factoryOf(::BackupAllowlistUseCase)
    factoryOf(::ImportAllowlistUseCase)
    factoryOf(::FetchRemoteTextUseCase)
    factoryOf(::IsModuleUriAccessibleUseCase)
    factoryOf(::TakeModuleUriPermissionUseCase)
    factoryOf(::ExtractModuleNameUseCase)
    factoryOf(::ExtractModuleIdUseCase)
    factoryOf(::ObserveInstalledModulesUseCase)
    factoryOf(::RefreshInstalledModulesUseCase)
    factoryOf(::CalculateInstalledModuleSizeUseCase)
    factoryOf(::UpdateCachedModuleEnabledUseCase)
    factoryOf(::ExecuteModuleActionUseCase)
    factoryOf(::SaveModuleActionLogUseCase)
    factoryOf(::SetModuleEnabledUseCase)
    factoryOf(::SetModuleRemovedUseCase)
    factoryOf(::TransliterateTextUseCase)
}

val viewModelModule = module {
    viewModel { parameters ->
        AppProfileViewModel(
            uid = parameters[0],
            packageName = parameters[1],
            getAppGroup = get(),
            getProfile = get(),
            getDefaultUmountModules = get(),
            setProfile = get(),
            getSepolicy = get(),
            setSepolicy = get(),
            controlApp = get(),
            validateSepolicy = get(),
        )
    }
    viewModelOf(::HomeViewModel)
    viewModelOf(::InstallViewModel)
    viewModelOf(::MainIntentViewModel)
    viewModelOf(::KernelFlashViewModel)
    viewModelOf(::SettingsViewModel)
    viewModelOf(::ModuleViewModel)
    viewModelOf(::SuperUserViewModel)
    viewModelOf(::SuSFSViewModel)
    viewModelOf(::ModuleRepoViewModel)
    viewModel { parameters -> ModuleDetailViewModel(parameters[0], get()) }
    viewModelOf(::TemplateViewModel)
    viewModel { parameters ->
        TemplateEditorViewModel(
            templateId = parameters[0],
            readOnly = parameters[1],
            isCreation = parameters[2],
            getTemplate = get(),
            saveTemplate = get(),
            deleteTemplate = get(),
        )
    }
    viewModelOf(::SulogViewModel)
    viewModelOf(::DynamicManagerViewModel)
    viewModelOf(::FlashViewModel)
    viewModelOf(::UmountManagerScreenViewModel)
    viewModel { parameters ->
        ExecuteModuleActionViewModel(
            moduleId = parameters[0],
            executeModuleAction = get(),
            saveModuleActionLog = get(),
        )
    }
}

val appModules = listOf(coreModule, repositoryModule, useCaseModule, viewModelModule)
