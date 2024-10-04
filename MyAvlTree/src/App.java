public class App {
    public static void main(String[] args) throws Exception {
        MyAvlTree<Integer> avlTree = new MyAvlTree<>();

        // Insert values into the AVL tree
        int[] valuesToInsert = { 40, 20, 60, 10, 30, 50, 70, 5, 15, 25, 35, 45, 55, 65, 75, 80, 85, 90, 95};

        System.out.println("Inserting values:");
        for (int value : valuesToInsert) {
            // System.out.print(value + " ");
            avlTree.insert(value);
            // avlTree.inorder(); // Print the in-order traversal after each insertion
            System.out.println(); // New line for better readability
        }

        System.out.println("\nFinal in-order traversal of AVL tree:");
        avlTree.inorder(); // Print the final in-order traversal
        // System.out.println();
        // avlTree.postorder();
        // System.out.println();
        // avlTree.preorder();
    }
}