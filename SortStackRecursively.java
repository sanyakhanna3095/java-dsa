import java.util.Stack;

public class SortStackRecursively {
    // Function to sort the stack using recursion
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            // Remove the top element
            int top = stack.pop();

            // Sort the remaining stack
            sortStack(stack);

            // Insert the popped element back in sorted order
            insertSorted(stack, top);
        }
    }

    // Helper function to insert an element in a sorted stack
    private static void insertSorted(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
        } else {
            int top = stack.pop();
            insertSorted(stack, element);
            stack.push(top);
        }
    }

    // Driver code to test the sorting function
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);
        stack.push(5);

        System.out.println("Original Stack: " + stack);

        sortStack(stack);

        System.out.println("Sorted Stack: " + stack);
    }
}
