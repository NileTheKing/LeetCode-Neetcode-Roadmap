class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int length1 = s1.length();
        int length2 = s2.length();

        if (length1 > length2) return false;
        int r = length1;
        int l = 0;
        int[] freq1 = new int[26]; //s1 빈도수
        int[] freq2 = new int[26]; //s2 slide 빈도수

        //s1빈도수 저장
        for (char c : s1.toCharArray()){
            freq1[c - 'a'] += 1;
        }

        //s2 sliding window 초기값
        for (int i = 0; i < length1; i++) {
            freq2[s2.charAt(i) - 'a'] += 1;
        }
        
        while (r < s2.length()) { //순회하면서 슬라이딩 윈도우를 조작해서 일치하는지 확

            if (Arrays.equals(freq1, freq2)) {
                return true;
            }

            freq2[s2.charAt(r) - 'a'] += 1;
            freq2[s2.charAt(l) - 'a'] -= 1;
            l++;
            r++;
            
            //r기준으로 fixed sliding window의 빈도수가 일치하는지 확인
            
        }
        
        if (Arrays.equals(freq1, freq2)) {
                return true;
        }

        return false;
    }
}