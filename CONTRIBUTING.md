# Contributing

Thanks for your interest in LogicSpeedFive. Keep changes focused on the behavior and settings of the three vanilla logic processors.

## Before proposing a change

- Describe the user-visible behavior and the Mindustry version you checked.
- Keep claims about multiplayer, dedicated servers, and in-game behavior limited to what you verified.
- Do not include game JARs, credentials, personal data, or unrelated project files.
- Do not add or imply a project license. No license has been selected for this repository.

## Building

Use JDK 17 and a local Mindustry 160.7 desktop JAR:

```powershell
.\build.ps1 -MindustryJar 'C:\path\to\Mindustry-160.7.jar'
```

The script writes the plugin JAR under `build/`. Please include the build environment and results when reporting a build issue.
