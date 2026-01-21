class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length ()  < s1.length()) return false;
        
        int[] freq1 = new int[26]; //s1의 빈도수를 저장 a to z: 0 to 25
        int[] freq2 = new int[26]; //s2의 빈도수
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            freq1[c1 - 'a']++;

            char c2 = s2.charAt(i);
            freq2[c2 - 'a']++;
        }

        //sliding window로 substring찾기

        //초기상태에서 비교
        if (Arrays.equals(freq1, freq2)) return true;

        //진짜 비교
        for (int i = 1; i < s2.length() - s1.length() + 1; i++) {
            //나갈거 나가고 들어올거 나온다음에 비교
            int l = i - 1; //빠질 놈
            freq2[s2.charAt(l) - 'a']--;
            int r = i + s1.length() - 1; //새로 들어올 인덱스
            freq2[s2.charAt(r) - 'a']++;

            if (Arrays.equals(freq1, freq2)) return true;
        }
        return false;
    }
}