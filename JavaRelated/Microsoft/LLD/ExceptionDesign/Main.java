package Microsoft.LLD.ExceptionDesign;

import java.util.HashMap;
import java.util.Map;

// Singleton class for managing exceptions

// Test cases

public class Main {
    public static void main(String[] args) {
        TestCases testCases = new TestCases();

        // Run test cases
        testCases.testSingleton();
        testCases.testRegisterException();
        testCases.testGetException();

        // Example usage of ExceptionUtil
        ExceptionUtil exceptionUtil = ExceptionUtil.getInstance();
        Exception customException = new Exception("Custom Exception");
        exceptionUtil.registerException("CustomException", customException);

        Exception retrievedException = exceptionUtil.getException("CustomException");
        if (retrievedException != null) {
            System.out.println("Retrieved exception: " + retrievedException.getMessage());
        } else {
            System.out.println("Exception not found");
        }
    }
}
