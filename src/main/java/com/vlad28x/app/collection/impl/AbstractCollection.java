package com.vlad28x.app.collection.impl;


import com.vlad28x.app.collection.Collection;

public abstract class AbstractCollection<T> implements Collection<T> {

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

}
