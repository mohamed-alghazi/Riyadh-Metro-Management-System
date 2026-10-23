package riyadhmetroproject.MetroLines;

public class BSTree<K extends Comparable<K>, E> {

    private BSTNode<K, E> root;

    public BSTNode<K, E> getRoot() {
        return root;
    }

    
    public E search(K k) {
        BSTNode<K, E> n = searchTree(root, k);
        return (n == null ? null : n.getData());
    }

    private BSTNode<K, E> searchTree(BSTNode<K, E> root, K key) {
        if (root == null) return null;

        if (root.getKey().equals(key)) return root;

        if (key.compareTo(root.getKey()) < 0)
            return searchTree(root.getLeft(), key);

        return searchTree(root.getRight(), key);
    }

  
    public void insert(K key, E data) {
        BSTNode<K, E> parent = null;
        BSTNode<K, E> trav = root;

        while (trav != null) {
            parent = trav;
            if (key.compareTo(trav.getKey()) < 0)
                trav = trav.getLeft();
            else
                trav = trav.getRight();
        }

        BSTNode<K, E> newNode = new BSTNode<>(key, data);

        if (root == null)
            root = newNode;
        else if (key.compareTo(parent.getKey()) < 0)
            parent.setLeft(newNode);
        else
            parent.setRight(newNode);
    }

   
    

   
    public E delete(K key) {
        BSTNode<K, E> parent = null;
        BSTNode<K, E> trav = root;

        while (trav != null && !trav.getKey().equals(key)) {
            parent = trav;
            if (key.compareTo(trav.getKey()) < 0)
                trav = trav.getLeft();
            else
                trav = trav.getRight();
        }

        if (trav == null) return null;

        E removed = trav.getData();
        deleteNode(trav, parent);
        return removed;
    }

    private void deleteNode(BSTNode<K, E> node, BSTNode<K, E> parent) {

        if (node.getLeft() != null && node.getRight() != null) {
            BSTNode<K, E> rp = node;
            BSTNode<K, E> r = node.getRight();

            while (r.getLeft() != null) {
                rp = r;
                r = r.getLeft();
            }

            node.setKey(r.getKey());
            node.setData(r.getData());

            deleteNode(r, rp);
        } else {
            BSTNode<K, E> child = (node.getLeft() != null ? node.getLeft() : node.getRight());

            if (node == root)
                root = child;
            else if (node.getKey().compareTo(parent.getKey()) < 0)
                parent.setLeft(child);
            else
                parent.setRight(child);
        }
    }

    
    public E findMin() {
        BSTNode<K, E> t = root;
        if (t == null) return null;

        while (t.getLeft() != null)
            t = t.getLeft();

        return t.getData();
    }

   
    public E findMax() {
        BSTNode<K, E> t = root;
        if (t == null) return null;

        while (t.getRight() != null)
            t = t.getRight();

        return t.getData();
    }
    
    
   

public void print() {
        print(root);
    }

    private void print(BSTNode<K, E> root) {
        if (root != null) {
            print(root.getLeft());
            System.out.println(root.getData());
            print(root.getRight());
        }
    }
    
    
    
     public void rangeSearch(K low, K high) {
    rangeSearch(root, low, high);
}
     
private void rangeSearch(BSTNode<K, E> root, K low, K high) {
        if (root != null) {
            rangeSearch(root.getLeft(),low,high);
           
            if (low.compareTo(root.getKey()) <= 0 && high.compareTo(root.getKey()) >= 0)
            System.out.println(root.getData());
           
            rangeSearch(root.getRight(),low,high);
        }
    }
}


