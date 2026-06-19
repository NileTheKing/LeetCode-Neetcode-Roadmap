class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //빈도수 저장
        Map<Integer, Integer> freq = new HashMap<>(); //freq: <값, 빈도>
        for (int n : nums) freq.put(n, freq.getOrDefault(n, 0) + 1);
        //이제 큰거부터 꺼내기. 최대힙을 쓰면 좋을듯
        //int[] : {값, 빈도수}
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            maxHeap.offer(new int[] {entry.getKey(), entry.getValue()});
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (maxHeap.isEmpty()) return new int[0]; //error
            int[] polled = maxHeap.poll();
            ans.add(polled[0]);
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }
}