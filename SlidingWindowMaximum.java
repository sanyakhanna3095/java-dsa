import java.util.*;

class SlidingWindowMaximum {
    public static int[] sol(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];

        int n = nums.length;
        // Array to store max values
        int[] result = new int[n - k + 1];

        // Deque to store indices
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // Remove elements that are out of the window
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove smaller elements in the deque as they are useless
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            // Add current element index to deque
            deque.offerLast(i);

            // Store the max value for the current window in result array
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Take user input for size of array and elements itself
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        //Take user input for window size
        System.out.print("Enter the window size (k): ");
        int k = sc.nextInt();

        //make a call to method sol to find max element in each sliding window
        int[] maxValues = sol(nums, k);

        System.out.println("Sliding Window Maximum: " + Arrays.toString(maxValues));
    }
}
