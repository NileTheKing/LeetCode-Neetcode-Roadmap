class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        //피벗찾기
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        int pivot = left;
        left = 0;
        right = nums.length - 1;

        if (target >= nums[pivot] && target <= nums[right]) {
            left = pivot;
        }else {
            right = pivot - 1;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            //System.out.println("mid:" + mid);

            if (nums[mid] == target) return mid;

            if (nums[mid] > target) {
                //mid too big
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }

        return -1;
    }
}

/**
target의 index찾기
nums는 pivotted array

전에 문제는 최솟값
지금 문제는 타겟값

정렬할 pivot을 찾은 다음에 bs해야하나?

아무튼 현재의 mid 값을 target과 비교햐면서 탐색 범위를 줄여나감.
기존 bs에서는 mid가 target보다 크면 mid를 줄여나가는 방식.
만약 7이 0보다 크니까




 */

