@echo off

:: ANSI ESCAPE CHARACTER:  Here for copy/paste use for any of the echo commands
:: in this buildscript

::TODO: get this thing to be able to use the system java folder

echo Swingset buildscript v1.4.1

::Initialize variables

::Cache current directory
set "PDIR=%cd%"
::Cache the PATH variable
set "CPATH=%PATH%"
::Initialize error message to empty
set EMSG=

::Check to see if the PATH variable already has JAVAC on it
javac --version >nul 2>nul
::If the command errors, then clear PATH and check for a java directory.
if %ERRORLEVEL%==9009 (
    set PATH=%LOCALAPPDATA%\Programs\Git\cmd
    if exist ".\java" (
        .\java\bin\javac.exe --version >nul 2>nul
        if %ERRORLEVEL%==9009 goto javanoexist
        goto check
    )
    goto javanoexist
)
goto check

:javanoexist
set EMSG=No jdk defined in PATH and no jdk in project root.
goto error

:check
if [%1]==[] (
    set EMSG=No target defined.
    goto error
)

if %1==list goto list
if %1==compile goto compile
if %1==comprun goto compileandrun
if %1==run goto run
if %1==javadoc goto javadoc
if %1==dist goto builddist
if %1==clean goto clean
if %1==all goto all

set EMSG=Unknown target "%1"
goto error

::Lists all possible targets
:list
echo Possible targets:
echo list, compile, comprun, run, javadoc, dist, clean, all, list
goto quit

::Compiles the project
:compile
echo Compiling project...
cd src
javac -d ../out xt/surge/swingset/Main.java
if %ERRORLEVEL%==0 goto success
set EMSG=Compilation failed. See log output for more information.
goto error

::Creates a distributable binary
:builddist
echo WORK IN PROGRESS

::Runs the compiled application
:run
cd out
java xt.surge.swingset.Main
if %ERRORLEVEL%==9009 (
    set EMSG=Unforseeable error has occured. 'java' is not a command.
    goto error
)
goto success

::Cleans all output files
:clean
echo Cleaning output directories...
del /S /F /D docs
del /S /F /D out


::Constructs documentation from all javadocs in the project
:javadoc
echo WORK IN PROGRESS

::Compiles the project, and then runs the project if the compilation was successful
:compileandrun

echo Compiling project...
cd src
javac -d ../out xt/surge/swingset/Main.java
if not %ERRORLEVEL%==0 (
    set EMSG=Compilation failed. See log output for more information.
    goto error
)
echo Compilation successful.
cd ../out
java xt.surge.swingset.Main
if %ERRORLEVEL%==9009 (
    set EMSG=Unforseeable error has occured. 'java' is not a command.
    goto error
)
goto success

::Compiles the project, creates a distributable binary, and constructs javadocs
:all
echo Compiling project...
cd src
javac -d ../out xt/surge/swingset/Main.java
if not %ERRORLEVEL%==0 (
    set EMSG=Compilation failed. See log output for more information.
    goto error
)

:success
echo [92;1mSUCCESS[0m: Target "%1" succeeded.

::For whenever something needs to skip the success message
:quit
cd %PDIR%
set EMSG=
set PATH=%CPATH%
set CPATH=
set PDIR=
exit /B 0

:error
echo [31;1mFAILURE[0m: %EMSG%
cd %PDIR%
set EMSG=
set PATH=%CPATH%
set CPATH=
set PDIR=
exit /B 1