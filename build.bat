@echo off

:: ANSI ESCAPE CHARACTER: 

::TODO: get this thing to be able to use the system java folder

echo Swingset buildscript v1.2

::Initialize variables
set "PDIR=%cd%"
set CPATH=%PATH%
set EMSG=

::Check to see if the PATH variable already has JAVAC on it
javac --version >nul 2>nul
::If the command errors, then clear PATH and check for a java directory.
if ERRORLEVEL 1 (
    set PATH=
    if exist "java" (
        java\bin\javac.exe --version >nul 2>nul
        if ERRORLEVEL 0 set PATH=%PDIR%\java\bin;%PATH% && goto check
        set EMSG=Java folder exists in project root, however there is no JDK.
        goto error
    ) else (
        set EMSG=No jdk defined in PATH and no jdk in project root.
        goto error
    )
)

:check

if [%1]==[] (
    set EMSG=No target defined.
    goto error
)

if %1==list goto list
if %1==compile goto list
if %1==comprun goto list
if %1==run goto list
if %1==javadoc goto list
if %1==dist goto list
if %1==clean goto list
if %1==all goto list

::Lists all possible targets
:list
echo Possible targets:
echo list, compile, comprun, run, javadoc, dist, clean, all, list
goto quit

::Compiles the project
:compile

::Creates a distributable binary
:builddist

::Runs the compiled application
:run

::Cleans all output files
:clean

::Constructs documentation from all javadocs in the project
:javadoc

::Compiles the project, and then runs the project if the compilation was successful
:compileandrun

::Compiles the project, creates a distributable binary, and constructs javadocs
:all

:success
echo [92;1mSUCCESS[0m: Build succeeded.

::For whenever something needs to skip the success message
:quit
exit /B 0

:error
echo [31;1mERROR[0m: %EMSG%
set EMSG=
set PATH=%CPATH%
set CPATH=
set PDIR=
exit /B 1