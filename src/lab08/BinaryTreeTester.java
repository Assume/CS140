package lab08;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class BinaryTreeTester {
    List<Integer> list;
    BinarySearchTree<Integer> bst;

    @Before
    public void setup() {
        list = new ArrayList<Integer>(Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 0, -1, 2, 3}));
        bst = new BinarySearchTree<Integer>(Comparator.comparingInt(i -> i));
        list.stream().forEach(i -> bst.insert(i));
    }

    @Test
    public void insertFound() {
        list.stream().forEach(i -> assertNotNull(bst.find(i)));
    }

    @Test
    public void othersNotFound() {
        assertNull(bst.find(6));
        assertNull(bst.find(-3));
        assertNull(bst.find(-4));
    }

    @Test
    public void elemsFound() {
        bst.getElems().stream().forEach(i -> assertNotNull(bst.find(i)));
    }

    @Test
    public void elemsWereAdded() {
    	assertEquals(7, bst.getElems().size());
        bst.getElems().stream().forEach(i -> assertNotNull(list.contains(i)));
    }

    @Test
    public void elemsCorrect() {
    	List<Integer> l = bst.getElems();
    	list.stream().forEach(i -> assertTrue(l.contains(i)));
    }
}