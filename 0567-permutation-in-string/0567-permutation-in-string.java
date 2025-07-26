class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        int length = s1.length();
        
        for (int i = 0; i < length; i++) {
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }

        for (int i = length - 1; i < s2.length() -1; i++) {
            if (Arrays.equals(freq1, freq2)) return true;

            int l = i - length + 1;
            freq2[s2.charAt(i+1) - 'a']++;
            freq2[s2.charAt(l) - 'a']--;
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