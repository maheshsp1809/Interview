package recursion;

public class Case_permute {
    public static void spacePermute(String str) {
        spacePermuteHelper("", str);
    }

    private static void spacePermuteHelper(String prefix, String suffix) {
        if (suffix.length() == 0) {
            System.out.print("(" + prefix + ")");
            return;
        }
        spacePermuteHelper(prefix + suffix.charAt(0), suffix.substring(1));
        spacePermuteHelper(prefix + Character.toUpperCase(suffix.charAt(0)), suffix.substring(1));

    }

    public static void main(String[] args) {
        String str = "abc";
        spacePermute(str);
    }
}
