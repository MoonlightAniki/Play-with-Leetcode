import java.util.Random;

// 215. Kth Largest Element in an Array
// https://leetcode.com/problems/kth-largest-element-in-an-array/description/
public class Solution215 {
    private Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        int l = 0;
        int r = nums.length - 1;
        return findKthLargest(nums, l, r, k);
    }

    private int findKthLargest(int[] nums, int l, int r, int k) {
        if (l > r) {
            return -1;
        }
        int p = partition(nums, l, r);
        if (p == k - 1) {
            return nums[p];
        } else if (p < k - 1) {
            return findKthLargest(nums, p + 1, r, k);
        } else { // p > k - 1
            return findKthLargest(nums, l, p - 1, k);
        }
    }

    private int partition(int[] arr, int l, int r) {
        swap(arr, l, random.nextInt(r - l + 1) + l);
        int v = arr[l];
        int p = l;//arr[l+1...p]>v
        int i = l + 1;//arr[p+1...i)<=v;
        for (; i <= r; ++i) {
            if (arr[i] > v) {
                swap(arr, p + 1, i);
                ++p;
            }
        }
        swap(arr, l, p);
        return p;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Solution215 s = new Solution215();
        int[] nums1 = {3, 2, 1, 5, 6, 4};
        System.out.println(s.findKthLargest(nums1, 2));

        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(s.findKthLargest(nums2, 4));
    }
}
