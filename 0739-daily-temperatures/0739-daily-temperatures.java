class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> mono = new Stack<>();
        int length = temperatures.length;
        int[] ans = new int[length];
        mono.push(0);

        for (int i = 1; i < length; i++) {
            //대소 비교해서 다 끄집어 낸다음에 인덱스 정보 구함
            int idx = i;
            while (!mono.isEmpty() && temperatures[mono.peek()] < temperatures[i]) {//73 74 75 입력받고 71입력받으면
            //
                idx = mono.pop();
                ans[idx] = i - idx;
            }

            //인덱스 정보 넣기. 끄집어 내진놈
            mono.push(i);
        }

        return ans;
    }
}
/**
mono: 73
current 74
current 75
current 

question is mono.peek() > current OR mono.peek() < current
 */