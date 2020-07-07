import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;

public class Main {
    private static final String WORKING_DIRECTORY_FILE = "WorkingDirectoryFile.txt";
    private static final String SUBDIRECTORY_FILE = "SubdirectoryFile.txt";
    private static final String OUTTHERE_FILE = "OutThere.txt";

    public static void main(String[] args) {
        try {
            Path sourceFile = FileSystems.getDefault().getPath("Examples", "file1.txt");
            Path copyFile = FileSystems.getDefault().getPath("Examples", "file1copy.txt");
            Files.copy(sourceFile, copyFile);
        } catch(IOException e) {
            e.printStackTrace();
        }



//        Path path = FileSystems.getDefault().getPath(WORKING_DIRECTORY_FILE);
//        printFile(path);
//
////        Path filePath = FileSystems.getDefault().getPath("files", SUBDIRECTORY_FILE);
//        Path filePath = FileSystems.getDefault().getPath(".","files", SUBDIRECTORY_FILE);
//        printFile(filePath);
//
////        filePath = Paths.get("/home/beltran/IdeaProjects/JavaMasterClass/section_14/" + OUTTHERE_FILE);
//        filePath = Paths.get("/home/beltran/IdeaProjects", "JavaMasterClass/section_14/", OUTTHERE_FILE);
//        printFile(filePath);
//
//        filePath = Paths.get(".");
//        System.out.println(filePath.toAbsolutePath());
//
//        Path path2 = FileSystems.getDefault().getPath(".", "files", "..", "files", SUBDIRECTORY_FILE);
//        System.out.println(path2.normalize().toAbsolutePath());
//        printFile(path2.normalize());
//
//        Path path3 = FileSystems.getDefault().getPath("thisfiledoesntexist.txt");
//        System.out.println(path3.toAbsolutePath());
//
//        Path path4 = Paths.get("/Volumes/Test/ING", "abcdef", "whatever.txt");
//        System.out.println(path4.toAbsolutePath());
//
//        filePath = FileSystems.getDefault().getPath("files");
//        System.out.println("Exists = " + Files.exists(filePath));
//        System.out.println("Exists = " + Files.exists(path4  ));

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
