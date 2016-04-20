package exam01;


import  java.util.List;
import  java.util.ArrayList;

import static org.junit.Assert.*;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.Test;

public class Tester2 {

    @Test
    public void PISCtor() {
        PosIntSet s = new PosIntSet();
        assertNotNull(s.getElements());
        assertEquals(0, s.size());
    }

    @Test
    public void PISContains() {
        PosIntSet s = new PosIntSet();
        s.add(1);
        s.add(2);
        s.add(3);
        assertTrue(s.contains(1));
        s.add(1);
        assertTrue(s.contains(1));

        assertTrue(s.contains(2));
        assertTrue(s.contains(3));
        assertFalse(s.contains(4));
    }

    @Test
    public void PISAddEmpty() {
        PosIntSet s = new PosIntSet();
        assertFalse(s.contains(1));
        assertFalse(s.contains(3));
    }

    @Test
    public void PISAddSimple() {
        PosIntSet s = new PosIntSet();
        s.add(1);
        assertEquals(1, s.size());
        s.add(2);
        assertEquals(2, s.size());
        s.add(3);
        assertEquals(3, s.size());
    }

    @Test
    public void PISAddIllegal() {
        PosIntSet s = new PosIntSet();
        assertFalse(s.add(-4));
        assertEquals(0, s.size());
        assertTrue(s.add(4));
        assertEquals(1, s.size());
        assertFalse(s.add(4));
        assertEquals(1, s.size());
    }

    @Test
    public void PISUnion() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        PosIntSet s = new PosIntSet();
        PosIntSet o = new PosIntSet();
        for (int i : list) {
            s.add(i);
            o.add(i);
        }
        list.add(4);
        o.add(4);
        s.union(o); // 4 added
        assertArrayEquals(list.toArray(new Integer[list.size()]),
                          s.getElements().toArray(new Integer[o.size()]));
    }

    @Test
    public void PISUnionEmpty() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        PosIntSet s = new PosIntSet();
        for (int i : list) {
            s.add(i);
        }
        PosIntSet e = new PosIntSet();
        e.add(1);
        e.add(2);
        s.union(e); // None added
        assertArrayEquals(list.toArray(new Integer[list.size()]),
                          s.getElements().toArray(new Integer[s.size()]));
    }

    @Test
    public void PISUnionNoModifyArg() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        PosIntSet s = new PosIntSet();
        PosIntSet o = new PosIntSet();
        for (int i : list) {
            s.add(i);
            o.add(i);
        }
        s.union(o);
        assertArrayEquals(list.toArray(new Integer[list.size()]),
                          o.getElements().toArray(new Integer[o.size()]));

        PosIntSet e = new PosIntSet();
        s.union(e);
        assertArrayEquals(new Integer[0],
                          e.getElements().toArray(new Integer[e.size()]));

        o.add(4);
        list.add(4);
        s.union(o);
        assertArrayEquals(list.toArray(new Integer[list.size()]),
                          o.getElements().toArray(new Integer[s.size()]));
    }

    @Test
    public void PISSize() {
        PosIntSet s = new PosIntSet();
        s.add(5);
        s.add(4);
        s.add(-4);
        s.add(4);
        s.add(3);
        assertEquals(3, s.size());
    }

    @Test
    public void AUAltOddSum() {
        assertEquals(1, ArrayUtils.alternateOddSum(new int[]{5, 1}));
        assertEquals(3, ArrayUtils.alternateOddSum(new int[]{1, 3, 1, 2}));
        assertEquals(3, ArrayUtils.alternateOddSum(new int[]{1, 3, 1, 2, 3}));
        assertEquals(0, ArrayUtils.alternateOddSum(new int[]{1, 2, 1, 2, 1}));
        assertEquals(3, ArrayUtils.alternateOddSum(new int[]{1, 2, 1, 2, 1, 3}));
        assertEquals(6, ArrayUtils.alternateOddSum(new int[]{1, 3, 1, 3, 3}));
    }

    @Test
    public void AUAltOddSumEmpty() {
        assertEquals(0, ArrayUtils.alternateOddSum(new int[]{}));
        assertEquals(0, ArrayUtils.alternateOddSum(new int[]{5}));
    }

    @Test
    public void AUReverse() {
        assertArrayEquals(new int[]{5,4,3,2,1},
                          ArrayUtils.reverse(new int[]{1,2,3,4,5}));
        assertArrayEquals(new int[]{4,2,3,1},
                          ArrayUtils.reverse(new int[]{1,3,2,4}));
    }

    @Test
    public void AUReverseEmpty() {
        assertArrayEquals(new int[]{}, ArrayUtils.reverse(new int[]{}));
        assertArrayEquals(new int[]{5}, ArrayUtils.reverse(new int[]{5}));
    }

    @Test
    public void AUDrop() {
        assertArrayEquals(new int[]{6,7,8}, ArrayUtils.drop(new int[]{3,4,5,6,7,8}, 3));
        assertArrayEquals(new int[]{7,8}, ArrayUtils.drop(new int[]{3,4,5,6,7,8}, 4));
    }

    @Test
    public void AUDropEmpty() {
        assertArrayEquals(new int[]{}, ArrayUtils.drop(new int[]{}, 0));
        assertArrayEquals(new int[]{1}, ArrayUtils.drop(new int[]{1}, 0));
    }

    @Test
    public void AUDropGreater() {
        assertArrayEquals(new int[]{}, ArrayUtils.drop(new int[]{3,4,5,6,7,8}, 7));
        assertArrayEquals(new int[]{}, ArrayUtils.drop(new int[]{3,4,5,6,7,8}, 6));
    }

    public static void main(String[] args) {
        Result r = JUnitCore.runClasses(Tester2.class);
        int count = r.getRunCount();
        int numFail = r.getFailureCount();
        List<Failure> failures = r.getFailures();
        for (Failure f : failures) {
            System.out.println("---------------");
            System.out.println(f);

        }
        System.out.println("SCORE: " + (count-numFail) + "/" + count);
        double sub = numFail/((double)count);
        // System.out.println(sub);
        System.out.println("10 - " + (sub*10) + " = " + (10 - (sub*10)));
    }
}