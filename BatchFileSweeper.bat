@echo off
setlocal enabledelayedexpansion

rem Set the Java executable path (update with your Java installation path)
set "JAVA_HOME=C:\path\to\your\java\installation"
set "JAVA_CMD=%JAVA_HOME%\bin\java"

rem Set the classpath to include your compiled Java classes
set "CLASSPATH=.;C:\path\to\your\compiled\classes"

rem Set the path to your configuration file and batch index
set "CONFIG_FILE=config.properties"
set "BATCH_INDEX=1"

rem Execute the Java program with arguments
%JAVA_CMD% -cp %CLASSPATH% BatchFileSweeper %CONFIG_FILE% %BATCH_INDEX%

pause
