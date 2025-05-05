class Solution {
    public boolean isValidSudoku(char[][] board) {
        int rsize = 9;
        int csize = 9;
        //validate rows
        for (int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if(!set.contains(board[i][j]) && board[i][j] != '.') set.add(board[i][j]);
                else if(set.contains(board[i][j])) {
                    //System.out.println("rows. [r,c]=" + "[" + i + ","  + j +"] " );
                    return false;
                }
            }
        }

        //validate cols
        for (int i = 0; i < 9; i++) { //i = col
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if(!set.contains(board[j][i])&& board[j][i] != '.') set.add(board[j][i]);
                else if(set.contains(board[j][i])){
                    //System.out.println("cols");
                    return false;
                }
            }
        }
        //validate 3*3
        int[][] directions = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        for (int i = 0; i < 3; i++) {
            int r = i * 3 + 1;//r= 1,4,7
            for (int j = 0; j < 3; j++) {
                int c = j * 3 + 1;
                Set<Character> set = new HashSet<>();
                for (int[] d : directions) {
                    int newx = r + d[0];
                    int newy = c + d[1];
                    if (!set.contains(board[newx][newy])&& board[newx][newy] != '.') set.add(board[newx][newy]);
                    else if(set.contains(board[newx][newy])) {
                    //System.out.println("3*3");
                    return false;
                    }
                }
            }
        }

        return true;
    }
}