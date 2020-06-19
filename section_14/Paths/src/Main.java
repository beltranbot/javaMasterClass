import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    private static final String WORKING_DIRECTORY_FILE = "WorkingDirectoryFile.txt";
    private static final String SUBDIRECTORY_FILE = "SubdirectoryFile.txt";
    private static final String OUTTHERE_FILE = "OutThere.txt";

    public static void main(String[] args) {
        Path path = FileSystems.getDefault().getPath(WORKING_DIRECTORY_FILE);
        printFile(path);

        Path filePath = FileSystems.getDefault().getPath("files", SUBDIRECTORY_FILE);
        printFile(filePath);

        filePath = Paths.get("/home/beltran/IdeaProjects/JavaMasterClass/section_14/" + OUTTHERE_FILE);
        printFile(filePath);
    }

    private static void printFile(Path path) {
        try (BufferedReader fileReader = Files.newBufferedReader(path)) {
            String line;
            while((line = fileReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
