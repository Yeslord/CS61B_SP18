/**Looking at the solution to come up with this*/
public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private static int initialCapacity = 8; // The stating length of array
    private static int eFactor = 2; // Expanding factor
    private static int mCapacity = 16; // The minimum capacity for contraction resizing
    private static double mRatio = 0.25; // The minimum usage ratio before contraction
    private static int cFactor = 2; // Contracting factor
    private int capacity; // The length of array
    private int nextFirst;
    private int nextLast;
    /** Creates an empty list. */
    public ArrayDeque() {
        items = (T[]) new Object[initialCapacity];
        nextFirst = capacity-1;
        nextLast=0;
        size = 0;
    }

    /** Decreases index according to circular structure. */
    private int oneMinus(int index) {
        if (index == 0) {
            return capacity - 1;
        } else {
            return index - 1;
        }
    }
    /** Increases given index according to circular structure. */
    private int onePlus(int index) {
        if (index == capacity - 1) {
            return 0;
        } else {
            return index + 1;
        }
    }

    /** Resizes the underlying array to the target capacity. (difficult) */
    private void resize(int capacity) {
        T[] newitems = (T[]) new Object[capacity];
        if(nextFirst>nextLast) {
            System.arraycopy(items,nextFirst,newitems,0,(items.length-nextFirst));
            System.arraycopy(items,0,newitems,(items.length-nextFirst),(nextLast-1));
        }
        else{
            System.arraycopy(items,nextFirst,newitems,0,size+1);
        }
        items = newitems;
        nextLast=size+1;
        nextFirst=0;
    }

    /** Inserts X into the front and back of the list. */
    public void addFirst(T item) {
        if (size == items.length) {
            resize(size *eFactor);
        }
        items[nextFirst]=item;
        nextFirst=oneMinus(nextFirst);
        size = size + 1;
    }
   public void addLast(T item) {
        if (size == items.length) {
            resize(size *eFactor);
        }
        items[nextLast]=item;
        nextLast=onePlus(nextLast);
        size = size + 1;
    }
    public boolean isEmpty() {
        if (size==0) {
            return true;
        }
        return false;
    }
    /** Gets the ith item in the list (0 is the front). */
    public T get(int index) {
        return items[index];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
      * returns deleted item. */
    public T removeFirst() {
        if (isEmpty()){
            return null;
        }
        else if(items.length>=mCapacity && size/capacity<0.25){
            resize(size/cFactor);
        }
        T x = get(nextFirst+1);
        items[nextFirst+1] = null;
        size = size - 1;
        return x;
    }
    public T removeLast() {
        if (isEmpty()){
            return null;
        }
        else if(items.length>=mCapacity && size/capacity<0.25){
            resize(size/cFactor);
        }
        T x = get(nextLast-1);
        items[nextLast-1] = null;
        size = size - 1;
        return x;
    }
    public void printDeque() {
        for (int i=0;i<size;i++) {
            System.out.println(get(i)+" ");
        }
    }
} 