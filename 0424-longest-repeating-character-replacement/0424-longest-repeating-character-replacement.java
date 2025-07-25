class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;
        int l = 0;
        //int r = 0;

        //Map<Character, Integer> map = new HashMap<>();
        int[] freq = new int[26];
        int maxf = 0;
        for (int r = 0; r < s.length(); r++) {
            
            freq[s.charAt(r) - 'A'] += 1;

            // for (int f : map.values()) {
            //     maxf = Math.max(f, maxf);
            // }
            maxf = Math.max(maxf, freq[s.charAt(r) - 'A']);

            while (r - l + 1 - maxf > k) {
                freq[s.charAt(l) - 'A'] -= 1;
                l++;
            }
            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}