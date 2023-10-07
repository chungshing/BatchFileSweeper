import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Logger;
import java.util.logging.Level;

public class BatchFileSweeper {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: BatchFileSweeper <configFile> <batchIndex>");
            System.exit(1);
        }

        String configFile = args[0];
        int batchIndex = Integer.parseInt(args[1]);

        try {
            deleteFunction(configFile, batchIndex);
        } catch (IOException e) {
            e.printStackTrace();
            Logger logger = Logger.getLogger("DeleteFunctionLogger");
            logger.log(Level.SEVERE, "Error deleting files.", e);
        }
    }

    public static void deleteFunction(String configFile, int batchIndex) throws IOException {
        Logger logger = Logger.getLogger("DeleteFunctionLogger");

        // Load configuration from configFile based on batchIndex
        String[] strdirectory = ConfigLoader.loadProperties(configFile);

        // Create a Path for the directory to process
        Path directory = Paths.get(strdirectory[batchIndex]);

        // Define date format for comparison
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss aaa");

        // Get the current time
        Calendar currentTime = Calendar.getInstance();

        // Subtract the specified minutes from the current time
        currentTime.add(Calendar.MINUTE, -Integer.parseInt(strdirectory[batchIndex]));

        // Traverse the directory and delete files older than a certain time
        Files.walkFileTree(directory, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attributes) throws IOException {
                BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);
                FileTime date = attr.creationTime();

                // Format the creation time of the file
                String dateCreated1 = simpleDateFormat.format(date.toMillis());

                try {
                    Date date1 = simpleDateFormat.parse(dateCreated1);

                    if (currentTime.getTime().after(date1)) {
                        try {
                            Files.delete(file);
                            logger.info("Deleted: " + file.getFileName() + " Path: " + file);
                        } catch (IOException e) {
                            e.printStackTrace();
                            logger.log(Level.SEVERE, "Error deleting file: " + file.getFileName(), e);
                        }
                    }
                } catch (java.text.ParseException e) {
                    e.printStackTrace();
                    logger.log(Level.SEVERE, "Error parsing date for file: " + file.getFileName(), e);
                }

                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                if (!dir.equals(directory) && Files.list(dir).count() == 0) {
                    try {
                        Files.delete(dir);
                        logger.info("Deleted: " + dir.getFileName() + " Path: " + dir);
                    } catch (IOException e) {
                        e.printStackTrace();
                        logger.log(Level.SEVERE, "Error deleting directory: " + dir.getFileName(), e);
                    }
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
