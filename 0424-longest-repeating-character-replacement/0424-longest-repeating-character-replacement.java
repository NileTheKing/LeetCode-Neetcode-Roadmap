class Solution {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        int l = 0;
        int[] freq = new int[26];
        int mostFreq = 0;
        int max = 0;
        for (int r = 0; r < len; r++) {
            char c = s.charAt(r);
            freq[c - 'A']++;
            mostFreq = Math.max(mostFreq, freq[c-'A']);
            
            while (r - l + 1 - mostFreq > k) {
                freq[s.charAt(l) - 'A']--;
                l++;
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}