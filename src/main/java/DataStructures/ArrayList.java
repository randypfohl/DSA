package DataStructures;
import java.util.Arrays;
import java.util.Collection;

/**
 * Based on the api listed above and keeping the common interface from the java util package.
 * https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
 */

public class ArrayList<E>{
    private static final int INITIAL_CAPACITY = 10;
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    private Object[] elementArray;
    private int size;

    public ArrayList(){
        elementArray = new Object[INITIAL_CAPACITY];
    }

    public ArrayList(Collection<? extends E> collection){
        elementArray = collection.toArray();
    }
    public ArrayList(int initialCapacity){
        elementArray = new Object[initialCapacity];
    }

    /**
     * Appends the specified element to the end of this list.
     * @param object
     * @return
     */
    public boolean add(E object){
        ensureCapacity(size + 1);
        elementArray[size++] = object;
        return true;
    }

    /**
     * Inserts the specified element at the specified position in this list.
     * @param index
     * @param object
     */
    public void add(int index, E object){
        rangeCheck(index);

        ensureCapacity(size + 1);
        System.arraycopy(elementArray, index, elementArray, index + 1, size - index);
        elementArray[index] = object;
        size++;
    }

    private void rangeCheck(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }

    /**
     * Appends all of the elements in the specified collection to the end of this list, in the order that they are returned by the specified collection's Iterator.
     * @param collection
     * @return
     */
    public boolean addAll(Collection<? extends E> collection){
        Object[] arr = collection.toArray();
        int newSize = arr.length;
        ensureCapacity(size + newSize);
        System.arraycopy(arr, 0, elementArray, size, newSize);
        size += newSize;
        return newSize != 0;
    }

    /**
     * Inserts all of the elements in the specified collection into this list, starting at the specified position.
     * @param index
     * @param collection
     * @return
     */
    public boolean addAll(int index, Collection<? extends E> collection){
        rangeCheck(index);
        Object[] arr = collection.toArray();
        int newSize = arr.length;
        ensureCapacity(size + newSize);

        int numMoved = size - index;
        if (numMoved > 0)
            System.arraycopy(elementArray, index, elementArray, index + newSize,
                    numMoved);

        System.arraycopy(arr, 0, elementArray, index, newSize);
        size += newSize;
        return newSize != 0;
    }

    /**
     * Removes all of the elements from this list.
     */
    public void clear(){
        for (int i = 0; i < size; i++)
            elementArray[i] = null;

        size = 0;
    }

    /**
     * Returns the element at the specified position in this list.
     * @param index
     * @return
     */
    @SuppressWarnings("unchecked")
    public E get(int index) {
        rangeCheck(index);
        return (E) elementArray[index];
    }

    /**
     * Returns the number of elements in this list.
     * @return
     */
    public int size() { return size;}

    /**
     * Returns true if this list contains the specified element.
     * @param object
     * @return
     */
    public boolean contains(E object) {
        for (int i = 0; i < size; i++)
            if (object.equals(elementArray[i]))
                return true;
        return false;
    }

    /**
     * Increases the capacity of this ArrayList instance, if necessary, to ensure that it can hold at least the number of elements specified by the minimum capacity argument.
     * @param minCapacity
     */
    public void ensureCapacity(int minCapacity){
        if(minCapacity > elementArray.length) grow(minCapacity);
    }

    private void grow(int minCapacity){
        int oldCapacity = elementArray.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if(newCapacity - minCapacity < 0) newCapacity =  minCapacity;
        if(newCapacity > MAX_ARRAY_SIZE) newCapacity = MAX_ARRAY_SIZE;
        elementArray = Arrays.copyOf(elementArray, newCapacity);
    }

}
