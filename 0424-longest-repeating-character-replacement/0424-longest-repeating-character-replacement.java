class Solution {
    public int characterReplacement(String s, int k) {
        
        int l = 0;
        int[] freq = new int[26];
        int mostFreq = 0;
        int ans = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            freq[c-'A']++;
            mostFreq = Math.max(mostFreq, freq[c-'A']);
            while (r - l + 1 - mostFreq > k) { //길이에서 최빈값 제외하면 봐줄 수 있는 갯수. k보다 작으면 안됨.
                freq[s.charAt(l) - 'A']--;
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }
}
/**
substring -> two pointers
right keeps going anyways, it's a matter of l following or not
it can expand(l stays at the same pos). if it's allowed to expand(k restriction).
you need to keep track of the most frequent character and you don't have to know what that is.
    bcuz ????? <- mola
    but you def need to know the frequency.
 */