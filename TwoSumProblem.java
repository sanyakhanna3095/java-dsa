import java.util.*;

public class TwoSumProblem {
    public static int[] twoSum(int[] arr, int trgt) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int complement = trgt - arr[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(arr[i], i);
        }

        // Return empty array if no pair found
        return new int[]{};
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        //Take user input for array size and array elements
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        System.out.println("Enter target sum: ");
        int trgt=sc.nextInt();
        int[] result = twoSum(arr, trgt);

        if (result.length == 2) {
            System.out.println("Indices: " + result[0] + ", " + result[1]);
        }
        else {
            System.out.println("No valid pair found.");
        }
    }
}
