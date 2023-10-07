# BatchFileSweeper
## Overview
The Batch File Deletion Job is a Java-based utility for deleting files and directories based on specified criteria. It is designed to be used as a **_batch job_**, allowing you to automate the process of cleaning up files and directories that meet certain conditions.

## Features
- Deletes files older than a specified number of minutes from a target directory.
- Removes empty directories after file deletion.
- Configurable via a properties file, allowing you to customize the behavior for different batches.

## Prerequisites
Before running the Batch File Deletion Job, make sure you have the following prerequisites installed:
- Java Development Kit (JDK) 8 or higher.
- Your batch configuration properties file.

## Usage
1. **Compile the Code**: Compile the Java code using the following command: \
   >javac BatchFileDeletionJob.java

2. **Run the Batch Job**: Run the batch job with the following command, passing your configuration properties file and batch index as arguments:
   >java BatchFileDeletionJob <configFile> <batchIndex>
   
   Replace <configFile> with the path to your configuration properties file and <batchIndex> with the index of the batch you want to process.

3. **Monitor and Logging**: The batch job will process files and directories based on the configuration and log the actions taken. Monitor the console for output and any potential error messages.

## Configuration
The Batch File Deletion Job is configured using a properties file. Each batch is defined in the properties file with a unique key, like "Path1," "Path2," etc. Here's an example configuration entry:
>Path1=/path/to/target/directory

You can customize the following properties for each batch:
- PathX: The absolute path to the target directory for the batch.
- MinutesX: The number of minutes to subtract from the current time for file deletion criteria.

## Error Handling
The batch job provides basic error handling and logging. Any errors encountered during execution will be logged to the console. You can enhance error handling as needed for your specific use case.
