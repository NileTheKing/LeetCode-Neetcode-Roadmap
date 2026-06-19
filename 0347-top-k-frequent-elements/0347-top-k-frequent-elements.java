class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //빈도수 저장
        Map<Integer, Integer> freq = new HashMap<>(); //freq: <값, 빈도>
        for (int n : nums) freq.put(n, freq.getOrDefault(n, 0) + 1);
        //이제 큰거부터 꺼내기. 최대힙을 쓰면 좋을듯
        //int[] : {값, 빈도수}
        // PriorityQueue<int[]> maxHeap = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            if (minHeap.size() < k) minHeap.offer(new int[] {key, val});
            else if (minHeap.size() >= k && minHeap.peek()[1] < val) {
                minHeap.poll();
                minHeap.offer(new int[] {key, val});
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            int[] polled = minHeap.poll();
            ans.add(polled[0]);
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }
}