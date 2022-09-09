package com.vlad28x.app.collection;

public interface Collection<T> {

    int size();

    boolean isEmpty();

    boolean add(T element);

    boolean delete(T element);

}
