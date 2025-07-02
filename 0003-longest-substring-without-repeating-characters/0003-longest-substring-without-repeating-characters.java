import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 문자열이 null이거나 비어있으면 0 반환
        if (s == null || s.length() == 0) {
            return 0;
        }

        int maxLength = 0; // 가장 긴 부분 문자열의 길이를 저장할 변수
        int left = 0;      // 슬라이딩 윈도우의 왼쪽 포인터
        int right = 0; // right는 for 루프에서 제어되므로 별도 초기화 불필요

        // 현재 윈도우 내의 중복 없는 문자들을 저장할 HashSet
        Set<Character> charSet = new HashSet<>();

        // right 포인터를 문자열의 끝까지 이동시키며 윈도우를 확장
        while (right < s.length()) {
            char currentChar = s.charAt(right); // 현재 오른쪽 포인터의 문자

            // 만약 현재 문자가 HashSet에 이미 있다면 (중복이 발생)
            // 중복 문자가 HashSet에서 제거될 때까지 left 포인터를 이동시키고 HashSet에서 제거
            while (charSet.contains(currentChar)) {
                charSet.remove(s.charAt(left)); // left 포인터가 가리키는 문자를 제거
                left++; // left 포인터를 오른쪽으로 한 칸 이동하여 윈도우 축소
            }

            // 중복이 해결되었으므로, 현재 문자를 HashSet에 추가 (윈도우 확장)
            charSet.add(currentChar);

            // 현재 윈도우의 길이를 계산하고, 최대 길이와 비교하여 업데이트
            // 윈도우 길이는 (right - left + 1
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength; // 최종적으로 찾은 가장 긴 부분 문자열의 길이 반환
    }
}