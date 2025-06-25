class TimeMap {
    Map<String, List<String[]>> map;
    public TimeMap() {
        //int prev = -1;
        map = new HashMap<>(); //<key, [value, time]>
        //ex) foo, [bar, 1]
        //  foo, [bar2, 4]
    }
    
    public void set(String key, String value, int timestamp) {
        if (map.containsKey(key)) { //있으면 추가
            map.get(key).add(new String[] {value, Integer.toString(timestamp)});
        }else { //없으면 키넣어주고 추가해주기
            map.put(key, new ArrayList<>());
            map.get(key).add(new String[] {value, Integer.toString(timestamp)});
        }
    }
    
    public String get(String key, int timestamp) {
        List<String[]> got = map.get(key);// foo, <{bar, 1}, {bar2,4}>
        if (got==null) {return "";}
        String ans = new String();
        int left = 0;
        int right = got.size() - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (Integer.parseInt(got.get(mid)[1]) <= timestamp) {
                ans = got.get(mid)[0];
                left = mid + 1;
            }else {
                right = mid - 1;
            }
            
        }
        return ans;
    }
}
/**
timeMap안에 자료구조 필요. 콜옵
hashmap?
timestamp는 오름차순 -> binary search 가능? 무슨 관계지
binary search는 정렬되어있으면 사용가능. 맞아. 
get(String key, int timestamp)하면
    가장최근에 get호출했던 timestam부터;.. <<이때 bs로 지점찾아서 거기부터 쭉 출력하면 되겠네
 */
/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */

/**

set: foo bar 1
get: foo 1 -> return bar
get: foo 3 -> return bar
set: foo bar2 4
get: foo 4 -> return bar2 (4, 4)
get: foo 5 -> return bar2 (4, 5)

 */
