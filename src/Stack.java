public class Stack<K> {

    private int[] dynamicStack = new int[4];
    private int dynamicStackPointer = 0;

    public void push(int value) {
        if (dynamicStackPointer == dynamicStack.length - 1) {
            copyItemsToNewStack(new int[dynamicStack.length + 5]);
        }
        dynamicStack[dynamicStackPointer] = value;
        dynamicStackPointer++;
    }

    public int pop() {
        if (dynamicStack.length == 0) {
            return 0;
        }
        determineIfStackShouldShrink();
        int popNumber = dynamicStack[--dynamicStackPointer];
        dynamicStack[dynamicStackPointer] = 0;
        return popNumber;
    }

    private void determineIfStackShouldShrink() {
        if (dynamicStack.length - dynamicStackPointer >= 20) {
            copyItemsToNewStack(new int[dynamicStack.length - 20]);
        }
        return;
    }

    private void copyItemsToNewStack(int[] newDynamicStack) {
        if (dynamicStackPointer >= 0)
            System.arraycopy(dynamicStack, 0, newDynamicStack, 0, dynamicStackPointer);
        dynamicStack = newDynamicStack;
    }

}
