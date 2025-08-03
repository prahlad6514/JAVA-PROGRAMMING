import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileOperations {

    // File path (you can change this to your desired location)
    private static final String FILE_PATH = "example.txt";

    public static void main(String[] args) {
        try {
            // 1️⃣ Write to the file
            writeToFile("Hello, world!\nThis is a sample file.\n");

            // 2️⃣ Read from the file
            System.out.println("📖 Reading file contents:");
            readFromFile();

            // 3️⃣ Modify the file (e.g., append a new line)
            modifyFile("This line was added later.");

            // 4️⃣ Read again to confirm modification
            System.out.println("\n📖 Reading modified file:");
            readFromFile();

        } catch (IOException e) {
            System.err.println("❌ Error: " + e.getMessage());
        }
    }

    // 📝 Method to write content to a file (overwrites existing content)
    public static void writeToFile(String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            writer.write(content);
            System.out.println("✅ File written successfully.");
        }
    }

    // 📖 Method to read content from a file
    public static void readFromFile() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("👉 " + line);
            }
        }
    }

    // ✏️ Method to modify the file by appending new content
    public static void modifyFile(String newContent) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(newContent + "\n");
            System.out.println("✏️ File modified (content appended).");
        }
    }
}
