package com.vlad28x.task1.collection.impl;


import com.vlad28x.task1.collection.List;

public class ArrayList<T> extends AbstractCollection<T> implements List<T> {

    private int capacity;
    private int size;
    private Object[] array;

    public ArrayList() {
        capacity = 16;
        array = new Object[capacity];
    }

    public ArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Illegal capacity");
        }
        this.capacity = capacity;
        array = new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(T element) {
        return add(element, size);
    }

    @Override
    public boolean delete(T element) {
        for (int i = 0; i < size; ++i) {
            if (element.equals(array[i])) {
                return delete(i);
            }
        }
        return false;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index >= size) {
            throw new IllegalArgumentException("Illegal index");
        }
        return (T) array[index];
    }

    @Override
    public boolean add(T element, int index) {
        if (index > size) {
            throw new IllegalArgumentException("Illegal index");
        }
        if (capacity == size) {
            doubleIncreaseCapacity();
        }
        // Shifting
        for (int i = size; i > index; --i) {
            array[i] = array[i - 1];
        }
        array[index] = element;
        ++size;
        return true;
    }

    @Override
    public boolean delete(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Illegal index");
        }
        // Shifting
        for (int i = index; i < size - 1; ++i) {
            array[i] = array[i + 1];
        }
        array[size - 1] = null;
        --size;
        return true;
    }

    private void doubleIncreaseCapacity() {
        if (capacity == 0) {
            capacity = 16;
            array = new Object[capacity];
        } else {
            Object[] oldArray = array;
            capacity *= 2;
            array = new Object[capacity];
            for (int i = 0; i < size; ++i) {
                array[i] = oldArray[i];
            }
        }
    }

}
