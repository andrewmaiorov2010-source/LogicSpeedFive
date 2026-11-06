param(
    [Parameter(Mandatory = $true)]
    [string]$MindustryJar
)

$ErrorActionPreference = 'Stop'
$projectRoot = Split-Path -Parent $MyInvocation.MyCommand.Path
$buildRoot = Join-Path $projectRoot 'build'
$classesDir = Join-Path $buildRoot 'classes'
$jarPath = Join-Path $buildRoot 'LogicSpeedFive-1.2.0.jar'

if (-not (Test-Path -LiteralPath $MindustryJar -PathType Leaf)) {
    throw "Mindustry JAR not found: $MindustryJar"
}

if (Test-Path -LiteralPath $buildRoot) {
    Remove-Item -LiteralPath $buildRoot -Recurse -Force
}
New-Item -ItemType Directory -Force -Path $classesDir | Out-Null
$sources = Get-ChildItem -LiteralPath (Join-Path $projectRoot 'src\main\java') -Filter '*.java' -Recurse | ForEach-Object { $_.FullName }
javac --release 17 -classpath $MindustryJar -d $classesDir $sources
if ($LASTEXITCODE -ne 0) { throw "javac failed with exit code $LASTEXITCODE" }

Copy-Item -LiteralPath (Join-Path $projectRoot 'plugin.hjson') -Destination $classesDir
$bundlesDir = Join-Path $projectRoot 'bundles'
if (Test-Path -LiteralPath $bundlesDir) {
    Copy-Item -LiteralPath $bundlesDir -Destination $classesDir -Recurse
}
jar --create --file $jarPath -C $classesDir .
if ($LASTEXITCODE -ne 0) { throw "jar failed with exit code $LASTEXITCODE" }

Write-Output "Created $jarPath"
