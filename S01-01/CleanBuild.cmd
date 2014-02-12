@echo off
if "%M3_HOME%" == "" (
   echo Your M3_HOME environment variable has not been set to the home directory for maven 3
   GOTO CMD_END
)

SETLOCAL
SET M2_HOME=%M3_HOME%
set MAVEN_PROFILE=dev
if not "%1" == "" (
  set MAVEN_PROFILE=%1
)

REM Ensure we're running this script from the directory in which it lives
pushd "%~dp0"


REM create the build directory if it is not already there
if not exist build\ (
   mkdir build
)

REM move to the source tree
CD src

REM build up the command line
set COMMAND=mvn3 -P%MAVEN_PROFILE% -Dmaven.test.skip=true -DskipITs=true clean install

REM prepare to write to a log file
set LOGFILE=..\build\build.log

echo Performing "%COMMAND%"
REM if tee is installed let's pipe to the console and the log file.
where tee.exe /q
if %errorlevel% == 0 (
   call %COMMAND% 2>&1 | tee %LOGFILE%
) else (
   call %COMMAND% > %LOGFILE%
)

REM back to the directory where we started
popd

:CMD_END
ENDLOCAL

pause
