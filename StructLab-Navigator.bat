@echo off
setlocal

cd /d "%~dp0"

if not exist out mkdir out

javac -d out src\StructLabNavigator.java
if errorlevel 1 (
    echo.
    echo Kompilasi gagal. Periksa pesan error di atas.
    pause
    exit /b 1
)

echo.
java -cp out StructLabNavigator

echo.
pause