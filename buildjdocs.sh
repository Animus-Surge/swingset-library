#!/bin/bash

#Builds javadocs. Assumes you have the jdk 14 or greater on the PATH variable

cd src
javadoc -d ../site/docs -subpackages xt.surge.swingset
cd ..