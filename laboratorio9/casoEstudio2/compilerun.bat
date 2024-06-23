@echo off
setlocal enabledelayedexpansion

:: Verificar si se proporcionó el nombre del archivo de la clase principal como argumento
if "%~1" == "" (
    echo Error: Debe proporcionar el nombre del archivo de la clase principal como argumento.
    exit /b 1
)

:: Asignar el argumento proporcionado a una variable y quitar el sufijo .java si está presente
set MAIN_CLASS=%~n1
echo %MAIN_CLASS%

:: Compilar los archivos Java
javac -cp .\lib\mysql-connector-j-8.4.0.jar -d .\bin\ *.java

:: Verificar si la compilación fue exitosa
if %ERRORLEVEL% neq 0 (
    echo Error: La compilación falló.
    exit /b 1
)

:: Ejecutar la aplicación Java
java -cp .\bin;.\lib\mysql-connector-j-8.4.0.jar casoEstudio2.%MAIN_CLASS%

:: Verificar si la ejecución fue exitosa
if %ERRORLEVEL% neq 0 (
    echo Error: La ejecución falló.
    exit /b 1
)

::echo La aplicación se ejecutó correctamente.