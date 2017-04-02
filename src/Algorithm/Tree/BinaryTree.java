package Algorithm.Tree;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Created by lenovo on 2017/4/1.
 */
public class BinaryTree {
    public TreeNode root;

    public void visit(TreeNode node) {
        System.out.print(node.val + ",");
    }

    public BinaryTree(TreeNode root) {
        this.root = root;
    }

    public TreeNode init(String data) {
        //将字符串形如"1,2,3,#,#,4,5"转化为二叉树，即反序列化,#代表空节点
        if (data == null)
            return null;
        String[] vals = data.split(",");
        ArrayList<TreeNode> queue = new ArrayList<>();
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        queue.add(root);
        int index = 0;//index in queue
        boolean isLeftChild = true;
        for (int i = 1; i < vals.length; i++) {
            if (!vals[i].equals("#")) {
                TreeNode node = new TreeNode(Integer.parseInt(vals[i]));
                if (isLeftChild) {
                    queue.get(index).left = node;
                } else {
                    queue.get(index).right = node;
                }
                queue.add(node);
            }
            if (!isLeftChild) {
                index++;
            }
            isLeftChild = !isLeftChild;
        }
        return root;
    }

    public String Serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        for (int i = 0; i < queue.size(); i++) {
            TreeNode node = queue.get(i);
            if (node == null)
                continue;
            queue.add(node.left);
            queue.add(node.right);
        }
        for (int i = 0; i < queue.size(); i++) {
            if (queue.get(i) == null)
                sb.append("#,");
            else
                sb.append("," + queue.get(i));
        }
        return sb.toString();
    }

    public TreeNode getParentRecursively(TreeNode root, TreeNode node) {
        // 非递归实现查找某节点的父节点
        root = this.root;//从树的根结点开始找
        TreeNode temp;
        if (root == null) {
            return null;
        }
        if (node == root.left || node == root.right) {
            return root;
        }
        if ((temp = getParentRecursively(root.left, node)) != null) {
            return temp;
        }
        if ((temp = getParentRecursively(root.right, node)) != null) {
            return temp;
        }
        return null;
    }

    public TreeNode getParentLooply(TreeNode node) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        TreeNode currentRoot = this.root;
        stack.push(null);
        while (currentRoot != null) {
            if (node == currentRoot.left || node == currentRoot.right) {
                return currentRoot;
            }
            if (currentRoot.right != null) {
                stack.push(currentRoot.right);
            }
            if (currentRoot.left != null) {
                currentRoot = currentRoot.left;
            } else {
                currentRoot = stack.pop();
            }
        }
        return null;
    }

    public void traversalRecursively(TreeNode root) {
        if (root != null) {
            //visit(root);this is preorder
            traversalRecursively(root.left);
//            visit(root);this is inorder
            traversalRecursively(root.right);
//            visit(root);this is postoder
        }
    }

    public ArrayList<Integer> preOrder() {
        ArrayList<Integer> preOrder = new ArrayList<>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        if (root == null)
            return preOrder;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            preOrder.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return preOrder;
    }

    public ArrayList<Integer> inOrder() {
        ArrayList<Integer> inorder = new ArrayList<>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        if (root == null) {
            return inorder;
        }
        TreeNode ptr = root;
        while (ptr != null || !stack.isEmpty()) {
            while (ptr != null) {
                stack.push(ptr);
                ptr = ptr.left;
            }
            ptr = stack.pop();
            inorder.add(ptr.val);
            ptr = ptr.right;
        }
        return inorder;
    }

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        if (root == null)
            return res;
        queue.offer(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            res.add(level);
        }
        return res;
    }
}
