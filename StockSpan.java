import java.util.Scanner;
import java.util.Stack;

class StockSpan {
    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // Pop elements from stack while stack is not empty and price at stack top is less than or equal to current price
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            // Calculate span
            span[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());

            // Push current index onto stack
            stack.push(i);
        }

        return span;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Take user input for size of array and elements of array itself
        System.out.print("Enter the number of days: ");
        int n = sc.nextInt();

        int[] prices = new int[n];
        System.out.println("Enter " + n + " stock prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        int[] span = calculateSpan(prices);

        System.out.println("Stock Span Values:");
        for (int i=0;i<span.length;i++) {
            System.out.print(span[i] + " ");
        }

    }
}
