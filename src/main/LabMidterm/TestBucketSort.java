//Dante Bertolutti - 300253505

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// This file will pass all tests without errors when BucketList
// and SortedBucket are fully implemented. But you need to
// add additional test cases as well.

// TODO: there are 3 "to do" items below

public class TestBucketSort {

    /* Declaration of the test objects */

    BucketList<String> b;
    ArrayList<Entry<String>> everyone;
    Entry<String> jim, ken, C, B, A, Aplus;

    /* Instantiation of the objects */

    @BeforeEach
    public void initialize() {
        everyone = new ArrayList<>();
        jim = new Entry<>(92, "Jim");
        ken = new Entry<>(91, "Ken");
        C = new Entry<>(68, "C-Student");
        B = new Entry<>(72, "B-Student");
        A = new Entry<>(84, "A-Student");
        Aplus = new Entry<>(98, "A-plus-Student");

        everyone.add(jim);
        everyone.add(ken);
        everyone.add(C);
        everyone.add(B);
        everyone.add(A);
        everyone.add(Aplus);

    }

    /* Various tests follow */

    @Test
    public void test1() {
        // BucketList constructor takes (min,max,numBuckets)
        b = new BucketList<String>(0, 100, 6);
        b.addAll(everyone);
        ArrayList<Entry<String>> list4 = new ArrayList<>();
        list4.add(C);
        list4.add(B);
        list4.add(A);
        ArrayList<Entry<String>> list5 = new ArrayList<>();
        list5.add(ken);
        list5.add(jim);
        list5.add(Aplus);
        //System.out.println(list4);
        //System.out.println(list5);
        //System.out.println(b);

        // .equals in ArrayLists compares corresponding items
        assertTrue(b.getBucket(4).equals(list4)
                && b.getBucket(5).equals(list5)
                && b.getBucket(0).isEmpty()
                && b.getBucket(1).isEmpty()
                && b.getBucket(2).isEmpty()
                && b.getBucket(3).isEmpty());
    }

    @Test
    public void test2() {
        // BucketList constructor takes (min, max, numBuckets)
        b = new BucketList<>(0, 100, 5);
        b.addAll(everyone);

        // Expected lists for each bucket
        ArrayList<Entry<String>> list0 = new ArrayList<>(); // Bucket 0 (0-19)
        ArrayList<Entry<String>> list1 = new ArrayList<>(); // Bucket 1 (20-39)
        ArrayList<Entry<String>> list2 = new ArrayList<>(); // Bucket 2 (40-59)
        ArrayList<Entry<String>> list3 = new ArrayList<>(); // Bucket 3 (60-79)
        ArrayList<Entry<String>> list4 = new ArrayList<>(); // Bucket 4 (80-100)

        // Add entries to the appropriate lists based on their scores
        list4.add(Aplus); // Aplus has a score in the range 80-100
        list4.add(jim);   // Jim has a score in the range 80-100
        list4.add(ken);   // Ken has a score in the range 80-100
        list3.add(A);     // A has a score in the range 60-79
        list2.add(B);     // B has a score in the range 40-59
        list1.add(C);     // C has a score in the range 20-39

        // Assertions to check each bucket
        assertTrue(b.getBucket(0).equals(list0)); // Empty
        assertTrue(b.getBucket(1).equals(list1)); // Contains C
        assertTrue(b.getBucket(2).equals(list2)); // Contains B
        assertTrue(b.getBucket(3).equals(list3)); // Contains A
        assertTrue(b.getBucket(4).equals(list4)); // Contains Aplus, jim, ken
    }



    @Test
    public void test3() {
        // BucketList constructor takes (min,max,numBuckets)
        b = new BucketList<String>(0, 100, 4);
        b.addAll(everyone);

        //TODO:
        // Write this test similar to test2(). But this time these
        // six Entry Objects are added into a BucketList with 4 buckets
        assertTrue(true); // change this assert
    }


    @Test
    public void emptyTest() {
        // BucketList constructor takes (min,max,numBuckets)
        // Testing if we can construct in the negative range, and if
        // it will still perform "sort" without crashing if all buckets
        // are empty
        b = new BucketList<String>(-50, 50, 6);
        assertTrue(b.getNumBuckets() == 6 && b.getSortedOrder().size() == 0);
    }


    @Test
    public void perfectStudentTest() {
        // test where an Entry named "perfect" with a score of 100 will
        // be placed in a BucketList which stores grades from 0 to 100 and
        // having 10 buckets.

        b = new BucketList<String>(0, 100, 10);
        b.add(new Entry<>(100, "perfect"));
        assertTrue(b.getBucket(9).size() == 1);
    }


    @Test
    public void outOfBoundsTest1() {
        // tests if we can safely add an Entry with key value larger than max

        b = new BucketList<String>(0, 100, 10);
        b.add(new Entry<>(110, "superPerfect"));
        assertTrue(b.getBucket(9).size() == 1);
    }


    @Test
    public void outOfBoundsTest2() {
        // tests if we can safely add an Entry with key value less than min

        b = new BucketList<String>(0, 100, 10);
        b.add(new Entry<>(-110, "notSoPerfect"));
        assertTrue(b.getBucket(0).size() == 1);
    }


    @Test
    public void additionalTest() {
        //TODO: Write an additional test different
        //from the above tests.
    }

}
