class Solution {
    public String largestNumber(int[] nums) {
        PriorityQueue<String> pq = new PriorityQueue<>((o1, o2) -> {
            String o1o2 = o1 + o2;
            String o2o1 = o2 + o1;
            return o2o1.compareTo(o1o2);
        });
        for (int n : nums) {
            pq.offer(String.valueOf(n));
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            sb.append(pq.poll());
        }
        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }
}
/**
100! 안됨
10^2^4까지 가능..
첫자리가 가장높은게 이득..
dp? 아니다.
그러면 pq를 만들어가지고..
pq정렬조건을 이제 ..하는거지. 대신 int말고 String으로 넣어둬가지고.

1113:11 1311
1113 11:1113

 */