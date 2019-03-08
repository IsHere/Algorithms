package algorithms.search;

import algorithms.dateStructure.TreeNode;
import algorithms.interfaces.BinarySearchTree;

public class BinarySearchTreeImp implements BinarySearchTree {
    private TreeNode root;

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTreeImp();
        System.out.println(binarySearchTree.getClass().getName());
    }
    @Override
    public int size() {
        return size(root);
    }

    private int size(TreeNode treeNode) {
        if (treeNode == null) return 0;
        else return treeNode.N;
    }

    @Override
    public int get(int key) {
        return get(root, key);
    }


    private Integer get(TreeNode node, int key) {
        if (node == null) return null;
        if (node.val > key) return get(node.left, key);
        else if (node.val < key) return get(node.right, key);
        else return node.val;
    }

    @Override
    public void put(int key, int value) {
        put(root, key, value);
    }

    @Override
    public Integer min() {
        return min(root).key;
    }

    @Override
    public int select(int k) {
        return 0;
    }

    @Override
    public int rank(int key) {
        return 0;
    }

    private TreeNode put(TreeNode x, Integer key, Integer val) {
        if (x == null) return new TreeNode(key, val, 1);
        if (key > x.key) x.right = put(x.right, key, val);
        else if (key < x.key) x.left = put(x.left, key, val);
        else x.val = val;
        x.N = size(x.left) + size(x.right);
        return x;
    }

    private TreeNode min(TreeNode node) {
        if (node.left == null) return node;
        return min(node);
    }
}
