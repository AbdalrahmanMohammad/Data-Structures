public class MyBinarySearchTree<T extends Comparable<T>> {
    private Node<T> root; // Root of the BST

    public MyBinarySearchTree() {
        root = null;
    }

    public void insert(T value) {
        root = insertRec(root, value);
    }

    private Node<T> insertRec(Node<T> root, T value) {
        if (root == null) {
            return new Node<>(value);
        }
        if (value.compareTo(root.getValue()) > 0) {
            root.setRight(insertRec(root.getRight(), value));
        } else if (value.compareTo(root.getValue()) < 0) {
            root.setLeft(insertRec(root.getLeft(), value));
        }
        return root;
    }

    public boolean search(T value) {
        return searchRec(root, value);
    }

    private boolean searchRec(Node<T> root, T value) {
        if (root == null)
            return false;
        if (value.compareTo(root.getValue()) == 0)
            return true;
        if (value.compareTo(root.getValue()) > 0) {
            return searchRec(root.getRight(), value);
        } else {
            return searchRec(root.getLeft(), value);
        }
    }

    public void inorder() {
        inorder(root);
    }

    private void inorder(Node<T> root) {
        if (root == null)
            return;
        inorder(root.getLeft());
        System.out.println(root.getValue() + " ");
        inorder(root.getRight());
    }

    public void postorder() {
        postorder(root);
    }

    private void postorder(Node<T> root) {
        if (root == null)
            return;
        postorder(root.getLeft());
        postorder(root.getRight());
        System.out.println(root.getValue() + " ");
    }

    public void preorder() {
        preorder(root);
    }

    private void preorder(Node<T> root) {
        if (root == null)
            return;
        System.out.println(root.getValue() + " ");
        preorder(root.getLeft());
        preorder(root.getRight());
    }

    public void delete(T value) {
        root = deleteRec(root, value);
    }

    private Node<T> deleteRec(Node<T> root, T value) {
        if (root == null)
            return null;
        if (value.compareTo(root.getValue()) > 0) {
            root.setRight(deleteRec(root.getRight(), value));
        } else if (value.compareTo(root.getValue()) < 0) {
            root.setLeft(deleteRec(root.getLeft(), value));
        } else {// it is this node
            if (root.getLeft() == null && root.getRight() == null)// no childs
            {
                return null;
            } else if (root.getLeft() == null) {// has only right
                return root.getRight();
            } else if (root.getRight() == null) {// has only left
                return root.getLeft();
            } else {// has two childs
                Node<T> temp = root.getRight(), prev = root;
                while (temp.getLeft() != null) {
                    prev = temp;
                    temp = temp.getLeft();
                }
                if (prev.getRight() != temp) {
                    prev.setLeft(temp.getRight());
                    temp.setRight(root.getRight());
                    temp.setLeft(root.getLeft());
                } else {
                    temp.setLeft(root.getLeft());
                }
                return temp;
            }
        }
        return root;
    }

    public T findMin() {
        return findMinRec(root);
    }

    private T findMinRec(Node<T> root) {
        if (root.getLeft() == null)
            return root.getValue();
        else
            return findMinRec(root.getLeft());
    }

    public T findMax() {
        return findMaxRec(root);
    }

    private T findMaxRec(Node<T> root) {
        if (root.getRight() == null)
            return root.getValue();
        else
            return findMaxRec(root.getRight());
    }

    public int height() {
        return heightOfTree(root);
    }

    private int heightOfTree(Node<T> root) {
        if (root == null)
            return -1;
        if (root.getLeft() == null && root.getRight() == null)// not really important
            return 0;
        return 1 + Math.max(heightOfTree(root.getLeft()), heightOfTree(root.getRight()));
    }

    public boolean isBST() {
        return isBSTRec(root, null, null);
    }

    private boolean isBSTRec(Node<T> node, T min, T max) {
        if (node == null) {
            return true;
        }
        if (min != null && node.getValue().compareTo(min) <= 0) {
            return false;
        }
        if (max != null && node.getValue().compareTo(max) >= 0) {
            return false;
        }
        return isBSTRec(node.getLeft(), min, node.getValue()) && isBSTRec(node.getRight(), node.getValue(), max);
    }

}
