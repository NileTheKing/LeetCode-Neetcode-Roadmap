class Solution {
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backtrack(s, new ArrayList<>());

        return ans;
    }
    public void backtrack(String s, List<String> current) {
        if (s.length() == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }

        for (int i = 1; i <= s.length(); i++) {
            //여기서 끊고
            String sub = s.substring(0, i);
            //System.out.println("sub:" + sub);
            if (!isPalindrome(sub)) {
                //System.out.println("this string is not palindrome: " + sub);
                continue;
            }
            current.add(sub); //유효한 파티션이므로 얘 추가하고 뒤로
            backtrack(s.substring(i, s.length()), current); //다음 파티션 확인
            current.remove(current.size() - 1);
            //dfs하고
            //안끊었다 치고 거기서 이어서
            
        }
    }

     public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
/**
자~
재귀적으로 문제를 줄여나가는 것이 생각이 남
트리처럼..
aab를 a/ab 로 쪼개서
    a a b
    a/ab로 쪼개서 재귀를?흠 재귀하면 안될리도 없지만 좀 복잡쓰
    그렇다면 단순하게? 왜냐하면 s의 길이가 굉장히 짧음. 16이면 뭐
        그것도 잘 모르겠는게 애초에 백트래킹의 근간이 재귀라서



다시 aa/b로 쪼개서
    aa b


그렇다면 palindrome인지 확인하는 함수가 필요하다.
그러고나머지도 다 palindrome이면 추가
아니면 뺵


좀 더 생각해보면 aab를 받아서 이제 파티션을 나누면서 가능성을 보는 거지
a/ab해서
    ab를 새로운 s로 해서 재귀하고
        a와 b로 새로운 s로 재귀해서
이 모든 게 palindrome이면 이 답을 다 추가하면 됨.
그렇다면 흠.. 아닌게 생기는 순간 흐름을 끊으면 되고
흐름을 가져가다가 마지막에서 종료조건에 닿으면 모든 것을 답에 추가하고 종료
흐름 끊을때는 백트래킹..좋아

 */