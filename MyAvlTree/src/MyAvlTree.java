import java.util.LinkedList;

public class MyAvlTree<T extends Comparable<T>> {
    private Node<T> root; // Root of the BST

    public MyAvlTree() {
        root = null;
    }

    public void insert(T value) {
        root = insertAtPosition(root, new Node<>(value));
    }

    private Node<T> insertAtPosition(Node<T> root, Node<T> value) {
        LinkedList<Node<T>> ls = new LinkedList();
        root = insertRec(root, value, ls);
        for (int i = 0; i < ls.size(); i++) {
            updateHeight(ls.get(i));
        }

        for (int i = 0; i < ls.size(); i++) {
            if (Math.abs(getBalance(ls.get(i))) >= 2) {
                Node<T> prev = (i == ls.size() - 1) ? null : ls.get(i + 1);
                Node<T> next = ls.get(i - 1);

                if (prev == null) {
                    this.root = balancing(value, next, ls.get(i));
                    return this.root;
                } else {
                    if (prev.getLeft() == ls.get(i)) {
                        prev.setLeft(balancing(value, next, ls.get(i)));
                    } else {
                        prev.setRight(balancing(value, next, ls.get(i)));
                    }
                }
            }
        }
        return root;
    }

    public Node<T> balancing(Node<T> value, Node<T> next, Node<T> theOne) {
        if (value.getValue().compareTo(theOne.getValue()) < 0)// r, rl
        {
            if (value.getValue().compareTo(next.getValue()) < 0)// r
            {
                return rotateRight(theOne);
            } else {// lr
                return rotateLeftRight(theOne);
            }
        } else {// l, lr
            if (value.getValue().compareTo(next.getValue()) < 0)// rl
            {
                return rotateRightLeft(theOne);
            } else {// l
                return rotateLeft(theOne);
            }
        }
    }

    private Node<T> insertRec(Node<T> root, Node<T> value, LinkedList<Node<T>> ls) {
        if (root == null) {
            return value;
        }
        ls.addFirst(root);
        if (value.getValue().compareTo(root.getValue()) > 0) {
            root.setRight(insertRec(root.getRight(), value, ls));
        } else if (value.getValue().compareTo(root.getValue()) < 0) {
            root.setLeft(insertRec(root.getLeft(), value, ls));
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
        inorder(this.root);
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

    private int getBalance(Node<T> node) {
        if (node == null) {
            return 0; // Balance factor of a null node is 0
        }
        int leftHeight = (node.getLeft() != null) ? node.getLeft().getHeight() : 0;
        int rightHeight = (node.getRight() != null) ? node.getRight().getHeight() : 0;
        return leftHeight - rightHeight;
    }

    private void updateHeight(Node<T> node) {
        if (node != null) {
            int leftHeight = height(node.getLeft());
            int rightHeight = height(node.getRight());
            node.setHeight(1 + Math.max(leftHeight, rightHeight));
        }
    }

    private int height(Node<T> node) {
        return node == null ? 0 : node.getHeight();
    }

    // Rotations
    private Node<T> rotateLeft(Node<T> y) {
        System.out.println("left");
        Node<T> newNode = y.getRight();
        y.setRight(null);
        Node<T> prev = newNode.getLeft();
        newNode.setLeft(y);
        if (prev != null)
            newNode = insertAtPosition(newNode, prev);
        return newNode;
    }

    private Node<T> rotateRight(Node<T> y) {
        System.out.println("right");
        Node<T> newNode = y.getLeft();
        y.setLeft(null);
        Node<T> prev = newNode.getRight();
        newNode.setRight(y);
        if (prev != null)
            newNode = insertAtPosition(newNode, prev);
        return newNode;
    }

    private Node<T> rotateLeftRight(Node<T> node) {
        System.out.println("leftright");
        Node<T> left = node.getLeft();
        node.setLeft(rotateLeft(left));
        return rotateRight(node);
    }

    private Node<T> rotateRightLeft(Node<T> node) {
        System.out.println("rightleft");
        Node<T> right = node.getRight();
        node.setRight(rotateRight(right));
        return rotateLeft(node);
    }
}