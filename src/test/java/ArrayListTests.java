import DataStructures.ArrayList;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ArrayListTests {

    @Test
    public void testAddingElementsToArrayList(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        Assert.assertEquals(0, list.size());
        list.add(5);
        list.add(5);
        list.add(2);
        Assert.assertEquals(3, list.size());
        Assert.assertEquals(5, (int) list.get(0));
        Assert.assertEquals(2, (int) list.get(2));
        list.addAll(Arrays.asList(1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,0));
        Assert.assertEquals(list.size(), 73);
    }

    @Test
    public void testContainsAndRemove(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(5);
        list.add(5);
        list.add(2);
        Assert.assertTrue(list.contains(5));
        Assert.assertFalse(list.contains(0));
    }

}
