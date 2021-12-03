import java.util.Objects;

public class EvaluateExpressionTree {

    public static int evalTree(BinaryTreeNode<String> root) {
        /** Base case : When root is empty **/
        if (Objects.isNull(root)) {
            return 0;
        }

        /** When node is leaf node **/
        if (isLeafNode(root)) {
            return getIntegerValue(root.getData());
        }

        /** Evaluate left and right subtree recursively **/
        int leftSubTreeValue = evalTree(root.getLeft()),
                rightSubTreeValue = evalTree(root.getRight());

        /** Perform operation on left and right subtree **/
        return performOperation(root.getData(), leftSubTreeValue, rightSubTreeValue);
    }

    public static String printExpression(BinaryTreeNode<String> root) {
        /** Base case : When root is empty **/
        if (Objects.isNull(root)) {
            return "";
        }

        /** When node is leaf node **/
        if (isLeafNode(root)) {
            return root.getData();
        }

        /** Evaluate left and right subtree recursively **/
        String leftSubTreeValue = printExpression(root.getLeft()),
                rightSubTreeValue = printExpression(root.getRight());

        /** Perform print on left and right subtree **/
        return printOperation(root.getData(), leftSubTreeValue, rightSubTreeValue);
    }

    private static boolean isLeafNode(BinaryTreeNode<String> node) {
        /** If both children are null then its leaf node **/
        return Objects.isNull(node.getLeft()) &&
                Objects.isNull(node.getRight());

    }

    private static int getIntegerValue(String data) {
        /** Convert String to Integer **/
        return Integer.parseInt(data);
    }

    private static int performOperation(String operator, int operand1, int operand2) {
        /** Perform arithmetic operation **/
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "x":
                return operand1 * operand2;
            case "÷":
                return operand1 / operand2;
            default:
                throw new UnknownError("Unknown operator " + operator);
        }
    }

    private static String printOperation(String operator, String operand1, String operand2) {
        /** Perform print operation operation **/
        switch (operator) {
            case "+":
                return String.format("(%s + %s)",operand1,operand2);
            case "-":
                return String.format("(%s - %s)",operand1,operand2);
            case "x":
                return String.format("(%s x %s)",operand1,operand2);
            case "÷":
                return String.format("(%s ÷ %s)",operand1,operand2);
            default:
                throw new UnknownError("Unknown operator " + operator);
        }
    }
}