package recursion;

import java.util.ArrayList;
import java.util.List;

class Leet784 {
    public static List<String> letterCasePermutation(String str) {
        List<String> res = new ArrayList<String>();
        spacePermuteHelper("", str, res);
        return res;
    }

    private static void spacePermuteHelper(String prefix, String suffix, List<String> res) {
        if (suffix.length() == 0) {
            res.add(prefix);
            return;
        }
        if (Character.isLowerCase(suffix.charAt(0))) {
            spacePermuteHelper(prefix + suffix.charAt(0), suffix.substring(1), res);
            spacePermuteHelper(prefix + Character.toUpperCase(suffix.charAt(0)), suffix.substring(1), res);
        } else if (Character.isUpperCase(suffix.charAt(0))) {
            spacePermuteHelper(prefix + suffix.charAt(0), suffix.substring(1), res);
            spacePermuteHelper(prefix + Character.toLowerCase(suffix.charAt(0)), suffix.substring(1), res);
        } else {
            spacePermuteHelper(prefix + suffix.charAt(0), suffix.substring(1), res);
        }
        return;
    }

    public static void main(String[] args) {
        String str = "A1b";
        List<String> result = new ArrayList<String>();
        result = letterCasePermutation(str);
        System.out.println(result);
    }
}
