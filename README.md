# LogicSpeedFive

[![Latest release](https://img.shields.io/github/v/release/andrewmaiorov2010-source/LogicSpeedFive?display_name=tag)](https://github.com/andrewmaiorov2010-source/LogicSpeedFive/releases/latest)

**A Mindustry 160.7 Java plugin that changes the instruction rate of the vanilla Micro, Logic, and Hyper Processors.**

## Features

- One flat settings page with exactly four toggles and three speed sliders; no expandable processor sections.
- English and Russian labels and tooltips. Other game languages fall back to English.
- One overall acceleration toggle and independent per-processor toggles.
- Integer multipliers from **1× to 15×**, defaulting to **5×**.
- Settings persist in Mindustry. Changes apply to processor blocks and existing processors, and are reapplied after a world loads.
- The wait instruction duration and game time are unchanged.

Vanilla instruction rates are 2, 8, and 25 instructions per tick for Micro, Logic, and Hyper Processors. The multiplier affects only the selected processor's instruction rate.

## Requirements and verification

The plugin targets **Mindustry 160.7**. Version 1.3.0 was compiled against the local Mindustry 160.7 desktop API JAR; its rate policy and localization resources were checked statically. **The game was not launched; in-game testing remains for the user.** Multiplayer with vanilla clients is untested.

## Install

1. Download [LogicSpeedFive-1.3.0.jar](https://github.com/andrewmaiorov2010-source/LogicSpeedFive/releases/download/v1.3.0/LogicSpeedFive-1.3.0.jar).
2. Put the JAR in Mindustry's mods folder.
3. Start or restart Mindustry and open **Settings → Logic Speed Five** (Russian: **Настройки → Скорость процессоров**).

When upgrading, replace the older LogicSpeedFive JAR with the new one.

## Settings

| Setting | Default | Effect |
| --- | --- | --- |
| Enable processor acceleration | On | Master switch for all processor types |
| Enable micro processor acceleration | On | Toggle Micro Processor acceleration |
| Micro processor speed | 5× | 1×–15×; vanilla rate: 2 instructions/tick |
| Enable logic processor acceleration | On | Toggle Logic Processor acceleration |
| Logic processor speed | 5× | 1×–15×; vanilla rate: 8 instructions/tick |
| Enable hyper processor acceleration | On | Toggle Hyper Processor acceleration |
| Hyper processor speed | 5× | 1×–15×; vanilla rate: 25 instructions/tick |

A per-processor toggle works with the master switch. Turning either one off restores that type to its vanilla rate. A multiplier of 1× also gives the vanilla rate.

## Build from source

Building requires **JDK 17** and a local Mindustry 160.7 desktop JAR. Run **.\build.ps1 -MindustryJar 'C:\path\to\Mindustry-160.7.jar'**.

The script creates build/LogicSpeedFive-1.3.0.jar and does not launch Mindustry. The source archive includes a standalone rate-policy check under src/test; it is not an in-game integration test.

## Downloads

- [Release v1.3.0](https://github.com/andrewmaiorov2010-source/LogicSpeedFive/releases/tag/v1.3.0)
- [Installable JAR](https://github.com/andrewmaiorov2010-source/LogicSpeedFive/releases/download/v1.3.0/LogicSpeedFive-1.3.0.jar)
- [Source archive](https://github.com/andrewmaiorov2010-source/LogicSpeedFive/releases/download/v1.3.0/LogicSpeedFive-1.3.0-source.zip)
- [Previous release v1.2.0](https://github.com/andrewmaiorov2010-source/LogicSpeedFive/releases/tag/v1.2.0)

## Русский

**LogicSpeedFive — Java-плагин для Mindustry 160.7, который меняет частоту исполнения инструкций стандартных Micro, Logic и Hyper Processor.**

### Возможности

- Одна плоская страница настроек: ровно четыре переключателя и три ползунка, без раскрываемых секций.
- Подписи и подсказки на английском и русском языках; для остальных языков используется английский.
- Общий переключатель ускорения и независимые настройки каждого типа процессора.
- Целочисленный множитель от **1× до 15×**, по умолчанию — **5×**.
- Настройки сохраняются в Mindustry. Изменения применяются к блокам и уже размещённым процессорам, а также после загрузки мира.
- Инструкция wait и игровое время не ускоряются.

Стандартные частоты — 2, 8 и 25 инструкций за тик для Micro, Logic и Hyper Processor. Множитель меняет только частоту выбранного процессора.

### Требования и проверка

Целевая версия — **Mindustry 160.7**. Версия 1.3.0 собрана против локального desktop API JAR Mindustry 160.7; правила расчёта скорости и ресурсы локализации проверены статически. **Игра не запускалась; игровое тестирование остаётся за пользователем.** Мультиплеер с vanilla-клиентами не проверялся.

### Установка

1. Скачайте [LogicSpeedFive-1.3.0.jar](https://github.com/andrewmaiorov2010-source/LogicSpeedFive/releases/download/v1.3.0/LogicSpeedFive-1.3.0.jar).
2. Поместите JAR в папку mods Mindustry.
3. Запустите или перезапустите игру и откройте **Настройки → Скорость процессоров**.

При обновлении замените старый JAR LogicSpeedFive новой версией.

### Параметры

| Параметр | По умолчанию | Действие |
| --- | --- | --- |
| Включить ускорение процессоров | Включено | Общий переключатель |
| Ускорять микропроцессор | Включено | Переключатель Micro Processor |
| Скорость микропроцессора | 5× | 1×–15×; стандартно 2 инструкции/тик |
| Ускорять логический процессор | Включено | Переключатель Logic Processor |
| Скорость логического процессора | 5× | 1×–15×; стандартно 8 инструкций/тик |
| Ускорять гиперпроцессор | Включено | Переключатель Hyper Processor |
| Скорость гиперпроцессора | 5× | 1×–15×; стандартно 25 инструкций/тик |

Индивидуальный переключатель работает вместе с общим. Если отключить один из них, процессор этого типа вернётся к стандартной частоте. Множитель 1× также соответствует стандартной частоте.

### Сборка исходников

Нужны **JDK 17** и локальный desktop JAR Mindustry 160.7. Выполните **.\build.ps1 -MindustryJar 'C:\путь\к\Mindustry-160.7.jar'**.

Скрипт создаёт build/LogicSpeedFive-1.3.0.jar и не запускает игру. В архив исходников входит отдельная проверка правил расчёта скорости в src/test; это не интеграционный тест Mindustry.

### Загрузки

- [Релиз v1.3.0](https://github.com/andrewmaiorov2010-source/LogicSpeedFive/releases/tag/v1.3.0)
- [JAR для установки](https://github.com/andrewmaiorov2010-source/LogicSpeedFive/releases/download/v1.3.0/LogicSpeedFive-1.3.0.jar)
- [Архив исходников](https://github.com/andrewmaiorov2010-source/LogicSpeedFive/releases/download/v1.3.0/LogicSpeedFive-1.3.0-source.zip)
- [Предыдущий релиз v1.2.0](https://github.com/andrewmaiorov2010-source/LogicSpeedFive/releases/tag/v1.2.0)
