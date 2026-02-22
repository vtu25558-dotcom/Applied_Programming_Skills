import java.util.Deque;
import java.util.LinkedList;

class Lcs {
    public int longestSubarray(int[] nums, int limit) {
        // Deques to track max and min values in the current window
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();
        int left = 0, result = 0;

        for (int right = 0; right < nums.length; right++) {
            int num = nums[right];

            // Maintain decreasing maxDeque
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] < num) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(right);

            // Maintain increasing minDeque
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] > num) {
                minDeque.pollLast();
            }
            minDeque.offerLast(right);

            // Shrink window if diff exceeds limit
            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > limit) {
                left++;
                if (maxDeque.peekFirst() < left) maxDeque.pollFirst();
                if (minDeque.peekFirst() < left) minDeque.pollFirst();
            }

            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}