package recursion;

public class PalindromeChecker {

    public static boolean isPalindrome(String str) {
        if (str.length() <= 1) {
            return true;
        }

        char first = str.charAt(0);
        char last = str.charAt(str.length() - 1);
        if (first == last) {
            String substring = str.substring(1, str.length() - 1);
            return isPalindrome(substring);
        }
        return false;
    }

    public static void main(String[] args) {
        String str1 = "racecar";
        String str2 = "hello";

        if (isPalindrome(str1)) {
            System.out.println(str1 + " is a palindrome.");
        } else {
            System.out.println(str1 + " is not a palindrome.");
        }

        if (isPalindrome(str2)) {
            System.out.println(str2 + " is a palindrome.");
        } else {
            System.out.println(str2 + " is not a palindrome.");
        }
    }
}
