import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Vikram Saluja
 * @version: 12/6/24
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        return helperSearch(root, val);
    }

    public boolean helperSearch(BSTNode node,int val){
        if (node == null){
            return false;
        }

        if (node.getVal() == val){
            return true;
        }

        if (val < node.getVal()){
            return helperSearch(node.getLeft(), val);
        }
        else {
            return helperSearch(node.getRight(),val);
        }

    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        // New arraylist to hold the result in order
        ArrayList<BSTNode> inOrderNodes = new ArrayList<BSTNode>();
        helperInOrder(root, inOrderNodes);

        // return arraylist
        return inOrderNodes;
    }

    // Helper Function inOrder
    public void helperInOrder(BSTNode node, ArrayList<BSTNode> nodeList){
        if(node != null){
            helperInOrder(node.getLeft(), nodeList);
            nodeList.add(node);
            helperInOrder(node.getRight(),nodeList);
        }
    }
    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        ArrayList<BSTNode> preOrderNodes = new ArrayList<BSTNode>();
        helperPreOrder(root, preOrderNodes);

        // return arraylist
        return preOrderNodes;
    }

    private void helperPreOrder(BSTNode node, ArrayList<BSTNode> nodeList){
        if(node != null){
            nodeList.add(node);
            helperPreOrder(node.getLeft(), nodeList);
            helperPreOrder(node.getRight(), nodeList);
        }
    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        ArrayList<BSTNode> postOrderNodes = new ArrayList<BSTNode>();
        // Call helper function
        helperPostOrder(root, postOrderNodes);

        // Return post order array list
        return postOrderNodes;
    }

    // Helper function for Post Order
    private void helperPostOrder(BSTNode node, ArrayList<BSTNode> nodeList){
        if(node != null){
            helperPostOrder(node.getLeft(), nodeList);
            helperPostOrder(node.getRight(), nodeList);
            nodeList.add(node);
        }
    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        // sets root to what is returned by helper function
        root = helperInsert(root, val);
    }

    // Insert helper function
    private BSTNode helperInsert(BSTNode node, int val){
        // Base case
        if(node == null){
            return new BSTNode(val);
        }
        // Recursive Steps to set nodes
        if(val > node.getVal()){
            node.setLeft(helperInsert(node.getLeft(), val));
        }
        else if(val < node.getVal()){
            node.setRight(helperInsert(node.getRight(), val));
        }
        return node;
    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
