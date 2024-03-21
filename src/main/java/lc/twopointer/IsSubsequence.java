package lc.twopointer;

public class IsSubsequence {
    // O(s+t) O(1)
    public boolean isSubsequence(String s, String t) {
        int p1 = 0, p2 = 0;
        int n1 = s.length(), n2 = t.length();
        int common = 0;
        while (p1 < n1 && p2 < n2 && common != n1) {
            if (s.charAt(p1) == t.charAt(p2)) {
                common++;
                p1++;
            }
            p2++;
        }
        return common == n1;
    }
    public static void main(String[] args) {
        IsSubsequence isSubsequence = new IsSubsequence();
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(isSubsequence.isSubsequence(s, t));
    }
}
