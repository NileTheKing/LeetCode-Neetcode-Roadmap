class Solution {
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(s, new ArrayList<>());

        return ans;
    }
    public void dfs(String s, List<String> current) {
        if (s.length() == 0) {
            //current.add(s);
            ans.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if(isPalin(s.substring(0,i+1))) { //aab에서 a/ab 넘겨야함. 
                current.add(s.substring(0,i+1));
                //System.out.printf("%s added.current list: ", s.substring(0,i+1));
                //for(String a : current) System.out.printf("%s ", a);
                //System.out.print("/list end. ");
                dfs(s.substring(i+1, s.length()), current);
                //System.out.printf("%s deleted from current list\n", current.get(current.size() - 1));
                current.remove(current.size() - 1);// backtrack
            }
        }
    }
    public boolean isPalin(String s) {
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
/**
brute force
재귀: substring을 잘라서 넘김
 */