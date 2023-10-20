// @algorithm @lc id=100232 lang=java 
// @title search-rotate-array-lcci
package _____10_03_Search_Rotate_Array_LCCI;
// @test([15,16,19,20,25,1,3,4,5,7,10,14],5)=8
// @test([15,16,19,20,25,1,3,4,5,7,10,14],11)=-1
public class Solution {
    public int search(int[] arr, int target) {
        if (arr[0] == target) {
            return 0;
        }

        int ans = -1;
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int middle = left + (right - left >> 1);
            if (arr[middle] == target) {
                ans = middle;
                break;
            } else if (arr[middle] == arr[left] && arr[middle] == arr[right]) {
                left++;
            } else if (arr[middle] > target) {
                if (arr[left] <= arr[middle] && arr[left] > target) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            } else {
                if (arr[middle] <= arr[right] && arr[right] < target) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
        }

        while (ans > 0 && arr[ans - 1] == target) {
            ans--;
        }
        return ans;
    }
}