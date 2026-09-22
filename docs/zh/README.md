# NeoSukiSU
<img align='right' src='NeoSukiSU_blue.svg' width='220px' alt="NeoSukiSU Icon">


[English](../README.md) | **简体中文**

一个 [`ReSukiSU/ReSukiSU`](https://github.com/ReSukiSU/ReSukiSU) 的重命名分支，而 ReSukiSU 本身是 [`SukiSU-Ultra/SukiSU-Ultra`](https://github.com/SukiSU-Ultra/SukiSU-Ultra) 的下游分支。

[![最新发行](https://img.shields.io/github/v/release/Lxiaoyao077/NeoSukiSU?label=Release&logo=github)](https://github.com/Lxiaoyao077/NeoSukiSU/releases/latest)
[![最新 CI 构建（nightly.link）](https://img.shields.io/badge/nightly.link-%E6%9C%80%E6%96%B0%20CI%20%E6%9E%84%E5%BB%BA-800080)](https://nightly.link/Lxiaoyao077/NeoSukiSU/workflows/build-manager/main)
[![Kernel License: GPL v2](https://img.shields.io/badge/License-GPL%20v2-orange.svg?logo=gnu)](https://www.gnu.org/licenses/old-licenses/gpl-2.0.en.html)
[![其他部分 License：GPL v3](https://img.shields.io/github/license/Lxiaoyao077/NeoSukiSU?logo=gnu)](/LICENSE)

## 特性

1. 基于内核的 `su` 和权限管理。
2. 基于 [metamodules](https://kernelsu.org/zh_CN/guide/metamodule.html) 的模块系统：可插拔的模块架构。
3. [App Profile](https://kernelsu.org/zh_CN/guide/app-profile.html): 把 Root 权限关进笼子里。
4. 支持 non-GKI 与 GKI 1.0。
5. 可调整管理器外观，可自定义 susfs 配置。
6. 多管理器支持，默认支持使用 [官方KernelSU](https://github.com/tiann/KernelSU)/[RKSU](https://github.com/rsuntk/KernelSU)/[MKSU](https://github.com/5ec1cff/KernelSU)/[SukiSU](https://github.com/SukiSU-Ultra/SukiSU-Ultra) 作为管理器与 NeoSukiSU 内核共同工作

## 兼容状态

- NeoSukiSU 官方支持 GKI 2.0 的设备（内核版本 5.10 以上）。

- 旧内核也是兼容的（3.4+），不过需要自己编译内核。

- 目前支持架构 : `arm64-v8a`、`armeabi-v7a`、`x86_64`。

- `Tracepoint Syscall Redirect Hook` 只支持在 GKI2 内核(5.10+) 工作

## Hook 模式
- `Tracepoint Syscall Redirect hook` 默认模式, 来自于 [上游](https://github.com/tiann/KernelSU), 但是只支持 GKI2 内核且为 `arm64-v8a` 或 `x86_64` 架构
- `Manual Hook` 兼容性最强的钩子，支持 Linux Kernel 3.4 - Linux Kernel 6.18
- `SuSFS Inline Hook` 一个来自 [SuSFS](https://github.com/simonpunk/susfs4ksu) 的 Hook, 类似于 `Manual Hook`, 但是由 `SuSFS` 项目，而非本项目

## 集成

请参考[文档](https://resukisu.org)

## 许可证

- 目录 `kernel` 下所有文件为 [GPL-2.0-only](https://www.gnu.org/licenses/old-licenses/gpl-2.0.en.html)。
- 有动漫人物图片表情包的这些文件 `ic_launcher(?!.*alt.*).*` 图标以特别的形式授权，怡子曰曰绘制，版权明风OuO所有。矢量化图标由上游 ReSukiSU 项目提供。详见 [`LICENSE_icon_English`](./LICENSE_icon_English) 与 [`LICENSE_icon_SC`](./LICENSE_icon_SC)。
- 除上述文件及目录的其他部分均为 [GPL-3.0-or-later](https://www.gnu.org/licenses/gpl-3.0.html)。

## 鸣谢

- [KernelSU](https://github.com/tiann/KernelSU): 上游
- [SukiSU-Ultra/SukiSU-Ultra](https://github.com/SukiSU-Ultra/SukiSU-Ultra)：分叉来源
- [ReSukiSU/ReSukiSU](https://github.com/ReSukiSU/ReSukiSU)：本分支的直接父项目

<details>
<summary>SukiSU 的鸣谢</summary>

- [KernelSU](https://github.com/tiann/KernelSU): 上游
- [MKSU](https://github.com/5ec1cff/KernelSU): 魔法坐骑支持
- [RKSU](https://github.com/rsuntk/KernelsU): non-GKI 支持
- [susfs](https://gitlab.com/simonpunk/susfs4ksu): 隐藏内核补丁以及用户空间模组的 KernelSU 附件
- [KernelPatch](https://github.com/bmax121/KernelPatch): KernelPatch 是内核模块 APatch 实现的关键部分
</details>

<details>
<summary>KernelSU 的鸣谢</summary>

- [kernel-assisted-superuser](https://git.zx2c4.com/kernel-assisted-superuser/about/)：KernelSU 的灵感。
- [Magisk](https://github.com/topjohnwu/Magisk)：强大的 root 工具箱。
- [genuine](https://github.com/brevent/genuine/)：apk v2 签名验证。
- [Diamorphine](https://github.com/m0nad/Diamorphine)：一些 rootkit 技巧。
</details>
