@echo off
echo ====================================
echo COMPILANDO PROYECTO
echo ====================================
echo.

call mvnw.cmd clean compile

echo.
echo ====================================
echo COMPILACION TERMINADA
echo ====================================
pause
