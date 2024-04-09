package LLD.Terminals;

import java.util.HashMap;
import java.util.Map;

public class Terminal {
    private String currentDirectory;
    private Map<String, String> files; // File name and content mapping

    public Terminal() {
        currentDirectory = "/";
        files = new HashMap<>();
    }

    public String getCurrentDirectory() {
        return currentDirectory;
    }

    public void setCurrentDirectory(String directory) {
        currentDirectory = directory;
    }

    public void listDirectoryContents() {
        System.out.println("Contents of directory " + currentDirectory + ":");
        for (Map.Entry<String, String> entry : files.entrySet()) {
            if (entry.getKey().startsWith(currentDirectory)) {
                System.out.println(entry.getKey());
            }
        }
    }

    public void changeDirectory(String directory) {
        setCurrentDirectory(directory);
        System.out.println("Changed directory to: " + currentDirectory);
    }

    public void createFile(String fileName) {
        files.put(currentDirectory + "/" + fileName, "");
        System.out.println("Created file: " + fileName);
    }

    public void deleteFile(String fileName) {
        if (files.containsKey(currentDirectory + "/" + fileName)) {
            files.remove(currentDirectory + "/" + fileName);
            System.out.println("Deleted file: " + fileName);
        } else {
            System.out.println("File not found: " + fileName);
        }
    }

    public void readFile(String fileName) {
        if (files.containsKey(currentDirectory + "/" + fileName)) {
            String content = files.get(currentDirectory + "/" + fileName);
            System.out.println("File content:");
            System.out.println(content);
        } else {
            System.out.println("File not found: " + fileName);
        }
    }

    public void writeFile(String fileName, String content) {
        if (files.containsKey(currentDirectory + "/" + fileName)) {
            files.put(currentDirectory + "/" + fileName, content);
            System.out.println("File updated: " + fileName);
        } else {
            System.out.println("File not found: " + fileName);
        }
    }

    public static void main(String[] args) {
        Terminal terminal = new Terminal();
        terminal.listDirectoryContents();
        terminal.createFile("file1.txt");
        terminal.listDirectoryContents();
        terminal.writeFile("file1.txt", "Hello, World!");
        terminal.readFile("file1.txt");
        terminal.deleteFile("file2.txt");
    }
}
