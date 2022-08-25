package com.vlad28x.task1.collection.impl;


import com.vlad28x.task1.collection.List;

public class ArrayList<T> extends AbstractCollection<T> implements List<T> {

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean add(T item) {
        return false;
    }

    @Override
    public boolean delete(T item) {
        return false;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public boolean add(T element, int index) {
        return false;
    }

    @Override
    public boolean delete(int index) {
        return false;
    }
}
