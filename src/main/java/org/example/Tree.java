package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode<T> {
    T val;
    TreeNode left;
    TreeNode right;

    TreeNode(T x) {
        val = x;
    }
}

public class Tree<T> {

    private TreeNode<T> root;

    public Tree(T val) {
        root = new TreeNode(val);
    }

    public Tree(TreeNode<T> val) {
        root = val;
    }

    List<List<T>> levelOrderTraverse() {
        List<List<T>> result = new LinkedList<>();
        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); // add root to queue
        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // number of nodes on one level
            List<T> currentLevel = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                TreeNode<T> currentNode = queue.poll();
                // add the node to the current level
                currentLevel.add(currentNode.val);
                // insert the children of current node in the queue
                if (currentNode.left != null)
                    queue.offer(currentNode.left);
                if (currentNode.right != null)
                    queue.offer(currentNode.right);
            }
            result.add(currentLevel);
            //result.add(0, currentLevel);
        }
        return result;

    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<List<Integer>> result = new Tree<Integer>(root).levelOrderTraverse();
        System.out.println("Level order traversal: " + result);
    }
}
