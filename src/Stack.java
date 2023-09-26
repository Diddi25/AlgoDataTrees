public class Stack<K> {
    private Node[] dynamicStack = new Node[14];
    private int dynamicStackPointer = 0;
    public void push(Node value) {
        if (dynamicStackPointer == dynamicStack.length - 1) {
            copyItemsToNewStack(new Node[dynamicStack.length*2]);
        }
        dynamicStack[dynamicStackPointer] = value;
        dynamicStackPointer++;
    }
    public Node pop() {
        if (this.isEmpty()) {
            return null;
        }
        determineIfStackShouldShrink();
        Node popNumber = dynamicStack[--dynamicStackPointer];
        dynamicStack[dynamicStackPointer] = null;
        return popNumber;
    }
    private void determineIfStackShouldShrink() {
        if (dynamicStack.length - dynamicStackPointer >= 20) {
            copyItemsToNewStack(new Node[dynamicStack.length - 20]);
        }
        return;
    }
    private void copyItemsToNewStack(Node[] newDynamicStack) {
        if (dynamicStackPointer >= 0) {
            for (int i = 0; i < dynamicStackPointer - 1; i++) {
                newDynamicStack[i] = dynamicStack[i];
            }
        }
        dynamicStack = newDynamicStack;
    }

    public boolean isEmpty() {
        return dynamicStackPointer == 0;
    }
}
