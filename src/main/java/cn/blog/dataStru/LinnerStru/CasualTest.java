package cn.blog.dataStru.LinnerStru;

public class CasualTest<T extends Comparable<T>> {

    //根节点
    private BSTNode<T> mRoot;

    /**
     * 树中节点数据类型定义
     *
     * @param <T>
     */
    public class BSTNode<T extends Comparable<T>> {
        T element;
        BSTNode<T> left;
        BSTNode<T> right;
        BSTNode<T> parent;

        BSTNode(T element, BSTNode<T> left, BSTNode<T> parent, BSTNode<T> right) {
            this.element = element;
            this.left = left;
            this.parent = parent;
            this.right = right;
        }
    }

    /**
     * 前序遍历入口
     */
    public void preOrder() {
        preOrder(mRoot);
    }

    /**
     * 前序遍历递归实现
     *
     * @param tree
     */
    public void preOrder(BSTNode<T> tree) {
        while (tree != null) {
            System.out.println("element pre Order is:" + tree.element);
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }

    /**
     * 中序遍历实现
     *
     * @param node
     */
    public void midOrder(BSTNode<T> node) {
        while (node != null) {
            midOrder(node.left);
            System.out.println("element mid order is:" + node.element);
            midOrder(node.right);
        }
    }

    /**
     * 后序遍历实现
     *
     * @param node
     */
    public void postOrder(BSTNode<T> node) {
        while (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println("element post order is:" + node.element);

        }
    }

    /**
     * 查找键值为key的节点
     *
     * @param key
     */
    public BSTNode<T> searchNode(T key) {
        return searchNode(mRoot, key);
    }

    /**
     * 查找键值为key的节点，递归实现
     *
     * @param node
     * @param key
     * @return
     */
    private BSTNode<T> searchNode(BSTNode<T> node, T key) {
        if (node == null)
            return node;

        int cmp = key.compareTo(node.element);
        if (cmp < 0)
            searchNode(node.left, key);
        else if (cmp > 0)
            searchNode(node.right, key);
        else
            return node;

        return node;
    }

    /**
     * 查找键值为key的节点，非递归实现
     *
     * @param node
     * @param key
     * @return
     */
    private BSTNode<T> searchNodeIm(BSTNode<T> node, T key) {

        while (node != null) {
            int cmp = key.compareTo(node.element);
            if (cmp < 0)
                node = node.left;
            else if (cmp > 0)
                node = node.right;
            else
                return node;
        }

        return node;
    }

    /**
     * 查找树中最小键
     *
     * @return
     */
    public T getMinKey() {
        BSTNode<T> minNode = getMin(mRoot);
        if (minNode != null) {
            return minNode.element;
        }
        return null;
    }

    /**
     * 查找树中最小键对应的节点
     *
     * @param node
     * @return
     */
    private BSTNode<T> getMin(BSTNode<T> node) {
        if (node == null) {
            return null;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    /**
     * 查找树中最大键
     *
     * @return
     */
    public T getMax() {
        return getMax(mRoot).element;
    }

    private BSTNode<T> getMax(BSTNode<T> node) {
        if (mRoot == null) {
            return null;
        }
        while (node != null) {
            node = node.right;
        }
        return node;
    }

    /**
     * 查找节点的前驱结点
     *
     * @param node
     * @return
     */
    public BSTNode<T> getNodePreDri(BSTNode<T> node) {
        if (node.left != null) {
            return getMax(node.left);
        }

        BSTNode<T> y = node.parent;
        while ((y != null) && (node == y.left)) {
            node = y;
            y = node.parent;
        }
        return y;
    }

    /**
     * 查找后驱节点
     *
     * @param node
     * @return
     */
    public BSTNode<T> getNodePostDri(BSTNode<T> node) {
        if (node.right != null) {
            return getMin(node.right);
        }

        BSTNode<T> y = node.parent;
        while ((y != null) && node == y.right) {
            node = y;
            y = node.parent;
        }
        return y;
    }

}

