package DSAcoding;

public class ReverseVowels {
    public static void main(String[] args) {
        String s = "abecidofju";
        System.out.println(reverse(s));
    }

    public static String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        int i = 0;
        int j = sb.length() - 1;
        while (i < j) {
            while (!isVowel(sb.charAt(i)) && i < j) {
                ++i;
            }
            while (!isVowel(sb.charAt(j)) && i < j) {
                --j;
            }
            if (i < j) {
                char c = sb.charAt(i);
                sb.setCharAt(i, sb.charAt(j));
                sb.setCharAt(j, c);
                ++i;
                --j;
            }
        }
        return sb.toString();
    }

    private static boolean isVowel(char charAt) {
        String vowels = "AEIOUaeiou";
        return vowels.contains(Character.toString(charAt));
    }
}
