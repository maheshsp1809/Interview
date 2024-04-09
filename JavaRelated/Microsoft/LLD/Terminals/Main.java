package LLD.Terminals;

public class Main {
    public static void main(String[] args) {
        Terminal terminal = new Terminal();

        // Initial directory listing
        System.out.println("Current directory: " + terminal.getCurrentDirectory());
        terminal.listDirectoryContents();

        // Create a file
        terminal.createFile("file1.txt");

        // List directory contents after file creation
        System.out.println("\nCurrent directory: " + terminal.getCurrentDirectory());
        terminal.listDirectoryContents();

        // Write content to the file
        terminal.writeFile("file1.txt", "Hello, World!");

        // Read file content
        System.out.println("\nReading file content:");
        terminal.readFile("file1.txt");

        // Delete a file
        terminal.deleteFile("file2.txt");
    }
}
