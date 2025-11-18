@echo off
color 0C
cls
echo.
echo ========================================
echo   SOLUCION DEFINITIVA LOMBOK
echo ========================================
echo.
echo [PASO 1] Limpiando archivos compilados...
if exist "target" (
    rmdir /s /q target
    echo [OK] Directorio target eliminado
) else (
    echo [OK] No hay target que limpiar
)
echo.

echo [PASO 2] Limpiando archivos de Eclipse...
if exist ".classpath" del /f .classpath
if exist ".project" del /f .project
if exist ".factorypath" del /f .factorypath
if exist ".settings" rmdir /s /q .settings
echo [OK] Archivos de Eclipse limpiados
echo.

echo [PASO 3] Regenerando proyecto Maven...
call mvnw.cmd clean
echo [OK] Proyecto limpiado
echo.

echo [PASO 4] Regenerando configuracion Eclipse...
call mvnw.cmd eclipse:clean eclipse:eclipse
echo [OK] Configuracion Eclipse regenerada
echo.

echo [PASO 5] Compilando con Maven (procesando Lombok)...
call mvnw.cmd clean compile -DskipTests
echo.

if errorlevel 1 (
    echo.
    echo ========================================
    echo   ERROR AL COMPILAR
    echo ========================================
    echo.
    echo Por favor copia el error y compartelo
    echo.
) else (
    echo.
    echo ========================================
    echo   EXITO! PROYECTO COMPILADO
    echo ========================================
    echo.
    echo AHORA SIGUE ESTOS PASOS:
    echo.
    echo 1. CIERRA tu IDE completamente
    echo 2. BORRA el workspace de Eclipse:
    echo    File ^> Switch Workspace ^> Delete
    echo 3. ABRE de nuevo el proyecto
    echo 4. Espera que indexe TODO
    echo 5. EJECUTA: ejecutar.bat
    echo.
)

pause
