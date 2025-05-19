class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int length = position.length;
        Point[] array = new Point[length];
        for (int i = 0; i < length; i++) {
            array[i] = new Point(position[i], speed[i]);
        }
        Arrays.sort(array, (a, b) -> b.pos - a.pos); //array는 내림차순. 위치기준. 위치가 target이랑 가까운 놈부터

        Stack<Double> stack = new Stack<>(); //fleet의 time을 추적
        for (int i = 0; i < length; i++) {
            double time = (double)(target - array[i].pos) / array[i].speed;
            if (!stack.isEmpty() && time <= stack.peek()) { // 이번놈이 전에 놈(오른쪽)보다 빠르다면. 추월안되므 //군집으로 만들어야함.
                //전에 놈이 더 느리니까 속도는 유지
                continue;
            }
            
            //그렇지 않다면 이번놈이 전에놈보다 느리다면 다른군집으로 추가
            
            stack.push(time);
            
        }

        return stack.size();
    }
    class Point {
        int pos;
        int speed;

        Point(int pos, int speed) {
            this.pos = pos;
            this.speed = speed;
        }
    }
}