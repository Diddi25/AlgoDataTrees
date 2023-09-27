public class Stack<K extends Comparable<K>, V> {
    private Node<K,V>[] dynamicStack = new Node[14];
    private int dynamicStackPointer = 0;
    public void push(Node<K,V> value) {
        if (dynamicStackPointer == dynamicStack.length - 1) {
            copyItemsToNewStack(new Node[dynamicStack.length*2]);
        }
        dynamicStack[dynamicStackPointer] = value;
        dynamicStackPointer++;
    }
    public Node<K,V> pop() {
        if (this.isEmpty()) {
            return null;
        }
        determineIfStackShouldShrink();
        Node<K,V> popNode = dynamicStack[--dynamicStackPointer];
        dynamicStack[dynamicStackPointer] = null;
        return popNode;
    }
    private void determineIfStackShouldShrink() {
        if (dynamicStack.length - dynamicStackPointer >= 20) {
            copyItemsToNewStack(new Node[dynamicStack.length - 20]);
        }
    }
    private void copyItemsToNewStack(Node<K,V>[] newDynamicStack) {
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
