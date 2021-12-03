class EvaluateExpressionTreeTest {
    public static void main(String[] args) {
        BinaryTreeNode<String> root = new BinaryTreeNode<>("÷",
            new BinaryTreeNode<>("+",
            new BinaryTreeNode<>("7"),
            new BinaryTreeNode<>("x",
                new BinaryTreeNode<>("-",
                    new BinaryTreeNode<>("1233"), 
                    new BinaryTreeNode<>("2")),
                new BinaryTreeNode<>("5"))),
            new BinaryTreeNode<>("6")
          );

        System.out.println("Value is : " + EvaluateExpressionTree.evalTree(root));
        System.out.println("Expression is : " + EvaluateExpressionTree.printExpression(root));
    }
}