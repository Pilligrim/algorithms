package ru.geekbrains.algorithms.arrays;

public class Array {
    private int[] arr;
    private int size;
    private boolean isSorted;

    private Array() {
        this.isSorted = false;
    }

    public Array(int capacity) {
        this();
        arr = new int[capacity];
        this.size = 0;
    }

    public Array(int... args) {
        this();
        this.size = args.length;
        this.arr = args;
    }

    public int get(int index) {
        if (index >= size || index < 0)
            throw new ArrayIndexOutOfBoundsException(index);
        return arr[index];
    }

    public void set(int index, int value) {
        if (index >= size || index < 0)
            throw new ArrayIndexOutOfBoundsException(index);
        arr[index] = value;
    }

    public int length() {
        return size;
    }

    private void increaseCapacity() {
        int[] temp = arr;
        arr = new int[size * 2];
        System.arraycopy(temp, 0, arr, 0, size);
    }

    public void append(int value) {
        verifyCapacity();
        arr[size++] = value;
        isSorted = false;
    }

    public void insert(int inx, int value) {
        if (inx < 0 || inx >= size) {
            throw new ArrayIndexOutOfBoundsException(inx);
        } else {
            verifyCapacity();
            copyRightOfInx(inx);
            arr[inx] = value;
            size++;
        }
    }

    public void verifyCapacity() {
        if (size >= arr.length) {
            increaseCapacity();
        }
    }

    private void copyLeftOfInx(int inx) {
        System.arraycopy(arr, inx + 1, arr, inx, size - inx - 1);
    }

    private void copyRightOfInx(int inx) {
        System.arraycopy(arr, inx, arr, inx + 1, size - inx - 1);
    }

    public int deleteLast() {
        if (size == 0)
            throw new ArrayIndexOutOfBoundsException(-1);
        return arr[--size];
    }

    public boolean deleteAll(int value) {
        boolean result = false;
        for (int i = 0; i < size; i++) {
            if (arr[i] == value) {
                delete(i--);
                result = true;
            }
        }
        return result;
    }

    void deleteAll() {
        size = 0;
    }


    public boolean delete(int index) {
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        copyLeftOfInx(index);
        size--;
        return true;
    }

    @Override
    public String toString() {
        if (arr == null) return "null";
        int iMax = size - 1;
        if (iMax == -1) return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        int i = 0;
        while (true) {
            b.append(arr[i]);
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
            i++;
        }
    }

    public int find(int value) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == value)
                return i;
        }
        return -1;
    }

    public boolean hasValue(int value) {
        if (!isSorted)
            throw new RuntimeException("try the 'find' method");

        int l = 0;
        int r = size;
        int m;
        while (l < r) {
            m = (l + r) >> 1; // (l + r) / 2
            if (value == arr[m])
                return true;
            else if (value < arr[m])
                r = m;
            else
                l = m + 1;
        }
        return false;
    }

    private void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public int sortBubble() {
        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    count++;
                    swap(j, j + 1);
                }
            }
        }
        isSorted = true;
        return count;
    }

    public int sortSelect() {
        int count = 0;
        for (int flag = 0; flag < size; flag++) {
            int cMin = flag;
            for (int rem = flag + 1; rem < size; rem++) {
                count++;
                if (arr[rem] < arr[cMin])
                    cMin = rem;
            }
            swap(flag, cMin);
        }
        isSorted = true;
        return count;
    }

    public int sortInsert() {
        int count = 0;
        for (int out = 0; out < size; out++) {
            int temp = arr[out];
            int in = out;
            while (in > 0 && arr[in - 1] >= temp) {
                count++;
                arr[in] = arr[in - 1];
                in--;
            }
            arr[in] = temp;
        }
        isSorted = true;
        return count;
    }

    public int countingSort() {
        int count = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int element : arr) {
            count++;
            if (element < min) {
                min = element;
            }
            if (element > max) {
                max = element;
            }
        }
        int[] elemCounts = new int[max - min + 1];
        for (int elem : arr) {
            count++;
            elemCounts[elem - min]++;
        }
        int arrInx = 0;
        for (int i = 0; i < elemCounts.length; i++) {
            for (int j = elemCounts[i]; j > 0; j--) {
                count++;
                arr[arrInx++] = i + min;
            }
        }
        return count;
    }
}
