package lc.trie.e;

import java.util.Arrays;

class Trie {
    private Trie[] children = new Trie[2];
    private int cnt = 0;
    public Trie() {}
    public void insert(int x) {
        Trie node = this;
        for (int i = 7; i >= 0; --i) {
            int v = x >> i & 1;
            if (node.children[v] == null) {
                node.children[v] = new Trie();
            }
            node = node.children[v];
            ++node.cnt;
        }
    }
    public int search(int x) {
        Trie node = this;
        int ans = 0;
        for (int i = 7; i >= 0; --i) {
            int v = x >> i & 1;
            if (node.children[v ^ 1] != null && node.children[v ^ 1].cnt > 0) {
                ans |= 1 << i;
                node = node.children[v ^ 1];
            } else
                node = node.children[v];
        }
        return ans;
    }
    public void remove(int x) {
        Trie node = this;
        for (int i = 7; i >= 0; --i) {
            int v = x >> i & 1;
            node = node.children[v];
            --node.cnt;
        }
    }
}
class MaximumStrongPairXORI {
    // O(n log n) O(n)
    public int maximumStrongPairXor(int[] nums) {
        Arrays.sort(nums); // O(n log n)
        Trie tree = new Trie();
        int ans = 0, i = 0;
        for (int y : nums) {
            tree.insert(y); // O(1) -> O(n)
            while (y > nums[i] * 2)
                tree.remove(nums[i++]); // O(1) -> O(n)
            ans = Math.max(ans, tree.search(y)); // O(1) -> O(n)
        }
        return ans;
    }

    public static void main(String[] args) {
        var mspx = new MaximumStrongPairXORI();
        int[] nums = new int[] {1,2,3,4,5};
        System.out.println(mspx.maximumStrongPairXor(nums));
    }
}

