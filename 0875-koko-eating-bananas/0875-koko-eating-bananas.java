class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        //구하고자 하는 것은 먹는 속도
        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();
        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            //조건 만족하는지 확인
            long time = 0;
            for (int pile : piles) {
                time += (pile + mid - 1) / mid;
                //System.out.println(time);
            }
            
            //시간 걸린거 보고 탐색 범위 줄임
            if (time <= h) { //시간 좀 걸렸으니까 시간당 먹는 양 줄여도 됨
                ans = mid;
                high = mid - 1;

            }else { //시간 많이걸렸으니까 먹는걸 늘려줘야함
                low = mid + 1;
            }
        }

        return ans;
    }
}