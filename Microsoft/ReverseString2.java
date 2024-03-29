package Microsoft;

import java.util.*;

public class ReverseString2 {
    public static void reverseWords(char[] s) {
        // Reverse the entire character array first
        reverse(s, 0, s.length - 1);

        // Reverse each word separately
        int start = 0;
        for (int end = 0; end < s.length; end++) {
            if (s[end] == ' ') {
                reverse(s, start, end - 1);
                start = end + 1;
            }
        }
        // Reverse the last word
        reverse(s, start, s.length - 1);
    }

    private static void reverse(char[] s, int left, int right) {
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        char[] s = { 't', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e' };
        reverseWords(s);
        System.out.println("Reversed Words: " + new String(s));
    }
}
