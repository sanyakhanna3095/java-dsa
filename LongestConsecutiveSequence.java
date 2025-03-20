import java.util.*;

public class LongestConsecutiveSequence {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        //Take user input for array size and array elements
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        //make a call to method sol to get the list of desired subarrays and store the result
       sol(arr);
    }

    public static int sol(int[] arr) {
        if (arr.length == 0) return 0;

        HashSet<Integer> set = new HashSet<>();
        for (int i=0;i<arr.length;i++) {
            set.add(arr[i]);
        }

        int res = 0;

        for (int num : set) {
            // Check if it's the start of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                res = Math.max(res, currentStreak);
            }
        }

        return res;
    }
}
