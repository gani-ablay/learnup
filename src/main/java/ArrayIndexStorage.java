public class ArrayIndexStorage extends IndexStorage {
    private int[] array;

    public ArrayIndexStorage(int[] array) {
        super(array == null ? 0 : array.length);
        if (array == null) {
            throw new IllegalArgumentException("Массив не должен быть пустым");
        }
        this.array = array;
    }

    @Override
    public int get(int index) {
        if (index < 0 || index >= array.length) {
            throw new IllegalArgumentException("Индекс не может быть отрицательным числом или больше размера массива, а у вас: " + index);
        }
        return array[index];
    }
}
