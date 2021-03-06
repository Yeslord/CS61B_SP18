package synthesizer;

import java.util.Iterator;

//TODO: Make sure to make this class and all of its methods public
//TODO: Make sure to make this class extend AbstractBoundedQueue<t>
public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T>  {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        // TODO: Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        //       this.capacity should be set appropriately. Note that the local variable
        //       here shadows the field we inherit from AbstractBoundedQueue, so
        //       you'll need to use this.capacity to set the capacity.
        this.capacity=capacity;
        first=0;
        last=0;
        fillCount=0;
        rb= (T[]) new Object[capacity];
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */

    private int onePlus(int index) {
        if (index == capacity() - 1) {
            return 0;
        } else {
            return index + 1;
        }
    }
    @Override
    public void enqueue(T x) {
        // TODO: Enqueue the item. Don't forget to increase fillCount and update last.
        if (isFull()) {
            throw new RuntimeException("Ring buffer overflow");
        }
        else {
            rb[last] = x;
            fillCount++;
            last = onePlus(last);
        }
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    @Override
    public T dequeue() {
        // TODO: Dequeue the first item. Don't forget to decrease fillCount and update
        if(isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }
        T temp=rb[first];
        fillCount--;
        first=onePlus(first);
        return temp;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    @Override
    public T peek() {
        // TODO: Return the first item. None of your instance variables should change.
        if(isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }
        return rb[first];
    }

    // TODO: When you get to part 5, implement the needed code to support iteration.
    /**
     * Iterator (difficult)
     */
    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {

        private int current;
        private int count;

        public MyIterator() {
            current = first;
            count = 0;
        }

        @Override
        public boolean hasNext() {
            return count < capacity;
        }

        @Override
        public T next() {
            T ret = rb[current];
            current = onePlus(current);
            count += 1;
            return ret;
        }
    }
}
