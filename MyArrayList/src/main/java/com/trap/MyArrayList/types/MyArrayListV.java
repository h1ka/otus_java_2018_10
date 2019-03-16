package com.trap.MyArrayList.types;


import java.util.*;
import java.util.stream.Collectors;

public class MyArrayListV<T> implements List<T> {
    private static final int INITIAL_SIZE = 10;

    private T[] array = (T[]) new Object[INITIAL_SIZE];
    private int size = 0;

    public MyArrayListV() {
    }

    public MyArrayListV(int initialSize) {
        array = (T[]) new Object[initialSize];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size ==0;
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(array, size);
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(T t) {
        if(size ==array.length){
            doubling();
        }
        array[size++]=t;
        return true;
    }

    private void doubling() {
        array= Arrays.copyOf(array,array.length*2);
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException();
    }

    @Override
    public T get(int index) {
        return array[index];
    }

    @Override
    public T set(int index, T element) {
        T last = array[index];
        array[index]=element;
        return last;
    }

    @Override
    public void add(int index, T element) {
        array[index]=element;
    }

    @Override
    public T remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<T> listIterator() {
        return new MyListIterator(-1);
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return new MyListIterator(index);
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        String out = Arrays.stream(array).limit(size).map(Object::toString).collect(Collectors.joining(", "));
        return "["+out+"]";
    }
    private class MyIterator implements  Iterator<T>{
        int current = -1;
        @Override
        public boolean hasNext() {
            return current+1< size;
        }

        @Override
        public T next() {
            current++;
            return array[current];
        }
    }
    private class MyListIterator implements ListIterator<T>{
        int current;

        MyListIterator(int current) {
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return current+1 < size;
        }

        @Override
        public T next() {
            current++;
            return array[current];
        }

        @Override
        public boolean hasPrevious() {
            return current > 0;
        }

        @Override
        public T previous() {
            return array[current--];
        }

        @Override
        public int nextIndex() {
            return current+1;
        }

        @Override
        public int previousIndex() {
            return current-1;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void set(T t) {
            array[current] = t;
        }

        @Override
        public void add(T t) {
            MyArrayListV.this.add(t);
        }
    }
}
