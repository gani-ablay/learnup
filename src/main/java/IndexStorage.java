public class IndexStorage {
    private int size;

    public IndexStorage(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Размер не может быть отрицательным, а у вас: " + size);
        }
        this.size = size;
    }

    public int size() {
        return size;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Индекс не может быть отрицательным числом или больше размера массива, а у вас: " + index);
        }
        return index % 2 == 0 ? index : -index;
    }

    public int[] reverse() {
        if (size <= 0) {
            throw new IllegalArgumentException("Размер должен быть положительным числом, а у вас: " + size);
        }
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = get(i);
        }

        for (int i = 0; i < array.length / 2; i++) {
            int tmp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = tmp;
        }
        return array;
    }
}
