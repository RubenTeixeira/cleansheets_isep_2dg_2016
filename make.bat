@echo off
cd scripts
if "%1" == "build" goto build
if "%1" == "run" goto run
call all
goto end
:build
call build
goto end
:run
call run
:end
cd ..