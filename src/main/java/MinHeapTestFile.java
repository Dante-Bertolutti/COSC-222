//Dante Bertolutti - 300253505

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.lang.foreign.PaddingLayout;
import java.time.chrono.MinguoChronology;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class MinHeapTestFile {

    @Test
    void testEmptyPeek() {
        MinHeap<Integer> m = new MinHeap<>();
        assertEquals(null, m.peek());
    }

    @Test
    void testEmptyPoll() {
        MinHeap<Integer> m = new MinHeap<>();
        assertEquals(null, m.poll());
    }

    @Test
    void testEmptySize() {
        MinHeap<Integer> m = new MinHeap<>();
        assertEquals(0, m.size());
        m.add(6);
        assertEquals(1, m.size());
    }

    @Test
    void testFewIntegers() {
        MinHeap<Integer> m = new MinHeap<>();
        m.add(5);
        m.add(1);
        m.add(9);
        assertEquals(1, m.poll());
        assertEquals(5, m.poll());
        assertEquals(9, m.poll());
    }

    @Test
    void testRepeatedValues() {
        MinHeap<Integer> m = new MinHeap<>();
        m.add(5);
        m.add(1);
        m.add(9);
        m.add(5);
        m.add(1);
        m.add(9);
        assertEquals(1, m.poll());
        assertEquals(1, m.poll());
        assertEquals(5, m.poll());
        assertEquals(5, m.poll());
        assertEquals(9, m.poll());
        assertEquals(9, m.poll());
    }

    @Test
    void testStrings() {
        MinHeap<String> m = new MinHeap<>();
        m.add("don't");
        m.add("tase");
        m.add("me");
        m.add("bro");
        m.add("all");
        m.add("your");
        m.add("base");
        m.add("are");
        m.add("belong");
        m.add("to");
        m.add("us");
        assertEquals(11, m.size());
        assertTrue("all".equals(m.poll()));
        assertTrue("are".equals(m.poll()));
    }

    @Test
    public void testManyDoubles() {
        MinHeap<Double> m = new MinHeap<>();

        // Add 15 doubles to the heap
        m.add(1.1);
        m.add(2.2);
        m.add(3.3);
        m.add(4.4);
        m.add(5.5);
        m.add(6.6);
        m.add(7.7);
        m.add(8.8);
        m.add(9.9);
        m.add(10.10);
        m.add(11.11);
        m.add(12.12);
        m.add(13.13);
        m.add(14.14);
        m.add(15.15);

        // Verify the size of the heap
        assertEquals(15, m.size());

        // Check that the heap maintains the correct order by polling elements
        assertEquals(Double.valueOf(1.1), m.poll());
        assertEquals(Double.valueOf(2.2), m.poll());
        assertEquals(Double.valueOf(3.3), m.poll());
        assertEquals(Double.valueOf(4.4), m.poll());
        assertEquals(Double.valueOf(5.5), m.poll());
        assertEquals(Double.valueOf(6.6), m.poll());
        assertEquals(Double.valueOf(7.7), m.poll());
        assertEquals(Double.valueOf(8.8), m.poll());
        assertEquals(Double.valueOf(9.9), m.poll());
        assertEquals(Double.valueOf(10.10), m.poll());
        assertEquals(Double.valueOf(11.11), m.poll());
        assertEquals(Double.valueOf(12.12), m.poll());
        assertEquals(Double.valueOf(13.13), m.poll());
        assertEquals(Double.valueOf(14.14), m.poll());
        assertEquals(Double.valueOf(15.15), m.poll());

    }

    @Test
    void testManyCharacters() {
        MinHeap<Integer> m = new MinHeap<>();
        //TODO: Test that the heap works with many (15 or more) characters
        MinHeap<Character> mc = new MinHeap<>();

        mc.add('a');
        mc.add('b');
        mc.add('c');
        mc.add('d');
        mc.add('e');
        mc.add('f');
        mc.add('g');
        mc.add('h');
        mc.add('i');
        mc.add('j');
        mc.add('k');
        mc.add('l');
        mc.add('m');
        mc.add('n');
        mc.add('o');

        assertEquals(15, mc.size());

        assertEquals(Character.valueOf('a'), mc.poll());
        assertEquals(Character.valueOf('b'), mc.poll());
        assertEquals(Character.valueOf('c'), mc.poll());
        assertEquals(Character.valueOf('d'), mc.poll());
        assertEquals(Character.valueOf('e'), mc.poll());
        assertEquals(Character.valueOf('f'), mc.poll());
        assertEquals(Character.valueOf('g'), mc.poll());
        assertEquals(Character.valueOf('h'), mc.poll());
        assertEquals(Character.valueOf('i'), mc.poll());
        assertEquals(Character.valueOf('j'), mc.poll());
        assertEquals(Character.valueOf('k'), mc.poll());
        assertEquals(Character.valueOf('l'), mc.poll());
        assertEquals(Character.valueOf('m'), mc.poll());
        assertEquals(Character.valueOf('n'), mc.poll());
        assertEquals(Character.valueOf('o'), mc.poll());
    }


    @Test
    void anotherHeapTest() {
        //TODO: make another test looking for possible things that can break
        //      your heap implementation. Write a description of what you
        //      are trying to test (example, all negatives? all equal? does it
        //      work on sorted order input? reverse sorted order? etc)

        //Testing that the Heap can handle a lot of duplicate values
        MinHeap<Integer> testheap = new MinHeap<>();
        testheap.add(5);
        testheap.add(5);
        testheap.add(5);
        testheap.add(5);
        assertEquals(Integer.valueOf(5), testheap.poll());
        assertEquals(Integer.valueOf(5), testheap.poll());
        assertEquals(Integer.valueOf(5), testheap.poll());
        assertEquals(Integer.valueOf(5), testheap.poll());
    }

    @Test
    void testHeapSortLarge() {
        //TODO: use a heapSort method like in the UseExample.java to
        // test that heapSort will properly sort a large array. (JUnit
        // files can contain non-test static methods as well).
        // For example:
        // - generate an array of 100 random integers
        // - pass these through a heapSort method
        // - verify that heapSort's result is sorted, either by
        //      checking that a[i]<=a[i+1] for all pairs, or by comparing
        //      it to a 'correct' answer given by Arrays.sort() or Collections.sort()
        int[] randomNums = new int[100];
        for(int i = 0; i < randomNums.length; i++){
            randomNums[i] = (int) (Math.random() * 10);
        }
        ArrayList<Integer> heapSortedArray = heapSort(randomNums);
        ArrayList<Integer> collectionSortedArray = new ArrayList<>();
        for (int k = 0; k < randomNums.length; k++){
            collectionSortedArray.add(randomNums[k]);
        }
        Collections.sort(collectionSortedArray);
        for (Integer element: heapSortedArray){
            assertEquals(heapSortedArray.indexOf(element), collectionSortedArray.indexOf(element));
        }


    }
    public static ArrayList<Integer> heapSort(int[] nums) {
        ArrayList<Integer> output = new ArrayList<Integer>();
        MinHeap<Integer> m = new MinHeap<>();

        for (int i: nums)
            m.add(i);

        while (m.size() > 0) {
            output.add(m.poll());
        }
        return output;
    }
}
