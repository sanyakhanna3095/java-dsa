import java.util.*;

public class SumZeroSubarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Take user input for array size and array elements
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        //make a call to method sol to get the list of desired result
        sol(arr);
    }

    public static List<int[]> sol(int[] arr){
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<int[]> l = new ArrayList<>();
        int sum=0;
        // Initialize HashMap with sum = 0 at index -1 (to handle subarrays from start)
        map.put(0, new ArrayList<>());
        map.get(0).add(-1);

        // Traverse array and track cumulative sum
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // If sum is found in HashMap, there exists a zero-sum subarray
            if (map.containsKey(sum)) {
                for (int startIndex : map.get(sum)) {
                    l.add(Arrays.copyOfRange(arr, startIndex + 1, i + 1));
                }
            }

            // Store current sum and its index
            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }

        return l;
    }
}


/*
I/P ->
11
4
2
-3
1
6
-3
-4
2
2
-4
6

O/P ->
[2, -3, 1]
[1, 6, -3, -4]
[-4, 2, 2]
[1, 6, -3, -4, 2, 2, -4]
[2, 2, -4]
 */