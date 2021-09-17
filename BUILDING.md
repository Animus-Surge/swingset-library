## How to build

The `build.bat`/`build.sh` files are there to enable you to be able to build the project more easily. They're basically like a custom version of Make, but written specifically for this project.

**IMPORTANT: There *MUST* be a java folder in the project directory that contains a JDK, otherwise none of the steps below will work.** To get the JDK, go to java.oracle.com and find the latest JDK download. Be sure to find the compressed archive download for your system. Once downloaded, extract into the java folder. Make sure that there are no extra subfolders in there. The directory tree should look something like this:

```
.
| /java
| | /bin
| | /conf
| | /include
| | /jmods
| | /legal
| | /lib
| | release
| /res
| /site
| /src
| ...
```

### Targets

Similar to make, the argument to invoking this script is a build target. Here's a list of all possible targets:

|Target|Description|
|---|---|
|`compile`|Compiles the sources and places them in a directory called `out`|
|`javadoc`|Creates all the javadocs for the project|
|`dist`|Creates a distributable binary|
|`all`|Creates all the above|
|`clean`|Cleans compiled code, binaries, and documentation|
|`run`|Runs the compiled project|
|`comprun`|Compiles and runs the project|

### Invocation

#### Windows

To run the script, open a command prompt and navigate to the project directory. An easy way to do this is by opening the file explorer, navigating to the project root, and in the longer bar at the top typing cmd. From there simply type in the following:

```
build <target>
```

If all goes well, you should see the SUCCESS message in green, and if not take a look at the message that will get output as a result.