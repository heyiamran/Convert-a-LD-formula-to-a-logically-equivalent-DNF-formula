// Zhuoran Bi 20217231
public class Calculate {
    public static ConstructTree.Node calculateBinaryTree(ConstructTree.Node root) {

        ConstructTree.Node t = new ConstructTree.Node();
        t.value = "T";
        t.leftChild = null;
        t.rightChild = null;
        ConstructTree.Node f = new ConstructTree.Node();
        f.value = "F";
        f.leftChild = null;
        f.rightChild = null;
        for (int i = 0; i < 5; i++) {
            if (root != null) {
                //->
                if (root.value.equals("-")) {
                    root.value = "|";
                    ConstructTree.Node node = new ConstructTree.Node();
                    ConstructTree.Node temp = root.leftChild;
                    root.leftChild = node;
                    node.value = "~";
                    node.rightChild = temp;
                }
                //2.1
                else if (root.value.equals("~") && root.rightChild.value.equals("~") && !root.rightChild.rightChild.value.equals("~")) {
                    ConstructTree.Node temp = root.rightChild.rightChild;
                    root.value = temp.value;
                    root.rightChild = null;
                    root.leftChild = null;
                } else if (root.value.equals("~") && root.rightChild.value.equals("~") && root.rightChild.rightChild.value.equals("~")) {
                    ConstructTree.Node temp = root.rightChild.rightChild;
                    root = temp;
                }
                //2.2
                else if (root.value.equals("~") && root.rightChild.value.equals("&") && !Operators.isOperatorString(root.rightChild.rightChild.value) && !Operators.isOperatorString(root.rightChild.leftChild.value)) {
                    ConstructTree.Node leftTemp = root.rightChild.leftChild;
                    ConstructTree.Node rightTemp = root.rightChild.rightChild;
                    root.value = "|";
                    ConstructTree.Node notL = new ConstructTree.Node();
                    notL.value = "~";
                    notL.rightChild = leftTemp;
                    ConstructTree.Node notR = new ConstructTree.Node();
                    notR.value = "~";
                    notR.rightChild = rightTemp;
                    root.leftChild = notL;
                    root.rightChild = notR;
                } else if (root.value.equals("~") && root.rightChild.value.equals("|") && !Operators.isOperatorString(root.rightChild.rightChild.value) && !Operators.isOperatorString(root.rightChild.leftChild.value)) {
                    ConstructTree.Node leftTemp = root.rightChild.leftChild;
                    ConstructTree.Node rightTemp = root.rightChild.rightChild;
                    root.value = "&";
                    ConstructTree.Node notL = new ConstructTree.Node();
                    notL.value = "~";
                    notL.rightChild = leftTemp;
                    ConstructTree.Node notR = new ConstructTree.Node();
                    notR.value = "~";
                    notR.rightChild = rightTemp;
                    root.leftChild = notL;
                    root.rightChild = notR;
                }
                // put ~  into node
                else if (root.value.equals("~") && !Operators.isOperatorString(root.rightChild.value)) {
                    ConstructTree.Node temp = new ConstructTree.Node();
                    temp.value = "~" + root.rightChild.value;
                    root.value = temp.value;
                    root.rightChild = null;
                    root.leftChild = null;

                }
                // step 3
                else if (root.value.equals("&") && root.leftChild.value.equals("|") && !Operators.isOperatorString(root.rightChild.value) && !Operators.isOperatorString(root.leftChild.rightChild.value) && !Operators.isOperatorString(root.leftChild.leftChild.value)) {
                    root.value = "|";
                    ConstructTree.Node tempR = root.rightChild;
                    ConstructTree.Node tempLL = root.leftChild.leftChild;
                    ConstructTree.Node tempLR = root.leftChild.rightChild;
                    ConstructTree.Node newL = new ConstructTree.Node();
                    ConstructTree.Node newR = new ConstructTree.Node();

                    newL.value = "&";
                    newL.leftChild = tempLL;
                    newL.rightChild = tempR;

                    newR.value = "&";
                    newR.leftChild = tempLR;
                    newR.rightChild = tempR;

                    root.leftChild = newL;
                    root.rightChild = newR;
                } else if (root.value.equals("&") && root.rightChild.value.equals("|") && !Operators.isOperatorString(root.leftChild.value) && !Operators.isOperatorString(root.rightChild.rightChild.value) && !Operators.isOperatorString(root.rightChild.leftChild.value)) {
                    root.value = "|";
                    ConstructTree.Node tempL = root.leftChild;
                    ConstructTree.Node tempRL = root.rightChild.leftChild;
                    ConstructTree.Node tempRR = root.rightChild.rightChild;
                    ConstructTree.Node newL = new ConstructTree.Node();
                    ConstructTree.Node newR = new ConstructTree.Node();

                    newL.value = "&";
                    newL.leftChild = tempL;
                    newL.rightChild = tempRL;

                    newR.value = "&";
                    newR.leftChild = tempL;
                    newR.rightChild = tempRR;

                    root.leftChild = newL;
                    root.rightChild = newR;
                }
                //4.1,2
                else if (root.value.equals("|") && root.rightChild.value.equals(root.leftChild.value) && !Operators.isOperatorString(root.rightChild.value) && !Operators.isOperatorString(root.leftChild.value)) {
                    root = root.rightChild;
                } else if (root.value.equals("&") && root.rightChild.value.equals(root.leftChild.value) && !Operators.isOperatorString(root.rightChild.value) && !Operators.isOperatorString(root.leftChild.value)) {
                    root = root.rightChild;
                }
                //4.3,4
                else if (root.value.equals("|") && root.leftChild.value.equals("~") && root.leftChild.rightChild.value.equals(root.rightChild.value)) {
                    root = t;
                } else if (root.value.equals("|") && root.rightChild.value.equals("~") && root.rightChild.rightChild.value.equals(root.leftChild.value)) {
                    root = t;
                } else if (root.value.equals("&") && root.leftChild.value.equals("~") && root.leftChild.rightChild.value.equals(root.rightChild.value)) {
                    root = f;
                } else if (root.value.equals("&") && root.rightChild.value.equals("~") && root.rightChild.rightChild.value.equals(root.leftChild.value)) {
                    root = f;
                }
                // 4.5,6
                else if (root.value.equals("~T")) {
                    root = f;
                }
                else if (root.value.equals("~F")) {
                    root = t;
                }

                else if (root.value.equals("|") && !Operators.isOperatorString(root.leftChild.value) && root.rightChild.value.equals("T")) {
                    root = t;
                } else if (root.value.equals("|") && !Operators.isOperatorString(root.rightChild.value) && root.leftChild.value.equals("T")) {
                    root = t;
                } else if (root.value.equals("&") && !Operators.isOperatorString(root.rightChild.value) && root.leftChild.value.equals("T")) {
                    root = root.rightChild;
                } else if (root.value.equals("&") && !Operators.isOperatorString(root.leftChild.value) && root.rightChild.value.equals("T")) {
                    root = root.leftChild;
                } else if (root.value.equals("|") && !Operators.isOperatorString(root.leftChild.value) && root.rightChild.value.equals("F")) {
                    root = root.leftChild;
                } else if (root.value.equals("|") && !Operators.isOperatorString(root.rightChild.value) && root.leftChild.value.equals("F")) {
                    root = root.rightChild;
                } else if (root.value.equals("&") && !Operators.isOperatorString(root.rightChild.value) && root.leftChild.value.equals("F")) {
                    root = f;
                } else if (root.value.equals("&") && !Operators.isOperatorString(root.leftChild.value) && root.rightChild.value.equals("F")) {
                    root = f;
                }
                calculateBinaryTree(root.rightChild);
                calculateBinaryTree(root.leftChild);

            }
        }
        return root;
    }
}
