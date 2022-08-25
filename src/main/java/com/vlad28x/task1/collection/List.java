package com.vlad28x.task1.collection;

public interface List<T> extends Collection<T> {

    T get(int index);
    boolean add(T element, int index);
    boolean delete(int index);

}
