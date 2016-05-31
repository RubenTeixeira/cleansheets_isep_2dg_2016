@echo off
cd scripts
if "%1" == "build" goto build
if "%1" == "run" goto run
if "%1" == "console" goto console
call build
call run
goto end
:build
call build
goto end
:run
call run
goto end
:console
call console
:end
cd ..