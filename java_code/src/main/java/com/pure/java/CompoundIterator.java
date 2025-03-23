package com.pure.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class CompoundIterator<T> implements Iterator<T> {

    private List<Iterator<T>> iterators;
    private int currentIteratorIndex;

    public CompoundIterator(List<Iterator<T>> iterators) {
        this.iterators = iterators;
        this.currentIteratorIndex = 0;
    }

    @Override
    public boolean hasNext() {
        while (currentIteratorIndex < iterators.size()) {
            if (iterators.get(currentIteratorIndex).hasNext()) {
                return true;
            } else {
                currentIteratorIndex++;
            }
        }
        return false;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return iterators.get(currentIteratorIndex).next();
    }

    // Example Usage
    public static void main(String[] args) {
        List<Integer> list1 = List.of(1, 2, 3);
        List<String> list2 = List.of("a", "b");
        List<Integer> list3 = List.of(4, 5, 6, 7);

        List<Iterator<?>> rawIterators = new ArrayList<>();
        rawIterators.add(list1.iterator());
        rawIterators.add(list2.iterator());
        rawIterators.add(list3.iterator());

        // We need to do some unchecked casting here, but we know the type is consistent within each iterator.
        List<Iterator<Object>> iterators = new ArrayList<>();
        for (Iterator<?> rawIterator : rawIterators) {
            iterators.add((Iterator<Object>) rawIterator);
        }

        CompoundIterator<Object> compoundIterator = new CompoundIterator<>(iterators);

        while (compoundIterator.hasNext()) {
            System.out.print(compoundIterator.next() + " ");
        }
        System.out.println();
    }
}