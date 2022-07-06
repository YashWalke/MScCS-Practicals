import java.io.File;
import java.util.Scanner;

public class DirectorySearcher {
    private String directoryPath;

    /**
     * @param directoryPath Absolute path of the directory
     * Creates a directorySearcher object with a specified directory path.
     */
    public DirectorySearcher(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    /**
     * @param filter Filter to be applied
     * Searches the directory for filenames starting with given
     * filter.Ignores subdirectories.
     */
    public void search(String filter) {
        File file = new File(directoryPath);
        File[] fileArray = file.listFiles();

        for (File file2 : fileArray) {
            if (file2.isDirectory()) {
                continue;
            }
            if (file2.getName().startsWith(filter)) {
                System.out.println(file2.getName());
            }
        }
    }

    /**
     * @param args Command line arguments
     * Driver code.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a directory > ");
        String directoryPath = scanner.nextLine();

        DirectorySearcher directorySearcher = new DirectorySearcher(directoryPath);

        System.out.println("Enter filter > ");
        String filter = scanner.nextLine();

        directorySearcher.search(filter);

        scanner.close();
    }
}
