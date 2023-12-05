package lc.trie.e;

import java.util.Arrays;
import java.util.LinkedHashMap;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        Arrays.sort(strs);

        LinkedHashMap<Character, Integer> hm = new LinkedHashMap<>();

        for (int j = 0; j < strs[0].length(); j++) {
            char currentChar = strs[0].charAt(j);
            boolean isCommon = true;
            for (int i = 1; i < strs.length; i++) {
                if (j >= strs[i].length() || strs[i].charAt(j) != currentChar) {
                    isCommon = false;
                    break;
                }
            }
            if (isCommon) {
                hm.put(currentChar, hm.getOrDefault(currentChar, 0) + 1);
            } else {
                break;
            }
        }

        StringBuilder result = new StringBuilder();
        for (char c : hm.keySet()) {
            while(hm.get(c)!=0){
                result.append(c);
                hm.put(c,hm.get(c)-1);
            }
        }

        return result.toString();
    }
}
