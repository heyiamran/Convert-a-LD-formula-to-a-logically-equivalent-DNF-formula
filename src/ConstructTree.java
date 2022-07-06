// Zhuoran Bi 20217231
import static java.lang.Character.isLetter;

public class ConstructTree {

    static class Node {
        Node leftChild;
        Node rightChild;
        String value;
    }
    static StringBuilder stringBuilder = new StringBuilder(50);

    public static String RPN(String str) {
        char[] c = str.toCharArray(); // string to charArray
        int pre = 0;
        boolean charactor; // if it is a letter or not.
        int len = c.length;
        int bracket = 0; // the number of left brackets
        String result = "";
        MyStack letter = new MyStack();
        MyStack<Character> operators = new MyStack<>();// stack hold operators.

        for (int i = 0; i < len; ) {
            pre = i;
            charactor = Boolean.FALSE;

            while (i < len && !Operators.isOperator(c[i])) { //if it is not an operator.
                i++;
                charactor = Boolean.TRUE;
            }

            if (charactor) {
                letter.push(str.substring(pre, i)); //put letter to output stack
            } else {
                char o = c[i++];
                if (o == '[') {
                    bracket++;
                }
                if (bracket > 0) {
                    if (o == ']') {
                        while (!operators.isEmpty()) {
                            char top = operators.pop();
                            if (top == '[') { // break if [] are already in the stack
                                break;
                            }
                            letter.push(top);
                        }
                        bracket--;
                    } else {
                        while (!operators.isEmpty() && operators.peek() != '['
                                && Operators.cmp(o, operators.peek()) <= 0) {
                            letter.push(operators.pop());
                        }
                        operators.push(o);
                    }
                } else {
                    while (!operators.isEmpty() && Operators.cmp(o, operators.peek()) <= 0) {
                        letter.push(operators.pop());
                    }
                    operators.push(o);
                }
            }

        }
        // when it finished, put all things in letter stack.
        while (!operators.isEmpty()) {
            letter.push(operators.pop());
        }

        while (!letter.isEmpty()) {
            result = letter.pop() + result;
        }
        return result;
    }

    public static Node createBinaryTree(String str) {
        MyStack<Node> nodeStack = new MyStack<>();
        for (int i = 0; i < str.length(); i++) {
            String s = str.substring(i, i + 1);
            char s1 = str.charAt(i);
            Node node = new Node();
            node.value = s;

            if (isLetter(s1)) {

                nodeStack.push(node);
                // if it is operators.
            } else if (Operators.isOperatorString(s)) {

                // pop two.
                Node rightNode = nodeStack.pop();
                Node leftNode;
                if (s1 == '~') {
                    //node.leftChild = null;
                } else {
                    leftNode = nodeStack.pop();
                    node.leftChild = leftNode;
                }
                node.rightChild = rightNode;
                nodeStack.push(node);
            }
        }
        return nodeStack.pop();
    }

    static String printMathExpression(Node root) {
        if (root != null) {
            if (Operators.isOperatorOutput(root.value) && !root.value.equals("~")) {
                stringBuilder.append("[ ");
            }

            if (root.value.equals("~")) {
                stringBuilder.append(root.value);
                stringBuilder.append("[ ");
            }

            printMathExpression(root.leftChild);

            if (root.value.equals("~")) {
                stringBuilder.append("] ");
            }

            if (Operators.isOperatorOutput(root.value) && !root.value.equals("~")) {
                stringBuilder.append("] ");
            }
            if (!root.value.equals("~")) {
                stringBuilder.append(root.value);
                stringBuilder.append(" ");
            }

            if (Operators.isOperatorOutput(root.value) && !root.value.equals("~")) {
                stringBuilder.append("[ ");
            }

            printMathExpression(root.rightChild);

            if (Operators.isOperatorOutput(root.value) && !root.value.equals("~")) {
                stringBuilder.append("] ");
            }

        }
        String s = stringBuilder.toString();
        return s ;
    }
}
