class Solution {
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backtrack(s, 0, new ArrayList<>());
        return ans;
    }
    public void backtrack(String s, int start, List<String> current) {
        if (start == s.length()) {
            ans.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            //i가 end니까 그거대로 잘라보기
            String substr = s.substring(start, i + 1);
            if (!isPalindromic(substr)) continue;
            current.add(substr);
            backtrack(s, i + 1, current);
            current.remove(current.size() - 1);
        }
    }
    public boolean isPalindromic(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}