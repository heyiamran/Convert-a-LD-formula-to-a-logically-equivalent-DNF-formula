// Zhuoran Bi 20217231
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Input:");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        ConstructTree.Node node;
        str = Process.preProcess(str);
        str = ConstructTree.RPN(str);
        node = ConstructTree.createBinaryTree(str);
        node = Calculate.calculateBinaryTree(node);
        str = ConstructTree.printMathExpression(node);
        str = Process.postProcess(str);
        System.out.println(str);
    }
}
