# BatchFileSweeper
## Overview
The BatchFileSweeper is a Java-based utility for deleting files and directories based on specified criteria. It is designed to be used as a **_batch job_**, allowing you to automate the process of cleaning up files and directories that meet certain conditions.

## Features
- Deletes files older than a specified number of minutes from a target directory.
- Removes empty directories after file deletion.
- Configurable via a properties file, allowing you to customize the behavior for different batches.

## Prerequisites
Before running the BatchJobSweeper, make sure you have the following prerequisites installed:
- Java Development Kit (JDK) 8 or higher.

## Usage
1. **Compile the Code**: Compile the Java code using the following command: \
   >javac BatchFileSweeper.java

2. **Run the Batch Job**: Run the .bat File: Execute the provided .bat file (e.g., BatchFileSweeper.bat) to run the Batch File Deletion Job. The .bat file is responsible for setting up the Java environment and executing your Java program.

3. **Monitor and Logging**: The batch job will process files and directories based on the configuration and log the actions taken. Monitor the console for output and any potential error messages.

## Configuration
The Batch File Deletion Job is configured using a properties file. 
1. Configuration File (config.properties):
   In the config.properties file, specify the paths to the directories you want to process. Replace the placeholder paths with the actual paths on your file system.
   > Path1=C:\path\to\target\directory1
   
   > Path2=C:\path\to\target\directory2

2. Java Installation Path / Classpath and Compilation (BatchJobSweeper.bat):
   Set the JAVA_HOME variable to the directory where your Java installation / Files is located.
   > set "JAVA_HOME=C:\path\to\your\java\installation"
   
   > set "CLASSPATH=.;C:\path\to\your\compiled\classes"

You can customize the following properties for each batch:
- PathX: The absolute path to the target directory for the batch.
- set: The absolute path to the target directory for the installations and files.

## Error Handling
The batch job provides basic error handling and logging. Any errors encountered during execution will be logged to the console. You can enhance error handling as needed for your specific use case.
