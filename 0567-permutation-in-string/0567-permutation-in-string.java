class Solution {
    public boolean checkInclusion(String s1, String s2) {
 
        int length1 = s1.length();
        int length2 = s2.length();

        if (length1 > length2) return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        int l = 0;
        int r = length1;
        
        for (int i = 0; i < length1; i++) {
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }

        while (r < length2) {
            if (Arrays.equals(freq1, freq2)) return true;

            freq2[s2.charAt(r) - 'a']++;
            freq2[s2.charAt(l) - 'a']--;
            r++;
            l++;
        }

        if (Arrays.equals(freq1, freq2)) return true;
        else return false;

        
    }
}
/**
s1의 정보를 array든 hash든 저장을 한다
s2를 순회하며 two ptrs를 사용한다.
r은 계속 순회하며 l과 r 사이의 substring의 정보(빈도수)와 s1의 정보가 동일하다면 참
 */