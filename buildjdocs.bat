@echo off
rem Builds the javadocs for the engine into the docs directory.
echo Building javadocs...

rmdir /S /Q docs

cd src
javadoc -d ../docs -subpackages xt.surge.swingset
cd ..