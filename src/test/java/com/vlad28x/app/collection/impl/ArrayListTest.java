package com.vlad28x.app.collection.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {

    private final Comparator<Integer> comparator = Comparator.comparingInt(a -> a);

    @Test
    void constructorCapacitySuccess() {
        Assertions.assertDoesNotThrow(() -> new ArrayList<>(32));
    }

    @Test
    void constructorCapacityFail() {
        assertThrows(IllegalArgumentException.class, () -> new ArrayList<>(-1));
    }

    @Test
    void constructorZeroCapacitySuccess() {
        Assertions.assertDoesNotThrow(() -> new ArrayList<>(0));
    }

    @Test
    void zeroCapacityAddElementSuccess() {
        ArrayList<Integer> arrayList = new ArrayList<>(0);
        Integer element = 11;
        arrayList.add(element);
        assertEquals(element, arrayList.get(0));
    }

    @Test
    void addElementToBeginSuccess() {
        ArrayList<Integer> arrayList = new ArrayList<>(4);
        arrayList.add(0);
        arrayList.add(2);
        arrayList.add(5);
        arrayList.add(777, 0);
        assertEquals(777, arrayList.get(0));
    }

    @Test
    void addElementToEndSuccess() {
        ArrayList<Integer> arrayList = new ArrayList<>(4);
        arrayList.add(0);
        arrayList.add(2);
        arrayList.add(5);
        arrayList.add(777, 3);
        assertEquals(777, arrayList.get(3));
    }

    @Test
    void addElementInMiddleSuccess() {
        ArrayList<Integer> arrayList = new ArrayList<>(4);
        arrayList.add(0);
        arrayList.add(2);
        arrayList.add(5);
        arrayList.add(777, 1);
        assertEquals(777, arrayList.get(1));
    }

    @Test
    void addElementToBeginIncreaseCapacitySuccess() {
        ArrayList<Integer> arrayList = new ArrayList<>(3);
        arrayList.add(0);
        arrayList.add(2);
        arrayList.add(5);
        arrayList.add(777, 0);
        assertEquals(777, arrayList.get(0));
    }

    @Test
    void addElementToEndIncreaseCapacitySuccess() {
        ArrayList<Integer> arrayList = new ArrayList<>(3);
        arrayList.add(0);
        arrayList.add(2);
        arrayList.add(5);
        arrayList.add(777, 3);
        assertEquals(777, arrayList.get(3));
    }

    @Test
    void addElementInMiddleIncreaseCapacitySuccess() {
        ArrayList<Integer> arrayList = new ArrayList<>(3);
        arrayList.add(0);
        arrayList.add(2);
        arrayList.add(5);
        arrayList.add(777, 1);
        assertEquals(777, arrayList.get(1));
    }

    @Test
    void addElementFail() {
        ArrayList<Integer> arrayList = new ArrayList<>(3);
        arrayList.add(0);
        arrayList.add(2);
        arrayList.add(5);
        assertThrows(IllegalArgumentException.class, () ->  arrayList.add(777, 5));
    }

    @Test
    void getElementSuccess() {
        ArrayList<Integer> arrayList = new ArrayList<>(3);
        arrayList.add(0);
        arrayList.add(2);
        arrayList.add(5);
        assertEquals(2, arrayList.get(1));
    }

    @Test
    void getElementFail() {
        ArrayList<Integer> arrayList = new ArrayList<>(3);
        arrayList.add(0);
        arrayList.add(2);
        assertThrows(IllegalArgumentException.class, () -> arrayList.get(2));
    }

    @Test
    void deleteElementFromBeginSuccess() {
        ArrayList<Integer> arrayList = new ArrayList<>(3);
        arrayList.add(0);
        arrayList.add(2);
        arrayList.add(5);
        arrayList.delete(0);
        assertEquals(2, arrayList.get(0));
        assertEquals(2, arrayList.size());
    }

    @Test
    void deleteElementFromMiddleSuccess() {
        ArrayList<Integer> arrayList = new ArrayList<>(3);
        arrayList.add(0);
        arrayList.add(2);
        arrayList.add(5);
        arrayList.delete(1);
        assertEquals(5, arrayList.get(1));
        assertEquals(2, arrayList.size());
    }

    @Test
    void deleteElementFromEndSuccess() {
        ArrayList<Integer> arrayList = new ArrayList<>(3);
        arrayList.add(0);
        arrayList.add(2);
        arrayList.add(5);
        arrayList.delete(2);
        assertEquals(2, arrayList.get(1));
        assertEquals(2, arrayList.size());
    }

    @Test
    void deleteElementSuccess() {
        ArrayList<Integer> arrayList = new ArrayList<>(3);
        arrayList.add(0);
        arrayList.add(2);
        arrayList.add(5);
        arrayList.delete(Integer.valueOf(5));
        assertEquals(2, arrayList.get(1));
        assertEquals(2, arrayList.size());
    }
    @Test
    void deleteElementByValueFail() {
        ArrayList<Integer> arrayList = new ArrayList<>(3);
        arrayList.add(0);
        arrayList.add(2);
        arrayList.add(5);
        assertFalse(arrayList.delete(Integer.valueOf(777)));
    }

    @Test
    void deleteElementByIndexFail() {
        ArrayList<Integer> arrayList = new ArrayList<>(3);
        arrayList.add(0);
        arrayList.add(2);
        arrayList.add(5);
        assertThrows(IllegalArgumentException.class, () -> arrayList.delete(3));
    }

    @Test
    void sortZeroSizeSuccess() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        assertDoesNotThrow(() -> arrayList.sort(comparator));
    }

    @Test
    void sortOneValueSuccess() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(777);
        assertDoesNotThrow(() -> arrayList.sort(comparator));
    }

    @Test
    void sortSomeValuesSuccess() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(777);
        arrayList.add(-1);
        arrayList.add(0);
        arrayList.add(77);
        arrayList.sort(comparator);
        assertEquals("[-1, 0, 77, 777]", arrayList.toString());
    }

}