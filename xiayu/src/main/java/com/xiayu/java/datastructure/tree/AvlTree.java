package com.xiayu.java.datastructure.tree;

/**
 * @author: starc
 * @date: 2019/1/13
 */
public class AvlTree {
    private int size;
    private AvlTreeNode root=Nil;

    private AvlTreeNode findMin(AvlTreeNode node) {
        AvlTreeNode minNode = node;
        if (minNode == Nil) {
            return null;
        }
        while (minNode.left != Nil) {
            minNode = minNode.left;
        }
        return minNode;
    }

    private AvlTreeNode findNum(int num) {
        AvlTreeNode now = root;
        while (now != Nil) {
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

    /**
     * add的思路：
     * 1.插入合适位置节点
     * 2.向上遍历父节点更新高度同时检查左右子节点高度差
     * 3.对未平衡的点重平衡
     * 4.继续向上遍历父节点（更新高度）
     * @param num 添加的数
     */
    public void add(int num) {
        AvlTreeNode node = new AvlTreeNode(num);
        add(node);
    }
    private void add(AvlTreeNode node) {
        AvlTreeNode now = Nil;
        AvlTreeNode tem = root;
        while (tem!=Nil) {
            now = tem;
            if (node.element < tem.element) {
                tem = tem.left;
            } else {
                tem = tem.right;
            }
        }
        node.parent = now;
        if (now == Nil) {
            root = node;
        } else if (node.element < now.element) {
            now.left = node;
        } else {
            now.right = node;
        }
        size++;
        while (now!=Nil) {
            if(!checkHeight(now)) {
                reBalance(now);
                checkHeight(now);
            }
            now=now.parent;
        }
        printHeight();
    }

    public void delete(int num) {
        delete(findNum(num));
    }

    /**
     * 删除节点
     *
     * @param node 被删除的节点
     */
    private void delete(AvlTreeNode node) {
        //todo 感觉有问题
        if (node != Nil) {
            if (node.left == Nil) {
                transplant(node, node.right);
            } else if (node.right == Nil) {
                transplant(node, node.left);
            } else {
                AvlTreeNode minNode = findMin(node.right);
                if (minNode != null) {
                    if (minNode.parent != Nil) {
                        transplant(minNode, minNode.right);
                        minNode.right = node.right;
                        node.right.parent = minNode;
                    }
                    transplant(node, minNode);
                    minNode.left = node.left;
                    minNode.left.parent = minNode;
                }
            }

        }

    }

    /**
     * 并不会将oldNode子树给newNode，仅仅将oldNode的parentNode与newNode互相指向对方。
     *
     * @param oldNode 被替换的节点
     * @param newNode 替换到oldNode位置的节点
     */
    private void transplant(AvlTreeNode oldNode, AvlTreeNode newNode) {
        if (oldNode.parent == Nil) {
            root = newNode;
        } else if (oldNode == oldNode.parent.left) {
            oldNode.parent.left = newNode;
        } else {
            oldNode.parent.right = newNode;
        }
        if (newNode != Nil) {
            newNode.parent = oldNode.parent;
        }
    }

    private boolean checkHeight(AvlTreeNode node) {
        if (node != Nil) {
            node.height = node.left.height >= node.right.height ? node.left.height + 1 : node.right.height + 1;
            int result = node.left.height - node.right.height;
            return result <= 1 && result >= -1;
        }
        return true;
    }

    private void reBalance(AvlTreeNode node) {
        if (node != null) {
            if (node.left.height > node.right.height) {
                if (node.left.left.height > node.left.right.height) {
                    singleRotation(node,node.left);
                } else {
                    doubleRotation(node,node.left.right);
                }
            } else {
                if (node.right.left.height > node.right.right.height) {
                    doubleRotation(node,node.right.left);
                } else {
                    singleRotation(node,node.right);
                }
            }
        }
    }

    private void singleRotation(AvlTreeNode oldNode, AvlTreeNode newNode) {
        if(newNode==oldNode.left) {
            transplant(oldNode, newNode);
            oldNode.left = newNode.right;
            newNode.right = oldNode;
            oldNode.left.parent = oldNode;
            oldNode.parent = newNode;
        }else {
            transplant(oldNode, newNode);
            oldNode.right = newNode.left;
            newNode.left = oldNode;
            oldNode.right.parent = oldNode;
            oldNode.parent = newNode;
        }
    }

    private void doubleRotation(AvlTreeNode oldNode, AvlTreeNode newNode) {
        if(newNode==oldNode.left.right) {
            transplant(oldNode,newNode);
            oldNode.left.right=newNode.left;
            oldNode.left.right.parent=oldNode.left;
            newNode.left=oldNode.left;
            newNode.left.parent=newNode;
            oldNode.left=newNode.right;
            oldNode.left.parent=oldNode;
            newNode.right=oldNode;
            newNode.right.parent=newNode;
        }else {
            transplant(oldNode,newNode);
            oldNode.right.left=newNode.right;
            oldNode.right.left.parent=oldNode.right;
            newNode.right=oldNode.right;
            newNode.right.parent=newNode;
            oldNode.right=newNode.left;
            oldNode.right.parent=oldNode;
            newNode.left=oldNode;
            newNode.left.parent=newNode;
        }
    }
    public void heightCheck() {
        heightCheck(root);
    }
    public void heightCheck(AvlTreeNode node) {
        if (node != Nil) {
            int result = node.left.height - node.right.height;
            if(result>1||result<-1) {
                System.out.println("height is wrong");
            }else {
                heightCheck(node.left);
                heightCheck(node.right);
            }
        }
    }
    public void print() {
        print(root);
        System.out.println();
    }

    private void print(AvlTreeNode node) {
        if (node.left != Nil) {
            print(node.left);
        }
        System.out.print(node.element);
        if (node.right != Nil) {
            print(node.right);
        }
    }
    private void printHeight() {
        System.out.println("root height is "+root.height);
    }
    static class AvlTreeNode {
        AvlTreeNode(int num) {
            this.element = num;
        }
        AvlTreeNode(Integer element, int height, AvlTreeNode left, AvlTreeNode right, AvlTreeNode parent) {
            this.element = element;
            this.height = height;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

        Integer element;
        int height;
        AvlTreeNode left = Nil;
        AvlTreeNode right = Nil;
        AvlTreeNode parent = Nil;
    }

    private static AvlTreeNode Nil = new AvlTreeNode(null, -1, null, null, null);
}
