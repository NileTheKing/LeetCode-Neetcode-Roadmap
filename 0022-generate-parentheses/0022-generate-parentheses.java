class Solution {
    List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();

        dfs(0, 0, n, new StringBuilder());

        return ans;
    }

    public void dfs(int opencount, int closedcount, int n, StringBuilder current) {
        if (opencount == n && closedcount == n) {// 만족 종료조건
            ans.add(current.toString());
            return;
        }

        
        if (opencount < n) {
            current.append('(');
            dfs(opencount + 1, closedcount, n, current);
            current.deleteCharAt(current.length() - 1);
        }

        if (closedcount < opencount) {
            current.append(')');
            dfs(opencount, closedcount + 1, n, current);
            current.deleteCharAt(current.length() - 1);
        }


    }
}