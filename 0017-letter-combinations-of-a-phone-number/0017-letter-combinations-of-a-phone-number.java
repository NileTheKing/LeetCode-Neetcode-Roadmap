class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();
        HashMap<Integer, List<Character>> map = new HashMap<>();
        //번호랑 알파벳 매핑해주기 2-9
        map.put(2, Arrays.asList('a', 'b', 'c'));
        map.put(3, Arrays.asList('d', 'e', 'f'));
        map.put(4, Arrays.asList('g', 'h', 'i'));
        map.put(5, Arrays.asList('j', 'k', 'l'));
        map.put(6, Arrays.asList('m', 'n', 'o'));
        map.put(7, Arrays.asList('p', 'q', 'r', 's'));
        map.put(8, Arrays.asList('t', 'u', 'v'));
        map.put(9, Arrays.asList('w', 'x', 'y', 'z'));

        

        backtrack(digits, map, 0, new StringBuilder());

        return ans;
    }
    public void backtrack(String digits, HashMap<Integer, List<Character>> map, int idx, StringBuilder current) {

        if (idx == digits.length()) {
            ans.add(current.toString());
            return;
        }

        //System.out.println("current digit is : " + digits.charAt(idx));
        List<Character> candidates = map.get(digits.charAt(idx) - '0');
        for (char c : candidates) {
            current.append(c);
            backtrack(digits, map, idx + 1, current);
            current.deleteCharAt(current.length() - 1);
        }
        
    }
}