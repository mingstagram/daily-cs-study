package datastructure.bst;

class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

class BinarySearchTree {
    Node root;

    // 삽입
    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) return new Node(key);
        if (key < root.key) root.left = insertRec(root.left, key);
        else root.right = insertRec(root.right, key);
        return root;
    }

    // 탐색
    boolean search(Node root, int key) {
        if (root == null) return false;
        if (root.key == key) return true;
        return key < root.key ? search(root.left, key) : search(root.right, key);
    }

    // 중위 순회 (정렬된 출력)
    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

}

public class BSTDemo {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        int[] input = {50, 30, 70, 20, 40, 60, 80};
        for (int key : input) {
            bst.insert(key);
        }

        System.out.print("중위 순회 결과: ");
        bst.inorder(bst.root); // 20 30 40 50 60 70 80

        System.out.println("\n60 존재? " + bst.search(bst.root, 60)); // true
        System.out.println("90 존재? " + bst.search(bst.root, 90)); // false

    }
}
