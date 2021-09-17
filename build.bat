@echo off

:: ANSI ESCAPE CHARACTER: 

::TODO: get this thing to be able to use the system java folder

echo Swingset buildscript v1.2

set EC=0

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
    echo [31;1mERROR[0m: No target specified. Possible targets are: compile, javadoc, dist, all, clean, run, comprun
    exit /B 1
)

:: Handle all possible variants of the target

::list all possible targets

if "%1"=="list" (
    echo Possible targets:
    echo compile, javadoc, dist, all, clean, run, comprun
    exit /B 0
)

::Compile

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
    if defined "%COMP_AND_RUN%" goto comprun
    cd ..
)

::javadocs

if "%1"=="javadoc" (
    if not exist "%JPATH%/javadoc.exe" (
        echo [31;1mERROR[0m: javadoc.exe. JDK must not exist in java folder.
        exit /B 1
    )
    
    echo Building javadocs...

    
)

::distributable JAR file

::all of them

::run the application
if "%1"=="run" (
    ::Check if out folder exists
    if not exist out (
        echo [31;1mERROR[0m: out folder does not exist. Run build compile to be able to run the app.
        exit /B 1
    )

    cd out
    ..\%JPATH%\java.exe xt.surge.swingset.Main
    if ERRORLEVEL 1 set EC=1
    cd ..
)

::compile and run the application
if "%1"=="comprun" (
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

    cd ..

    if not exist out (
        echo [31;1mERROR[0m: Compilation failed. See any additional log output for more information.
        exit /B 1
    )

    cd out
    ..\%JPATH%\java.exe xt.surge.swingset.Main
    if ERRORLEVEL 1 set EC=1
    cd ..
)

::clean

if "%1"=="clean" (
    echo Cleaning output files...
    del /S out
)

if "%EC%"=="1" echo [31;1mERROR[0m: Build failed. See output above for more details. && exit /B 1
echo [92;1mSUCCESS[0m: Build succeeded.