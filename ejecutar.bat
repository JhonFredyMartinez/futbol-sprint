@echo off
cls
color 0A
echo.
echo ========================================
echo    APLICACION DE GESTION DE FUTBOL
echo ========================================
echo.
echo [*] Iniciando Spring Boot...
echo [*] Espera a ver el banner de Spring Boot
echo.
echo ========================================
echo  La aplicacion estara disponible en:
echo  http://localhost:8096
echo ========================================
echo.
echo [!] Presiona Ctrl+C para detener
echo.

call mvnw.cmd spring-boot:run

echo.
echo [!] Aplicacion detenida
pause
