package main;

import java.util.*;
import java.util.function.IntBinaryOperator;

public class Arrays {
    // Общий метод для примитивов
    private static int binarySearchPrimitive(int low, int high, java.util.function.IntFunction<Integer> compare) {
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int cmp = compare.apply(mid);

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

    // Методы для byte[]
    public static int binarySearch(byte[] a, byte key) {
        return binarySearchPrimitive(0, a.length - 1, mid -> Byte.compare(a[mid], key));
    }

    public static int binarySearch(byte[] a, int fromIndex, int toIndex, byte key) {
        return binarySearchPrimitive(fromIndex, toIndex - 1, mid -> Byte.compare(a[mid], key));
    }

    // Методы для char[]
    public static int binarySearch(char[] a, char key) {
        return binarySearchPrimitive(0, a.length - 1, mid -> Character.compare(a[mid], key));
    }

    public static int binarySearch(char[] a, int fromIndex, int toIndex, char key) {
        return binarySearchPrimitive(fromIndex, toIndex - 1, mid -> Character.compare(a[mid], key));
    }

    // Методы для double[]
    public static int binarySearch(double[] a, double key) {
        return binarySearchPrimitive(0, a.length - 1, mid -> Double.compare(a[mid], key));
    }

    public static int binarySearch(double[] a, int fromIndex, int toIndex, double key) {
        return binarySearchPrimitive(fromIndex, toIndex - 1, mid -> Double.compare(a[mid], key));
    }

    // Методы для float[]
    public static int binarySearch(float[] a, float key) {
        return binarySearchPrimitive(0, a.length - 1, mid -> Float.compare(a[mid], key));
    }

    public static int binarySearch(float[] a, int fromIndex, int toIndex, float key) {
        return binarySearchPrimitive(fromIndex, toIndex - 1, mid -> Float.compare(a[mid], key));
    }

    // Методы для int[]
    public static int binarySearch(int[] a, int key) {
        return binarySearchPrimitive(0, a.length - 1, mid -> Integer.compare(a[mid], key));
    }

    public static int binarySearch(int[] a, int fromIndex, int toIndex, int key) {
        return binarySearchPrimitive(fromIndex, toIndex - 1, mid -> Integer.compare(a[mid], key));
    }

    // Методы для long[]
    public static int binarySearch(long[] a, long key) {
        return binarySearchPrimitive(0, a.length - 1, mid -> Long.compare(a[mid], key));
    }

    public static int binarySearch(long[] a, int fromIndex, int toIndex, long key) {
        return binarySearchPrimitive(fromIndex, toIndex - 1, mid -> Long.compare(a[mid], key));
    }

    // Методы для short[]
    public static int binarySearch(short[] a, short key) {
        return binarySearchPrimitive(0, a.length - 1, mid -> Short.compare(a[mid], key));
    }

    public static int binarySearch(short[] a, int fromIndex, int toIndex, short key) {
        return binarySearchPrimitive(fromIndex, toIndex - 1, mid -> Short.compare(a[mid], key));
    }

    // Методы для объектов
    public static <T> int binarySearch(T[] a, T key, Comparator<? super T> c) {
        if (a == null || c == null) {
            throw new NullPointerException("Array or Comparator cannot be null");
        }
        return binarySearchGeneric(a, 0, a.length, key, c);
    }

    public static <T> int binarySearch(T[] a, int fromIndex, int toIndex, T key, Comparator<? super T> c) {
        if (a == null || c == null) {
            throw new NullPointerException("Array or Comparator cannot be null");
        }
        return binarySearchGeneric(a, fromIndex, toIndex, key, c);
    }

    private static <T> int binarySearchGeneric(T[] a, int fromIndex, int toIndex, T key, Comparator<? super T> c) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int cmp = c.compare(a[mid], key);

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