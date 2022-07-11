import java.io.FileWriter;
import java.io.IOException;

public class VirusExample {
    /**
     * @param args Command-line arguments.
     * @throws IOException if file cannot be opened.
     * 
     * Creates a file named file1.dll in append mode and repeatedly 
     * appends "Virus" into it.
     */
    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter("D:/VirusFiles/file1.dll", true);
        while (true) {
            fileWriter.write("Virus");
        }
    }
}
