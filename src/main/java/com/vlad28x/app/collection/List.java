package com.vlad28x.app.collection;

import java.util.Comparator;

public interface List<T> extends Collection<T> {

    T get(int index);

    boolean add(T element, int index);

    boolean delete(int index);

    void sort(Comparator<? super T> c);

}
