package lc.trie.m;

public class AddBoldTaginString {
    public String addBoldTag(String s, String[] dict) {
        if (s.length() == 0 || dict.length == 0)
            return s;
        boolean[] boldTable = new boolean[s.length()];
        int end = 0;
        for(int i = 0; i < s.length(); i++) {
            for(String word : dict) {
                int wordLength = word.length();

                if(i + wordLength <= s.length() && s.substring(i, i + wordLength).equals(word)) {
                    end = Math.max(end , i + wordLength);
                }
            }
            boldTable[i] = end > i;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(!boldTable[i]) {
                sb.append(s.charAt(i));
                continue;
            }
            else {
                int j = i;
                while( j < s.length() && boldTable[j])
                {
                    j++;
                }
                sb.append("<b>").append(s.substring(i, j)).append("</b>");
                i = j - 1;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        var abtis = new AddBoldTaginString();
        String s = "abcxyz123";
        String[] dict = {"abc","123"};
        System.out.println(abtis.addBoldTag(s, dict));
    }
}
