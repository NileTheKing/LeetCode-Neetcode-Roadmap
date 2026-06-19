class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //on^2 불가능. 선형 자료구조중에 채택해서 시간복잡도를 줄인다 공간복잡도를 사용하고
        ArrayDeque<Integer> stk = new ArrayDeque<>(); //인덱스 들고있는 모노스택
        int[] ans = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int currentT = temperatures[i];
            // System.out.printf("===%d %d===\n", i, currentT);
            while (!stk.isEmpty() && temperatures[stk.peekFirst()] < currentT) {
                int popped = stk.pollFirst();
                ans[popped] = i - popped;
                // System.out.printf("ans[%d] = %d\n", popped, ans[popped]);
            }
            stk.offerFirst(i);
        }
        return ans;
    }
}