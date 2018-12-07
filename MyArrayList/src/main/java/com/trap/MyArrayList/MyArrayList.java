package com.trap.MyArrayList;


import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Consumer;


public class MyArrayList<E> implements List<E> {

    private int size;
    private E[] elements;


    public MyArrayList() {

        this.elements = (E[]) Array.newInstance(Object.class, 0);
    }

    public MyArrayList(int size) {
        this.elements = (E[]) Array.newInstance(Object.class,size);
    }

    @Override
    public String toString() {
        return Arrays.toString(elements);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }


    private void add(E e, Object[] elementData, int s) {
        if (s == elementData.length)
            elementData = grow();
        elementData[s] = e;
        size = s + 1;
    }

    @Override
    public boolean add(E e) {
        add(e, elements, size);
        return true;
     }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public E get(int index) {
        return elements[index];
    }

    @Override
    public E set(int index, E element) {
        E oldElement = elements[index];
        elements[index] = element;
        return oldElement;
    }

    @Override
    public void add(int index, E element) {

    }
    private Object[] grow(int minCapacity) {
        return elements = Arrays.copyOf(elements,
                newCapacity(minCapacity));
    }
    private int newCapacity(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = elements.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity <= 0) {
            if (elements == DEFAULTCAPACITY_EMPTY_ELEMENTDATA)
                return Math.max(DEFAULT_CAPACITY, minCapacity);
            if (minCapacity < 0) // overflow
                throw new OutOfMemoryError();
            return minCapacity;
        }
        return (newCapacity - MAX_ARRAY_SIZE <= 0)
                ? newCapacity
                : hugeCapacity(minCapacity);
    }
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    private static final int DEFAULT_CAPACITY = 10;
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE)
                ? Integer.MAX_VALUE
                : MAX_ARRAY_SIZE;
    }
    private Object[] grow() {
        return grow(size +1);
    }
    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
       return new MyListIterator(0) ;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return new MyListIterator(index);
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }


    public class MyIterator implements Iterator<E> {

        int position = 0;
        int lastRet = -1;


        public MyIterator() {
        }

        @Override
        public void forEachRemaining(Consumer<? super E> action) {
            Objects.requireNonNull(action);
            final int size = MyArrayList.this.size;
            int i = position;
            if (i < size) {
                final Object[] es = elements;
                if (i >= es.length)
                    throw new ConcurrentModificationException();
                for (; i < size ; i++)
                    action.accept(elementAt(es, i));
                // update once at end to reduce heap write traffic
                position = i;
                lastRet = i - 1;

            }
        }

        @Override
        public boolean hasNext() {
            return position!=size();
        }


        @Override
        public E next() {

            int i = position;
            if (i >= size)

                throw new NoSuchElementException();
            Object[] elementData = MyArrayList.this.elements;
            if (i >= elementData.length)
                throw new ConcurrentModificationException();
            position = i + 1;
            return (E) elementData[lastRet = i];
        }
        public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();


            try {
                MyArrayList.this.remove(lastRet);
                position = lastRet;
                lastRet = -1;

            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }



    }
    static <E> E elementAt(Object[] es, int index) {
        return (E) es[index];
    }
    public class MyListIterator extends MyIterator implements ListIterator<E> {


        MyListIterator(int index) {
            super();
            position=index;
        }

        @Override
        public boolean hasPrevious() {
            return position!=0;
        }

        @Override
        public E previous() {
            int i = position - 1;
            if (i < 0)
                throw new NoSuchElementException();
            Object[] elementData = MyArrayList.this.elements;
            if (i >= elementData.length)
                throw new ConcurrentModificationException();
            position = i;
            return (E) elementData[lastRet = i];
        }

        @Override
        public int nextIndex() {
            return position;
        }

        @Override
        public int previousIndex() {
            return position-1;
        }


        @Override
        public void set(E e) {
            if (lastRet < 0)
                throw new IllegalStateException();


            try {
                MyArrayList.this.set(lastRet, e);
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }

        }

        @Override
        public void add(E e) {
        }
    }



}