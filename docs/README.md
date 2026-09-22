# NeoSukiSU
<img align='right' src='NeoSukiSU_blue.svg' width='220px' alt="NeoSukiSU Icon">


**English** | [简体中文](./zh/README.md)

A rebranded fork of [`ReSukiSU/ReSukiSU`](https://github.com/ReSukiSU/ReSukiSU), which itself is a downstream fork of [`SukiSU-Ultra/SukiSU-Ultra`](https://github.com/SukiSU-Ultra/SukiSU-Ultra).

[![Latest release](https://img.shields.io/github/v/release/Lxiaoyao077/NeoSukiSU?label=Release&logo=github)](https://github.com/Lxiaoyao077/NeoSukiSU/releases/latest)
[![Latest CI build (nightly.link)](https://img.shields.io/badge/nightly.link-Latest%20CI%20Build-800080)](https://nightly.link/Lxiaoyao077/NeoSukiSU/workflows/build-manager/main)
[![Kernel License: GPL v2](https://img.shields.io/badge/License-GPL%20v2-orange.svg?logo=gnu)](https://www.gnu.org/licenses/old-licenses/gpl-2.0.en.html)
[![Other part License：GPL v3](https://img.shields.io/github/license/Lxiaoyao077/NeoSukiSU?logo=gnu)](/LICENSE)

## Features

1. Kernel-based `su` and root access management
2. Module system based on [metamodules](https://kernelsu.org/guide/metamodule.html): Pluggable infrastructure for systemless modifications.
3. [App Profile](https://kernelsu.org/guide/app-profile.html): Lock up the root power in a cage
4. Support non-GKI and GKI 1.0
5. Tweaks to the manager theme and the built-in susfs management tool.
6. Multi manager support, for default [Official KernelSU](https://github.com/tiann/KernelSU)/[RKSU](https://github.com/rsuntk/KernelSU)/[MKSU](https://github.com/5ec1cff/KernelSU)/[SukiSU](https://github.com/SukiSU-Ultra/SukiSU-Ultra) is supported work as manager with NeoSukiSU's kernel

## Compatibility Status

- NeoSukiSU officially supports Android GKI 2.0 devices (kernel 5.10+).

- Older kernels (3.4+) are also compatible, but the kernel will have to be built manually.

- Currently, only `arm64-v8a`, `armeabi-v7a` and `X86_64`are supported.

- [SuSFS](https://gitlab.com/simonpunk/susfs4ksu) in this project is **Only** support backport to kernel 4.3+

- `Tracepoint Syscall Redirect hook` is only support with GKI2(5.10+) kernel

## Hook Mode
- `Tracepoint Syscall Redirect hook` The default hook mode, from [upstream](https://github.com/tiann/KernelSU), but its only support GKI2 kernel with `arm64-v8a` or `x86_64` ABI
- `Manual Hook` The most compatible Hook, support from Linux kernel 3.4 to Linux kernel 6.18
- `SuSFS Inline Hook` An hook from [SuSFS](https://github.com/simonpunk/susfs4ksu), like `Manual Hook`, but provide from `SuSFS` project, not this project

## Integration

See the [documentation](https://resukisu.org).

## License

- The file in the “kernel” directory is under [GPL-2.0-only](https://www.gnu.org/licenses/old-licenses/gpl-2.0.en.html) license.
- The images of the files `ic_launcher(?!.*alt.*).*` with anime character artwork are licensed under a special arrangement: drawn by [怡子曰曰](https://space.bilibili.com/10545509), the copyright is held by [明风 OuO](https://space.bilibili.com/274939213), and the vectorized icons are provided by the upstream ReSukiSU project. See [`LICENSE_icon_English`](./LICENSE_icon_English) and [`LICENSE_icon_SC`](./LICENSE_icon_SC) for details.
- Except for the files or directories mentioned above, all other parts are under [GPL-3.0 or later](https://www.gnu.org/licenses/gpl-3.0.html) license.

## Credit

- [KernelSU](https://github.com/tiann/KernelSU): upstream
- [SukiSU-Ultra/SukiSU-Ultra](https://github.com/SukiSU-Ultra/SukiSU-Ultra): fork source
- [ReSukiSU/ReSukiSU](https://github.com/ReSukiSU/ReSukiSU): direct parent of this fork

<details>
<summary>SukiSU's credit</summary>

- [KernelSU](https://github.com/tiann/KernelSU): upstream
- [MKSU](https://github.com/5ec1cff/KernelSU): Magic Mount
- [RKSU](https://github.com/rsuntk/KernelsU): support non-GKI
- [susfs](https://gitlab.com/simonpunk/susfs4ksu): An addon root hiding kernel patches and userspace module for KernelSU.
- [KernelPatch](https://github.com/bmax121/KernelPatch): KernelPatch is a key part of the APatch implementation of the kernel module
</details>

<details>
<summary>KernelSU's credit</summary>

- [Kernel-Assisted Superuser](https://git.zx2c4.com/kernel-assisted-superuser/about/): The KernelSU idea.
- [Magisk](https://github.com/topjohnwu/Magisk): The powerful root tool.
- [genuine](https://github.com/brevent/genuine/): APK v2 signature validation.
- [Diamorphine](https://github.com/m0nad/Diamorphine): Some rootkit skills.
</details>
