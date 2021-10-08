package misc.problem_solving;

/**
 *
 */
public class ShortestDistanceToCharacter {
    public static void main(String[] args) {
        String s = "loveleetcode";
        char c = 'e';
        System.out.println(shortestToChar(s,c));
    }
    // O(n) O(n)
    // perfect
    static int[] shortestToChar(String S, char C) {
        int N = S.length();
        int[] ans = new int[N];
        int prev = Integer.MIN_VALUE / 2;

        for (int i = 0; i < N; ++i) {
            if (S.charAt(i) == C) prev = i;
            ans[i] = i - prev;
        }

        prev = Integer.MAX_VALUE / 2;
        for (int i = N-1; i >= 0; --i) {
            if (S.charAt(i) == C) prev = i;
            ans[i] = Math.min(ans[i], prev - i);
        }

        return ans;
    }
}
