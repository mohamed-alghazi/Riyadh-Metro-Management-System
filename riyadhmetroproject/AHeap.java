package riyadhmetroproject;


public class AHeap<Key extends Comparable<Key>, E extends Comparable<E>> {

    private AHNode<Key, E>[] a;
    private int size;
    private int maxsize;

   
    public AHeap(int k) {
        maxsize = k;
        a = new AHNode[maxsize];
        size = -1;
    }

    public boolean isEmpty() { return size == -1; }
    public int size() { return size + 1; }

    private int left(int p) { return 2 * p + 1; }
    private int right(int p) { return 2 * p + 2; }
    private int parent(int p) { return (p - 1) / 2; }
    private boolean hasLeft(int p) { return left(p) <= size; }
    private boolean hasRight(int p) { return right(p) <= size; }

    
    private boolean greater(AHNode<Key, E> x, AHNode<Key, E> y) {
        return x.getValue().compareTo(y.getValue()) > 0;
    }

    public void insert(Key key, E value) {
        if (size + 1 >= maxsize) return;
        size++;
        a[size] = new AHNode<>(key, value);
        upheap(size);
    }

    private void upheap(int p) {
        while (p > 0) {
            int pp = parent(p);
            if (!greater(a[p], a[pp])) break;
            AHNode<Key, E> temp = a[p];
            a[p] = a[pp];
            a[pp] = temp;
            p = pp;
        }
    }

    private void downheap(int p) {
        while (hasLeft(p)) {
            int lp = left(p);
            int m = lp;
            if (hasRight(p)) {
                int rp = right(p);
                if (greater(a[rp], a[lp])) 
                    m = rp;
            }
            if (greater(a[p], a[m])) break;
            AHNode<Key, E> temp = a[p];
            a[p] = a[m];
            a[m] = temp;
            p = m;
        }
    }

    
    public AHNode<Key, E> getMax() {
        if (isEmpty()) return null;
        return a[0];
    }

    
    public AHNode<Key, E> removemax() {
        if (isEmpty()) return null;
        AHNode<Key, E> max = a[0];
        a[0] = a[size];
        size--;
        if (!isEmpty()) downheap(0);
        return max;
    }

    
    public boolean updateKey(int id,int Newper) {
        for (int i = 0; i <= size; i++) {
            if (a[i].getKey().equals(id)) {
             ((MaintenanceTask )a[i].getValue()).setPriority(Newper);
                upheap(i);
                downheap(i);
                return true;
            }
        }
        return false;
    }

    public AHNode<Key, E>[] getSortedArray() {
        int n = size+1 ;
        AHeap<Key, E> temp = new AHeap<>(n);
        
        for (int i = 0; i < n; i++) 
            temp.insert(a[i].getKey(), a[i].getValue());
        
        AHNode<Key, E>[] res = new AHNode[n];
        for (int i = 0; i < n; i++)
            res[i] = temp.removemax();
        return res;
    }

    public void print() {
        for (int i = 0; i <= size; i++) {
            System.out.println("a[" + i + "]: Key = " + a[i].getKey() +
                               ", Value = " + a[i].getValue());
        }
    }
}
