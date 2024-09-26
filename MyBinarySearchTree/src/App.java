public class App {
    public static void main(String[] args) throws Exception {
        MyBinarySearchTree<Integer> bst = new MyBinarySearchTree<>();

        // Test insertion
        System.out.println("Inserting values: 50, 30, 20, 40, 70, 60, 80");
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        // Test inorder traversal
        System.out.println("Inorder traversal:");
        bst.inorder(); // Expected: 20, 30, 40, 50, 60, 70, 80

        // Test search
        System.out.println("Searching for 40: " + bst.search(40)); // Expected: true
        System.out.println("Searching for 90: " + bst.search(90)); // Expected: false

        // Test finding minimum and maximum
        System.out.println("Minimum value: " + bst.findMin()); // Expected: 20
        System.out.println("Maximum value: " + bst.findMax()); // Expected: 80

        // Test height
        System.out.println("Height of tree: " + bst.height()); // Expected: Height value depending on the structure

        // Test deletion
        System.out.println("Deleting 20 (leaf node)");
        bst.delete(20);
        System.out.println("Inorder traversal after deleting 20:");
        bst.inorder(); // Expected: 30, 40, 50, 60, 70, 80

        System.out.println("Deleting 30 (node with one child)");
        bst.delete(30);
        System.out.println("Inorder traversal after deleting 30:");
        bst.inorder(); // Expected: 40, 50, 60, 70, 80

        System.out.println("Deleting 50 (node with two children)");
        bst.delete(50);
        System.out.println("Inorder traversal after deleting 50:");
        bst.inorder(); // Expected: 40, 60, 70, 80

        // Test isBST
        System.out.println("Is the tree a BST? " + bst.isBST()); // Expected: true

        // Optional: Test postorder and preorder
        System.out.println("Postorder traversal:");
        bst.postorder(); // Expected order based on remaining elements

        System.out.println("Preorder traversal:");
        bst.preorder(); // Expected order based on remaining elements
    }
}
