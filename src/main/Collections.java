package main;

import java.util.*;
import java.util.function.IntBinaryOperator;

class Collections {

    // Методы для списков
    public static <T extends Comparable<? super T>> int binarySearch(List<? extends T> list, T key) {
        return binarySearch(list, key, Comparator.naturalOrder());
    }

    public static <T> int binarySearch(List<? extends T> list, T key, Comparator<? super T> c) {
        if (list == null || c == null) {
            throw new NullPointerException("List or Comparator cannot be null");
        }

        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            T midVal = list.get(mid);
            int cmp = c.compare(midVal, key);

            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -(low + 1);
    }
}
