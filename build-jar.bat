@echo off
color 0B
cls
echo.
echo ========================================
echo   GENERAR JAR PARA RENDER
echo ========================================
echo.
echo [PASO 1] Limpiando proyecto...
call mvnw.cmd clean
echo.

echo [PASO 2] Generando JAR (sin tests)...
call mvnw.cmd package -DskipTests
echo.

if errorlevel 1 (
    echo.
    echo ========================================
    echo   ERROR AL GENERAR JAR
    echo ========================================
    echo.
    pause
    exit /b 1
) else (
    echo.
    echo ========================================
    echo   JAR GENERADO EXITOSAMENTE!
    echo ========================================
    echo.
    echo Archivo: target\futbol-1.jar
    echo.
    dir target\*.jar
    echo.
    echo SIGUIENTE PASO:
    echo 1. Sube el proyecto a GitHub
    echo 2. Conecta Render con tu repositorio
    echo 3. Render usara el Dockerfile automaticamente
    echo.
)

pause
