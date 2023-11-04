package lc.slidingwindow.h;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()){
            return "";
        }
        // map
        // *SD - sliding window
        // K ; V = 1    element present in sliding window
        // K ; V = 0    element not present in sliding window
        // K ; V = -1   duplicate of element in  window

        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<t.length();i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        int count=0,start=0,min_length = Integer.MAX_VALUE, min_start = 0;
        for(int end=0; end<s.length(); end++){
            if(map.containsKey(s.charAt(end))){
                if(map.get(s.charAt(end))>0){
                    count+=1;
                }
                map.put(s.charAt(end), map.get(s.charAt(end))-1);
            }
            if(count == t.length()) {
                while(start < end && (!map.containsKey(s.charAt(start)) || map.get(s.charAt(start)) < 0)){
                    if(map.containsKey(s.charAt(start))){
                        map.put(s.charAt(start), map.get(s.charAt(start))+1);
                    }
                    start+=1;
                }
                if(min_length > end-start+1){
                    min_length = end-(min_start=start)+1;
                }
                if(map.containsKey(s.charAt(start))){
                    map.put(s.charAt(start), map.get(s.charAt(start))+1);
                }
                count-=1;
                start+=1;
            }
        }
        return min_length == Integer.MAX_VALUE ? "" : s.substring(min_start, min_start+min_length);
    }

    public static void main(String[] args) {
        var mws = new MinimumWindowSubstring();
        System.out.println(mws.minWindow(new String("ADOBECODEBANC"),new String("ABC")));
    }
}