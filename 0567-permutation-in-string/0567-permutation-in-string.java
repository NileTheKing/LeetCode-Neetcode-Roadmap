class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(freq1, freq2)) return true;

        for (int i = 1; i < s2.length() - s1.length()+1; i++) { //4 - 1 - 3 -> 1
            freq2[s2.charAt(i-1) - 'a']--;
            freq2[s2.charAt(i + s1.length()-1) - 'a']++;
            if (Arrays.equals(freq1, freq2)) return true;
        }
        return false;
    }
}
/**
substring
 */