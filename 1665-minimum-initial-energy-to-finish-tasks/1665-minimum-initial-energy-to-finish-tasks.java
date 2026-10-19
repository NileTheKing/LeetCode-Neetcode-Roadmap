class Solution {
    public int minimumEffort(int[][] tasks) {
    
        Arrays.sort(tasks, (o1, o2) -> Integer.compare(o2[1] - o2[0], o1[1] - o1[0]));//오름차순정렬
        
        int initialEnergy = 0;
        int currentEnergy = 0;
        for (int[] t : tasks) {
            int actual = t[0];
            int minimum = t[1];

            int gap = minimum - currentEnergy > 0 ? minimum - currentEnergy : 0;

            currentEnergy += gap;
            initialEnergy += gap;

            currentEnergy -= actual;
        }

        return initialEnergy;
    }
}