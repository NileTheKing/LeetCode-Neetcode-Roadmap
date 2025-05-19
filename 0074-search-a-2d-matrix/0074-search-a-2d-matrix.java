class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;

        int first = 0;
        int last = r * c - 1;

        while (first <= last) {
            int mid = first + (last - first) / 2;
            int[] coord = getMid(mid, r, c);

            int no = matrix[coord[0]][coord[1]];
            if (no == target) {
                return true;
            }

            else if (no > target) {
                last = mid - 1;
            }else {
                first = mid + 1;
            }
        }

        return false;


    }
    public int[] getMid(int given, int r, int c) {
        // 5면 1,1 6이면 1,2 r=3, c=4
        return new int[] {given / c, given % c};
    }
}
/**
이진탐색.
2차원을 1차원으로 바꿔서 하면 됨.
first mid last로.
2차원 2차원 2차원


 */