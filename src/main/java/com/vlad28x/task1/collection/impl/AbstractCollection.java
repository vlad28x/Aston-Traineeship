package com.vlad28x.task1.collection.impl;


import com.vlad28x.task1.collection.Collection;

public abstract class AbstractCollection<T> implements Collection<T> {

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

}
