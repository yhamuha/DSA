package cs.dynamic;

public class FibTabOptimized {

    // tabulation approach enhanced
    // O(N), no recursion, no extra memory
    int fib (int n) {
        if (n==0) return 0;
        if (n==1) return 1;

        int a =0;
        int b=1;
        int c = a + b;

        for(int i=2; i<=n; i++) {
            c=a+b;
            a=b;
            b=c;
        }
        return c;
    }
}
