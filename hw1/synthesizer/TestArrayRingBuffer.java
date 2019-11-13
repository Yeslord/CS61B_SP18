package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(10);
        assertEquals(0,arb.fillCount());
        assertEquals(10,arb.capacity());
        arb.enqueue(5);
        arb.enqueue(3);
        arb.enqueue(1);
        assertEquals(3,arb.fillCount());
        assertEquals(5,arb.dequeue());
        assertEquals(3,arb.peek());

    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
