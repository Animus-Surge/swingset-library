@echo off

:: ANSI ESCAPE CHARACTER: 

::TODO: get this thing to be able to use the system java folder

echo Swingset buildscript v1.2

if not exist "java" (
    if not defined "%JAVA_HOME%" (
        echo [31;1mERROR[0m: No java path defined or java folder in project root directory.
        exit /B 1
    )
)

set JPATH=java\bin
if defined "%JAVA_HOME%" set JPATH=%JAVA_HOME%
:: check if bin folder exists

if not exist "%JPATH%" (
    echo [31;1mERROR[0m: Bin folder in defined java folder does not exist.
    exit /B 1
)

:: Project contains java folder or %JAVA_HOME% environment variable is defined. Bin folder exists in java. Can continue with building the project.

:: Check if target is specified

if [%1]==[] (
    echo [31;1mERROR[0m: No target specified.
    exit /B 1
)

:: Handle all possible variants of the target

::list all possible targets

if "%1"=="list" (
    echo Possible targets:
    echo compile, javadoc, dist, all, clean
    exit /B 0
)

::Compile
:compile

if "%1"=="compile" (
    if not exist "%JPATH%/javac.exe" (
        echo [31;1mERROR[0m: javac.exe does not exist. JDK must not exist in java folder.
        exit /B 1
    )

    echo Compiling sources...

    cd src
    ..\%JPATH%\javac.exe -d ../out xt/surge/swingset/Main.java
    if ERRORLEVEL 1 (
        echo [31;1mERROR[0m: javac failed. See above messages for more details.
        exit /B 1
    )

    if defined "%BUILD_ALL%" goto all

    echo [92;1mSUCCESS[0m: Build succeeded.
    cd ..
    exit /B 0
)

::javadocs
:javadoc

if "%1"=="javadoc" (
    if not exist "%JPATH%/javadoc.exe" (
        echo [31;1mERROR[0m: javadoc.exe. JDK must not exist in java folder.
    )
    
    echo Building javadocs...

    javadoc
)

::distributable JAR file
:dist

::all of them
:all