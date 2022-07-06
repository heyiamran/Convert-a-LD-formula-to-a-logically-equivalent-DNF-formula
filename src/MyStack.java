// Zhuoran Bi 20217231
import java.util.Arrays;
// I am going to use arrays to write my own stack.

class MyStack<T> {
    //Implementation array
    private Object[] stack;
    //the size
    private int size;

    MyStack() {
        //give it an initial capacity.
        stack = new Object[5];
    }


    public boolean isEmpty() {
        return size == 0;
    }

    //get the top element of the stack.
    public T peek() {
        T t = null;
        if (size > 0)
            t = (T) stack[size - 1];
        return t;
    }
    //push
    public void push(T t) {
        largeCapacity(size + 1);
        stack[size] = t;
        size++;
    }

    //pop
    public T pop() {
        T t = peek();
        if (size > 0) {
            stack[size - 1] = null;
            size--;
        }
        return t;
    }

    // extending the size of the stack.
    public void largeCapacity(int size) {
        int len = stack.length;
        if (size > len) {
            size = size * 3 / 2 + 1; // every time the size will extend 50%.
            stack = Arrays.copyOf(stack, size);
        }
    }

}
