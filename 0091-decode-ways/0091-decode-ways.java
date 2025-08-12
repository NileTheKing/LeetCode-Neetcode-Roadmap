class Solution {
    public int numDecodings(String s) {
        return partition(s);
    }
    public int partition(String s) {
        int length = s.length();
        if (length == 0) return 1;
        if (length == 1) {
            if (isValid(s)) return 1;
            else return 0;
        }
        
        if (s.charAt(0) == '0') return 0; 
        int cnt = partition(s.substring(1, s.length()));
        if (isValid(s.substring(0,2))) {
            cnt += partition(s.substring(2, s.length()));
        }

        return cnt;
    }
    public boolean isValid(String s) {
        if (s.charAt(0) == '0') return false;
        
        int val = Integer.parseInt(s);
        if (val <= 0 || val > 26) return false;

        return true;
    }
}