package DataStructures;

import java.util.NoSuchElementException;

/**
 * https://docs.oracle.com/javase/7/docs/api/java/util/LinkedList.html
 * @param <E>
 */
public class LinkedList<E> {
    Node<E> head;
    Node<E> tail;
    int size;

    public LinkedList(){}

    private static class Node<E>{
        E item;
        Node<E> next;
        Node<E> prev;

        public Node(Node<E> prev, E element, Node<E> next) {
            this.prev = prev;
            this.item = element;
            this.next = next;
        }
    }

    private Object getValue(Node<E> node){
        return node.item;
    }

    /**
     * Appends the specified element to the end of this list.
     * @param value
     * @return
     */
    public boolean add(E value){
        linkLast(value);
        return true;
    }

    /**
     * returns the number of elements in list
     * @return
     */
    public int size(){
        return size;
    }

    /**
     * add element to the tail of the list
     * @param element
     */
    void linkLast(E element){
        final Node<E> last = tail;
        final Node<E> node = new Node<E>(last, element, null);
        if(last == null){
            head = node;
        }
        else{
            tail = head;
        }
        size++;
    }

    /**
     * removes first element from list
     * @return
     */
    public E remove(){
        return removeFirst();
    }

    /**
     * removes the first element of list, will throw NoSuchElementException if empty
     * @return
     */
    E removeFirst(){
        final Node<E> first = head;
        if(first == null)
            throw new NoSuchElementException();
        return unlinkFirst(first);
    }

    /**
     * unlinks first element of list
     * @param f
     * @return
     */
    E unlinkFirst(Node<E> f){
        final E element = f.item;
        final Node<E> next = f.next;
        f.item = null;
        f.next = null;
        head = next;
        if(next == null){
            tail = null;
        }
        else{
            next.prev = null;
        }
        size--;
        return element;
    }

    /**
     * removes last element of list
     * @return
     */
    private E removeLast(){
        final Node<E> last = tail;
        if(last == null)
            throw new NoSuchElementException();
        return unlinkLast(last);
    }

    /**
     * removes element from linkedlist
     * @param o
     * @return
     */
    public boolean remove(Object o){
        if(o == null){
            for(Node<E> x = head; x != null; x = x.next){
                if(x.item == null){
                    unlink(x);
                    return true;
                }
            }
        }
        else{
            for (Node<E> x = head; x != null; x = x.next) {
                if (x.item.equals(o)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * unlinks the last element from the list
     * @param l
     * @return
     */
    E unlinkLast(Node<E> l){
        final E element = l.item;
        final Node<E> prev = l.prev;
        l.item = null;
        l.prev = null;
        tail = prev;
        if(prev == null){
            head = null;
        }
        else{
            prev.next = null;
        }
        size--;
        return element;
    }

    /**
     * unlinks any element from the list
     * @param node
     * @return
     */
    E unlink(Node<E> node){
        final E element = node.item;
        final Node<E> prev = node.prev;
        final Node<E> next = node.next;

        if(prev == null){
            head = next;
        }
        else{
            prev.next = next;
            node.prev = null;
        }

        if(next == null){
            tail = prev;
        }
        else{
            next.prev = prev;
            node.next = null;
        }
        node.item = null;
        size--;
        return element;
    }
}
