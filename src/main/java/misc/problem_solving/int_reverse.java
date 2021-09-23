package misc.problem_solving;

/**
 *
 */
public class int_reverse {
    public static void main(String[] args) {
    int x = 12345;
    System.out.println(reverse(x));
    }
    // time: O(log)
    static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            // just pop last digit
            int pop = x % 10;
            // got number without this last digit
            x /= 10;
            // checking for extremal cases to signed 32-bit int
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            // construct reverse output
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
