import java.util.*;

public class GivenSumPair {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        //Take user input for array size and array elements
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter target sum: ");
        int trgt=sc.nextInt();
        //make a call to method sol to get the result
        sol(arr, trgt);
    }

    //method to find the pair with target sum
    public static boolean sol(int[] arr, int trgt){
        Set<Integer> set = new HashSet<>();
        System.out.println("Pairs with target sum: ");
        for (int i=0;i<arr.length;i++) {
            int remaining = trgt - arr[i];
            if (set.contains(remaining)) {
                System.out.println("(" + arr[i] + ", " + remaining + ")");
                return true;
            }
            set.add(arr[i]);
        }

        System.out.println("No pair found with sum " + trgt);
        return false;
    }
}


/*
I/P ->
10
3
21
23
12
4
10
16
5
27
2
Enter target sum:
14

O/P->
Pairs with target sum:
(10, 4)

 */