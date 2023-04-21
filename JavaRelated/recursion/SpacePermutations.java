package recursion;

public class SpacePermutations {
    public static void spacePermute(String str) {
        String prefix = str.substring(0, 1);
        spacePermuteHelper(prefix, str.substring(1));
    }

    private static void spacePermuteHelper(String prefix, String suffix) {
        if (suffix.length() == 0) {
            System.out.print("(" + prefix + ")");
            return;
        }
        spacePermuteHelper(prefix + suffix.charAt(0), suffix.substring(1));
        spacePermuteHelper(prefix + " " + suffix.charAt(0), suffix.substring(1));

    }

    public static void main(String[] args) {
        String str = "ABCDE";
        spacePermute(str);
    }
}
