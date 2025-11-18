@echo off
color 0E
echo.
echo ========================================
echo   DIAGNOSTICO DEL PROYECTO FUTBOL
echo ========================================
echo.

echo [1/5] Verificando Java...
java -version
echo.

echo [2/5] Verificando archivos del proyecto...
if exist "src\main\java\com\futbol\app\FutbolApplication.java" (
    echo [OK] FutbolApplication.java existe
) else (
    echo [ERROR] Falta FutbolApplication.java
)
echo.

echo [3/5] Contando archivos Java...
dir /s /b src\*.java | find /c ".java"
echo archivos .java encontrados
echo.

echo [4/5] Verificando pom.xml...
if exist "pom.xml" (
    echo [OK] pom.xml existe
    findstr "3.2.5" pom.xml >nul
    if errorlevel 1 (
        echo [ATENCION] Revisa la version de Spring Boot en pom.xml
    ) else (
        echo [OK] Spring Boot 3.2.5 configurado
    )
) else (
    echo [ERROR] Falta pom.xml
)
echo.

echo [5/5] Verificando application.properties...
if exist "src\main\resources\application.properties" (
    echo [OK] application.properties existe
    findstr "allowPublicKeyRetrieval=true" src\main\resources\application.properties >nul
    if errorlevel 1 (
        echo [ERROR] Falta parametro allowPublicKeyRetrieval=true
    ) else (
        echo [OK] Configuracion MySQL correcta
    )
) else (
    echo [ERROR] Falta application.properties
)
echo.

echo ========================================
echo   DIAGNOSTICO COMPLETADO
echo ========================================
echo.
echo Copia esta informacion y compartela
echo.
pause
