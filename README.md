# LogicSpeedFive

[![Latest release](https://img.shields.io/github/v/release/andrewmaiorov2010-source/LogicSpeedFive?display_name=tag)](https://github.com/andrewmaiorov2010-source/LogicSpeedFive/releases/latest)

**A Mindustry mod that lets you increase the execution speed of logic processors.** LogicSpeedFive is a Java plugin for Mindustry 160.7 that changes the instruction rate of the vanilla Micro Processor, Logic Processor, and Hyper Processor.

Repository: <https://github.com/andrewmaiorov2010-source/LogicSpeedFive>

## Features

- A global switch to enable or disable acceleration for all three processor types.
- An individual enable switch and speed multiplier for each processor type.
- Integer multipliers from **1× to 15×**, defaulting to **5×**.
- Settings are available at **Settings → Logic Speed Five** and are stored with Mindustry's local settings.
- The `wait` instruction is not accelerated; the mod changes processor instruction rates, not game time or wait duration.

The plugin applies the selected rate to the processor block and to existing processor buildings when settings change, and reapplies rates when a world loads. The vanilla instruction rates are 2, 8, and 25 instructions per tick for Micro, Logic, and Hyper Processors respectively; the selected multiplier scales those rates.

## Requirements and compatibility

- **Mindustry 160.7** (the version used for the 1.2.0 compatibility check).
- The project is a Mindustry Java plugin. Building from source requires **JDK 17** and a local Mindustry 160.7 desktop JAR.

Compatibility is based on a static build and API check against Mindustry 160.7. In-game behavior has not been fully checked. Multiplayer behavior with players using an unmodified vanilla client is **untested**; no multiplayer compatibility is promised.

## Install

1. Download [`LogicSpeedFive-1.2.0.jar`](https://github.com/andrewmaiorov2010-source/LogicSpeedFive/releases/download/v1.2.0/LogicSpeedFive-1.2.0.jar) from [Releases](https://github.com/andrewmaiorov2010-source/LogicSpeedFive/releases).
2. Place the JAR in Mindustry's `mods` folder.
3. Start or restart Mindustry and open **Settings → Logic Speed Five**.

When upgrading, replace the older LogicSpeedFive JAR with the new one.

## Settings

| Setting | Default | Range / effect |
| --- | --- | --- |
| Global acceleration | On | Turns acceleration on or off for all three processors |
| Micro Processor acceleration | On | Per-type enable switch |
| Micro Processor speed | 5× | 1×–15×; vanilla rate is 2 instructions/tick |
| Logic Processor acceleration | On | Per-type enable switch |
| Logic Processor speed | 5× | 1×–15×; vanilla rate is 8 instructions/tick |
| Hyper Processor acceleration | On | Per-type enable switch |
| Hyper Processor speed | 5× | 1×–15×; vanilla rate is 25 instructions/tick |

Each per-type switch works alongside the global switch. Turning either switch off restores that processor type to its vanilla instruction rate. A multiplier of 1× also gives the vanilla rate.

### Examples

- Set **Logic Processor speed** to **2×** to run Logic Processors at 16 instructions per tick while leaving the other types at their own settings.
- Turn off **Hyper Processor acceleration** to leave Hyper Processors at their vanilla rate while Micro and Logic remain accelerated.
- Turn off **Enable processor acceleration** to restore all three processor types to their vanilla rates.

## Known limitations

- The `wait` instruction's duration is unchanged.
- The settings are local to the Mindustry installation. Multiplayer synchronization and behavior are not established by the static checks.
- Multiplayer with vanilla-client players has not been tested.
- If another mod sets a processor's instruction rate to a custom value, LogicSpeedFive preserves that value when it differs from the vanilla rate and the last rate assigned by this plugin.
- The release check was static; it did not include a full in-game, dedicated-server, or multiplayer test.

## Build from source

This project uses the included PowerShell build script rather than Gradle. With JDK 17 and a local Mindustry 160.7 desktop JAR, run:

```powershell
.
build.ps1 -MindustryJar 'C:\path\to\Mindustry-160.7.jar'
```

The script compiles the Java plugin for Java 17 and creates `build/LogicSpeedFive-1.2.0.jar`. It does not launch Mindustry. The source archive also contains a standalone rate-policy check under `src/test`; it is not a Mindustry integration test.

## Downloads and source

- [Release v1.2.0](https://github.com/andrewmaiorov2010-source/LogicSpeedFive/releases/tag/v1.2.0)
- [Installable JAR](https://github.com/andrewmaiorov2010-source/LogicSpeedFive/releases/download/v1.2.0/LogicSpeedFive-1.2.0.jar)
- [Source archive](https://github.com/andrewmaiorov2010-source/LogicSpeedFive/releases/download/v1.2.0/LogicSpeedFive-1.2.0-source.zip)
- [Browse the source code](https://github.com/andrewmaiorov2010-source/LogicSpeedFive/tree/main/src)
- [All releases](https://github.com/andrewmaiorov2010-source/LogicSpeedFive/releases)

## Русский

**LogicSpeedFive — мод для Mindustry, который позволяет увеличить скорость выполнения логических процессоров.** Это Java-плагин для Mindustry 160.7, меняющий частоту исполнения инструкций у стандартных Micro Processor, Logic Processor и Hyper Processor.

### Возможности

- Общий переключатель ускорения всех трёх типов.
- Отдельный переключатель и множитель для каждого типа процессора.
- Целочисленный множитель от **1× до 15×**, по умолчанию **5×**.
- Настройки находятся в **Settings → Logic Speed Five** и сохраняются в локальных настройках Mindustry.
- Инструкция `wait` не ускоряется: мод меняет частоту исполнения инструкций процессора, а не игровое время или длительность ожидания.

Плагин применяет выбранную частоту к блоку процессора и уже построенным процессорам при изменении настроек, а также при загрузке мира. Стандартные частоты составляют 2, 8 и 25 инструкций за тик для Micro, Logic и Hyper Processor соответственно; множитель масштабирует эти значения.

### Требования и совместимость

- **Mindustry 160.7** — версия, для которой проверялась совместимость 1.2.0.
- Для сборки исходников нужны **JDK 17** и локальный desktop JAR Mindustry 160.7.

Совместимость подтверждена статической сборкой и проверкой API Mindustry 160.7. Полная проверка в игре не проводилась. Мультиплеер с игроками, использующими vanilla-клиент, **не проверен**; совместимость с ним не гарантируется.

### Установка

1. Скачайте [`LogicSpeedFive-1.2.0.jar`](https://github.com/andrewmaiorov2010-source/LogicSpeedFive/releases/download/v1.2.0/LogicSpeedFive-1.2.0.jar) со страницы [Releases](https://github.com/andrewmaiorov2010-source/LogicSpeedFive/releases).
2. Поместите JAR в папку `mods` игры Mindustry.
3. Запустите или перезапустите игру и откройте **Settings → Logic Speed Five**.

При обновлении замените старый JAR LogicSpeedFive новой версией.

### Параметры

| Параметр | По умолчанию | Диапазон / действие |
| --- | --- | --- |
| Общее ускорение | Включено | Включает или отключает ускорение трёх типов |
| Ускорение Micro Processor | Включено | Индивидуальный переключатель |
| Скорость Micro Processor | 5× | 1×–15×; стандартная частота — 2 инструкции/тик |
| Ускорение Logic Processor | Включено | Индивидуальный переключатель |
| Скорость Logic Processor | 5× | 1×–15×; стандартная частота — 8 инструкций/тик |
| Ускорение Hyper Processor | Включено | Индивидуальный переключатель |
| Скорость Hyper Processor | 5× | 1×–15×; стандартная частота — 25 инструкций/тик |

### Примеры

- Установите **Logic Processor speed** в **2×**, чтобы получить 16 инструкций за тик для Logic Processor, сохранив отдельные значения для других типов.
- Отключите **Hyper Processor acceleration**, чтобы оставить Hyper Processor на стандартной скорости.
- Отключите **Enable processor acceleration**, чтобы вернуть все три типа к стандартной частоте.

### Ограничения

- Длительность инструкции `wait` не меняется.
- Настройки локальные для установки Mindustry. Синхронизация и сетевое поведение не подтверждены статической проверкой.
- Мультиплеер с игроками на vanilla-клиенте не проверялся.
- Если другой мод задаёт процессору собственную частоту, LogicSpeedFive сохраняет её, когда она отличается от стандартной и последней частоты, назначенной этим плагином.
- Проверка релиза была статической и не включала полноценный запуск игры, dedicated server или мультиплеер.

### Сборка исходников

Проект использует приложенный PowerShell-скрипт, без Gradle. Установите JDK 17 и подготовьте локальный desktop JAR Mindustry 160.7, затем выполните:

```powershell
.\build.ps1 -MindustryJar 'C:\путь\к\Mindustry-160.7.jar'
```

Скрипт компилирует Java-плагин для Java 17 и создаёт `build/LogicSpeedFive-1.2.0.jar`; игру он не запускает. В `src/test` находится отдельная проверка правил расчёта скорости, а не интеграционный тест Mindustry.

### Загрузки и исходный код

- [Релиз v1.2.0](https://github.com/andrewmaiorov2010-source/LogicSpeedFive/releases/tag/v1.2.0)
- [JAR для установки](https://github.com/andrewmaiorov2010-source/LogicSpeedFive/releases/download/v1.2.0/LogicSpeedFive-1.2.0.jar)
- [Архив исходников](https://github.com/andrewmaiorov2010-source/LogicSpeedFive/releases/download/v1.2.0/LogicSpeedFive-1.2.0-source.zip)
- [Исходный код](https://github.com/andrewmaiorov2010-source/LogicSpeedFive/tree/main/src)
- [Все релизы](https://github.com/andrewmaiorov2010-source/LogicSpeedFive/releases)
