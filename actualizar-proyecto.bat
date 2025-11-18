@echo off
echo ====================================
echo LIMPIANDO Y ACTUALIZANDO PROYECTO
echo ====================================
echo.

echo [1/4] Limpiando archivos compilados...
if exist target rmdir /s /q target
if exist .classpath del /f .classpath
if exist .project del /f .project
if exist .factorypath del /f .factorypath
if exist .settings rmdir /s /q .settings

echo [2/4] Limpiando cache de Maven...
if exist %USERPROFILE%\.m2\repository\com\futbol rmdir /s /q %USERPROFILE%\.m2\repository\com\futbol

echo [3/4] Regenerando archivos de Eclipse...
call mvnw.cmd eclipse:clean eclipse:eclipse

echo [4/4] Compilando proyecto...
call mvnw.cmd clean compile

echo.
echo ====================================
echo PROYECTO ACTUALIZADO
echo ====================================
echo.
echo Ahora puedes:
echo 1. Cerrar tu IDE
echo 2. Abrir de nuevo el proyecto
echo 3. Dejar que el IDE indexe todo de nuevo
echo.
pause
