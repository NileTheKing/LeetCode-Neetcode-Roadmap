class Solution {
    public boolean isValid(String s) {
        ArrayDeque<Character> stk = new ArrayDeque<>();
        for(char c : s.toCharArray()) {
            // System.out.printf("===%c===\n", c);
            if (isOpen(c)) stk.offerFirst(c);
            else {
                if (stk.isEmpty()) {
                    // System.out.printf("empty fail\n");
                    return false;
                }
                char polled = stk.pollFirst();
                if (!isMatched(polled, c)) {
                    // System.out.printf("match fail\n");
                    return false;
                }
            }
        }
        return stk.isEmpty() ? true : false;
    }
    public boolean isOpen(char c) {
        if (c == '(' || c == '[' || c == '{') return true;
        else return false;
    }
    public boolean isMatched(char c1, char c2) {
        if (c1 == '(' && c2 == ')') return true;
        if (c1 == '{' && c2 == '}') return true;
        if (c1 == '[' && c2 == ']') return true;

        return false;
    }
}