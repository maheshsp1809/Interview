package DesignPatterns;

public class Singleton {
    // The volatile keyword ensures that multiple threads
    // handle the uniqueInstance variable correctly when it is being initialized
    private static volatile Singleton instance = null;

    // Private constructor to prevent instantiation
    private Singleton() {
        // Private to prevent instantiation
    }

    // Method to get the single instance of the class
    public static Singleton getInstance() {
        if (instance == null) {
            // Lock the class to make it thread-safe
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    // Add other methods for business logic here
    public void doSomething() {
        System.out.println("Singleton instance is doing something...");
    }
}
