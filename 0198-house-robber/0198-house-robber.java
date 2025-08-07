class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        //전칸에서 했던 상태의 최대랑, 안한 상태의 최대랑 비교해서 두개의 상태를 가져가야함
        //왜냐하면 상태 하나만 가지고 있으면 전에 훔쳤는지 추적이 제대로 안된다
        int[] status1 = new int[n]; //현재에서 안훔친 상태에서 최댓값. 현재에서 안훔친다면
        int[] status2 = new int[n]; //현재 집에서 훔친 상태에서 최댓값. 이러면 다음칸에서 계쏙 이용할 수 있음.
        status1[0] = 0;
        status2[0] = nums[0];
        status1[1] = status2[0];
        status2[1] = nums[1];
        for (int i = 2; i < n; i++) {
            status1[i] = Math.max(status1[i-1], status2[i-1]); //지금 인덱스 집은 안털었다 치고
            status2[i] = Math.max(status1[i-1] +nums[i], status2[i-2] + nums[i]); //지금 인덱스 집을 털었다 치고
        }

        return Math.max(status1[n-1], status2[n-1]);
    }
}
/**
각 집은 털수도 있고 안털수도 있지 당연하게
하지만 하나털면 무조건 다음 거는 2개 이상.
시각화를 해서 역으로 가보자

각 집을 털고 안털고 상태에서 가장 많이 훔칠 수 있는 상태들을 추적
0 2 2 3
1 1 4 4
-> 답
//이건 안됨. 격칸으로 한다고 최대를 알 수 있는 게 아님
        //최대를 계속 추적해 나가야함.
        // int[] status1 = new int[n];
        // int[] status2 = new int[n];
        // status1[0] = nums[0]; //0번집 털기
        // status2[0] = 0;//0번 안털기
        // status1[1] = status[0]; //0번 털었으니까 1번 못털음
        // status1[1] = nums[1];
        // for (int i = 2; i < n; i++) {
        //     status1[i] = status1[i-2] + nums[i];
        //     status2[i] = status
        // }
        //전칸에서 했던 상태의 최대랑, 안한 상태의 최대랑 비교해서 두개의 상태를 가져가야함
        //왜냐하면 상태 하나만 가지고 있으면 전에 훔쳤는지 추적이 제대로 안된다
 */