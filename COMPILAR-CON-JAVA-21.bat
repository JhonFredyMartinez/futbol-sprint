@echo off
color 0E
cls
echo.
echo ========================================
echo   COMPILAR CON JAVA 21 ESPECIFICO
echo ========================================
echo.

REM Verifica si existe Java 21 en la ubicación estándar
if exist "C:\Program Files\Java\jdk-21\bin\java.exe" (
    set "JAVA_HOME=C:\Program Files\Java\jdk-21"
    echo [OK] Java 21 encontrado en: %JAVA_HOME%
) else if exist "C:\Program Files\Java\jdk-21.0.1\bin\java.exe" (
    set "JAVA_HOME=C:\Program Files\Java\jdk-21.0.1"
    echo [OK] Java 21 encontrado en: %JAVA_HOME%
) else if exist "C:\Program Files\Java\jdk-21.0.2\bin\java.exe" (
    set "JAVA_HOME=C:\Program Files\Java\jdk-21.0.2"
    echo [OK] Java 21 encontrado en: %JAVA_HOME%
) else (
    echo [ERROR] No se encuentra Java 21 instalado
    echo.
    echo Por favor instala Java 21 desde:
    echo https://adoptium.net/temurin/releases/?version=21
    echo.
    echo O actualiza este script con la ruta correcta de tu Java 21
    echo.
    pause
    exit /b 1
)

echo.
echo [*] Verificando version de Java...
"%JAVA_HOME%\bin\java.exe" -version
echo.

echo [*] Limpiando proyecto...
call mvnw.cmd clean
echo.

echo [*] Compilando con Lombok...
call mvnw.cmd compile -DskipTests
echo.

if errorlevel 1 (
    echo.
    echo ========================================
    echo   ERROR AL COMPILAR
    echo ========================================
    echo.
    echo Revisa el error arriba ^
    echo.
) else (
    echo.
    echo ========================================
    echo   COMPILACION EXITOSA!
    echo ========================================
    echo.
    echo Ahora puedes ejecutar: ejecutar.bat
    echo.
)

pause
