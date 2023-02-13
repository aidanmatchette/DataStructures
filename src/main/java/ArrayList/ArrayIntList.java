package ArrayList;

public class ArrayIntList {
    private int[] elementData;
    private int size;
    public static final int DEFAULT_CAPACITY = 100;

    public ArrayIntList() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayIntList (int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        elementData = new int[capacity];
        size = 0;
    }

    public void add(int value) {
        checkCapacity(size + 1);
        elementData[size] = value;
        size++;
    }

    public void add(int index, int value) {
        checkIndex(index);
        checkCapacity(size + 1);
        for(int i = size; i > index; i--) {
            elementData[i] = elementData[i - 1];
        }
        elementData[index] = value;
        size++;
    }

    public void addAll(ArrayIntList other) {
        checkCapacity(size + other.size);
        for (int i = 0; i < other.size; i++) {
            add(other.elementData[i]);
        }
    }

    public int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if (elementData[i] == value) return i;
        }
        return -1;
    }

    public void remove(int index) {
        checkIndex(index);
        for(int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        size--;
    }

    public boolean contains(int value) {
        return (indexOf(value) >= 0);
    }

    public int size() {
        return size;
    }

    public int get(int index) {
        checkIndex(index);
        return elementData[index];
    }

    public String toString(){
        if (size == 0) {
            return "[]";
        } else {
            StringBuilder result = new StringBuilder("[" + elementData[0]);
            for(int i = 1; i < size; i++) {
                result.append(", ").append(elementData[i]);
            }
            result.append("]");
        return result.toString();
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= elementData.length) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
    }

    private void checkCapacity(int capacity) {
        if (capacity > elementData.length) {
            throw new IllegalStateException("Would exceed capacity");
        }
    }
}
