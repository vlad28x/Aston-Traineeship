package com.vlad28x.task1.collection.impl;


import com.vlad28x.task1.collection.List;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

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

    @Override
    @SuppressWarnings("unchecked")
    public void sort(Comparator<? super T> c) {
        if (c == null) {
            throw new IllegalArgumentException("Comparator mustn't be null");
        }
        if (size == 0) return;
        Object[] aux = new Object[array.length];
        for (int i = 0; i < size; ++i) {
            aux[i] = array[i];
        }
        mergeSort((T[]) array, (T[]) aux, 0, size - 1, c);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayList<?> arrayList = (ArrayList<?>) o;
        return capacity == arrayList.capacity && size == arrayList.size && Arrays.equals(array, arrayList.array);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(capacity, size);
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < size; ++i) {
            if (i == size - 1) {
                builder.append(array[i]);
            } else {
                builder.append(array[i] + ", ");
            }
        }
        builder.append("]");
        return builder.toString();
    }

    public void mergeSort(T[] source, T[] aux, int l, int r, Comparator<? super T> c) {
        if (l == r) return;
        int m = (l + r) / 2;
        mergeSort(source, aux, l, m, c);
        mergeSort(source, aux, m + 1, r, c);
        merge(source, aux, l, m, r, c);
    }

    private void merge(T[] source, T[] aux, int l, int m, int r, Comparator<? super T> c) {
        int i = l, j = m + 1, k = l;
        while (i <= m && j <= r) {
            if (c.compare(source[i], aux[j]) <= 0) {
                aux[k++] = source[i++];
            } else {
                aux[k++] = source[j++];
            }
        }
        while (i <= m) {
            aux[k++] = source[i++];
        }
        for (i = l; i <= r; ++i) {
            source[i] = aux[i];
        }
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
