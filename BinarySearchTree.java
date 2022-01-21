package MovieDatabase;

import java.util.ArrayList;
//-----------------------------------------------------
// Title:My generic BinarySearchTree class
// Author: Hamid Ahmadlouei-İbrahim İleri
// ID: 10007768278
// Section: 1
// Assignment: 3-BinarySearchTrees
// Description:  This generic class initialize empty "BinarySearch Tree"
// and defines the "BinarySearch Tree" abilities which are put,delete,size,inorder traversal,print etc..
// Additionally I append my personal methods into it in order to ensure functionality for my project.
//-----------------------------------------------------

public class BinarySearchTree<Key extends Comparable<Key>, Value> {
    private Node root;

    /**
     * Summary and Post condition:Private Inner Class for Node Objects which we will use for constructing out BST.
     * Precondition: None
     */
    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int count;

        public Node(Key key, Value val) {
            this.key = key;
            this.val = val;
        }
    }
    /**
     * I will make explanation below in the actual put method:
     */
    public void put(Key key, Value val) {
        root = put(root, key, val);

    }
    /**
     *  I will make explanation below in the actual "add" method:
     */
    public void add(Key key, Value val) {
        root = add(root, key, val);

    }
    /**
     * Summary and Post condition:This method for Adding Node's into the BST.Important aspect of it is adding same and greater values
     * (surely in terms of their compareTo method) store the right of the current node.Likewise, it store the smaller values in the left of the current node.
     * I did this procedure for provide functionality for Movies that have same years as our TA's said in the pdf.
     * Precondition: In main function add-> it takes "Key"and "Value"  then it handles in API (by using root).
     */
    private Node put(Node x, Key key, Value val) // helper function of "put"
    {
        if (x == null) return new Node(key, val);
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = put(x.left, key, val);
        else
            x.right = put(x.right, key, val);

        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }
    /*else if (cmp > 0)
            x.right = put(x.right, key, val);
        else if (cmp == 0) // equal ı greeater ile aynı yap. else deyip tek if te birlşetir.
            x.val = val;*/
    /**
     * Summary and Post condition:This method for Adding Node's into the BST.Important aspect of it is adding greater values
     * (surely in terms of their compareTo method) store the right of the current node.Likewise, it store the smaller values in the left of the current node.
     * But different from "put()" method it overwrites Nodes with same value onto the current node.(Like contemporary BST API).
     * Precondition: In main function add-> it takes "Key"and "Value"  then it handles in API (by using root).
     */
    private Node add (Node x, Key key, Value val) // helper function of "put"
    {
        if (x == null) return new Node(key, val);
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = add(x.left, key, val);
        else if (cmp > 0)
            x.right = put(x.right, key, val);
        else if (cmp == 0) // equal ı greeater ile aynı yap. else deyip tek if te birlşetir.
            x.val = val;

        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }
    /**
     * Summary and Post condition: This method for revealing the Intended Key from BST.If there is no key with given parameter,return NULL
     * Precondition: Only single Key is suffice
     */
    public Value get(Key key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else if (cmp == 0) return x.val;
        }
        return null;
    }

    public int size() {
        return size(root);
    }
    /**
     * Summary and Post condition:This method for getting the size of BST.
     */
    private int size(Node x) {
        if (x == null) return 0;
        return x.count;
    }
    Node min(Node x)  { //?
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        return x;
    }
    /**
     * Summary and Post condition:This method for Deleting Node's into the BST.Important aspect of it is adding greater values
     * (surely in terms of their compareTo method) traverse the right of the current node.Likewise, it traverse for the smaller values in the left of the current node.
     * When given key is equal to current Node,delete it.
     * Precondition: In main function add-> it takes "Key" then it handles in API (by using root).
     */
    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = delete(x.left, key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.count = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void deleteMin() {
        root = deleteMin(root);
    }
    /**
     * Summary and Post condition: Helper Function for "delete()"
     * Precondition: inteded Node to find Min.
     */
    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }
   /*public Node search(Key key)  {
        root.val = search_Recursive(root, key); // root.val ları root yap.
        if (root!= null)
            return root;
        else
            return null;
    }
    /**
     * Summary and Post condition:Private Inner Class for Node Objects which we will use for constructing out BST.
     * Precondition: None
     */
    //recursive insert function
    /*
    private Value search_Recursive(Node root, Key key)  {
        // Base Cases: root is null or key is present at root
        if (root==null || root.key==key)
            return root.val;
        // val is greater than root's key
        if (root.key.compareTo(key)>0)
            return search_Recursive(root.left, key);
        // val is less than root's key
        return search_Recursive(root.right, key);
    }
    public void inorder() {
        inorder_Recursive(root);
    }
    /**
     * Summary and Post condition:
     * Precondition: None
     */
    // recursively traverse the BST
    /*
    public void inorder_Recursive(Node root) {
        if (root != null) {
            inorder_Recursive(root.left);
            System.out.print(root.key + " ");
            inorder_Recursive(root.right);
        }
    }*/
    /**
     * Summary and Post condition:The one of the most important methods in mt BST. It finds the all keys in the current BST.
     * and add it them into ArrayList(this is my personal design decision) the return the ArrayList.
     * Precondition: None
     */
    public ArrayList<Key> keys()
    {
        ArrayList<Key> q = new ArrayList<Key>();
        inorder(root, q);
        return q;
    }
    /**
     * Summary and Post condition:Helper Function for "keys()" fill the ArrayList in ascending order by doing inorder traversal.
     * Precondition: Root Node and ArrayList.
     */
    private void inorder(Node x, ArrayList<Key> q)
    {
        if (x == null) return;
        inorder(x.left, q);
        q.add(x.key);
        inorder(x.right, q);
    }

}
