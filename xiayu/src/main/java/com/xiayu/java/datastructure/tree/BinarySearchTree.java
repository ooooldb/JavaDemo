package com.xiayu.java.datastructure.tree;

/**
 * @author: starc
 * @date: 2019/1/10
 */
public class BinarySearchTree {
    private int size = 0;
    private BinarySearchNode root;

    public Integer printMax() {
        BinarySearchNode max = findMax();
        return max == null ? null : max.element;
    }

    private BinarySearchNode findMax() {
        BinarySearchNode maxNode = root;
        if (root == null) {
            return null;
        }
        while (maxNode.right != null) {
            maxNode = maxNode.right;
        }
        return maxNode;
    }

    public int findMin() {
        return findMin(root).element;
    }

    private BinarySearchNode findMin(BinarySearchNode node) {
        if (node == null) {
            return null;
        } else if (node.left == null) {
            return node;
        } else {
            return findMin(node.left);
        }
    }

    private BinarySearchNode find(int num) {
        return find(root, num);
    }

    private BinarySearchNode find(BinarySearchNode node, int num) {
        if (node == null || node.element == num) {
            return node;
        } else if (num > node.element) {
            return find(node.right, num);
        } else {
            return find(node.left, num);
        }
    }

    //非递归的实现
    private BinarySearchNode findNum(int num) {
        BinarySearchNode now = root;
        while (now != null) {
            if (num > now.element) {
                now = now.right;
            } else if (num < now.element) {
                now = now.left;
            } else {
                return now;
            }
        }
        return null;
    }

    public void add(int num) {
        BinarySearchNode node = new BinarySearchNode(num);
        add(node);
    }

    private void add(BinarySearchNode node) {
        BinarySearchNode now = root;
        BinarySearchNode tem = root;
        while (tem != null) {
            now = tem;
            if (node.element < tem.element) {
                tem = tem.left;
            } else {
                tem = tem.right;
            }
        }
        node.parent = now;
        if (now == null) {
            root = node;
        } else if (node.element < now.element) {
            now.left = node;
        } else {
            now.right = node;
        }
        size++;
    }

    public void delete(int num) {
        delete(find(num));
    }

    /**
     * 1.node没有左子节点
     * 用node.right替换node
     * 2.没有子节点
     * 用null替换node
     * 3.有左右节点
     * 查出右节点中最小的节点
     * 3.1如果该节点就是node.right
     * 用node.right替换node
     * 将node.left与node.right互相引用
     * 3.2如果该节点不是node.right
     * 用该节点的右节点替换该节点（把右子树给它的父节点）
     * 用该节点替换node
     * 将node.right与该节点互相引用
     * 将node.left与该节点互相引用（把node的左右子树给该节点）
     *
     * @param node 被删除的节点
     */
    private void delete(BinarySearchNode node) {
        if (node.left == null) {
            transplant(node, node.right);
        } else if (node.right == null) {
            transplant(node, node.left);
        } else {
            BinarySearchNode minNode = findMin(node.right);
            if (minNode.parent != node) {
                transplant(minNode, minNode.right);
                minNode.right = node.right;
                node.right.parent = minNode;
            }
            transplant(node, minNode);
            minNode.left = node.left;
            minNode.left.parent = minNode;
        }
    }

    /**
     * 并不会将oldNode子树给newNode，仅仅将oldNode的parentNode与newNode互相指向对方。
     *
     * @param oldNode 被替换的节点
     * @param newNode 替换到oldNode位置的节点
     */
    private void transplant(BinarySearchNode oldNode, BinarySearchNode newNode) {
        if (oldNode.parent == null) {
            root = newNode;
        } else if (oldNode == oldNode.parent.left) {
            oldNode.parent.left = newNode;
        } else {
            oldNode.parent.right = newNode;
        }
        if (newNode != null) {
            newNode.parent = oldNode.parent;
        }
    }

    public void print() {
        print(root);
        System.out.println();
    }

    private void print(BinarySearchNode node) {
        if (node.left != null) {
            print(node.left);
        }
        System.out.print(node.element);
        if (node.right != null) {
            print(node.right);
        }
    }

    class BinarySearchNode {

        BinarySearchNode(int element) {
            this.element = element;
        }

        BinarySearchNode(int element, BinarySearchNode left, BinarySearchNode right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }

        Integer element;
        BinarySearchNode left;
        BinarySearchNode right;
        BinarySearchNode parent;
    }
}
