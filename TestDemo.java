public class TestDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode root = binaryTree.buildTree();
        binaryTree.preOrderTraversal(root);
        System.out.println();
        binaryTree.inOrderTraversal(root);
        System.out.println();
        binaryTree.postOrderTraversal(root);
        System.out.println();
        int ret = binaryTree.getSize(root);
        System.out.println(ret);
        binaryTree.getSize1(root);
        System.out.println(BinaryTree.size);
        int tmp = binaryTree.getLeafSize2(root);
        System.out.println(tmp);
    }
}
