import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArrayIndexStorageTest {

    @Test
    public void checkNullException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            int arr[] = null;
            ArrayIndexStorage arrayIndexStorage = new ArrayIndexStorage(arr);
        });

        String expectedMessage = "Массив не должен быть пустым";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void checkGet() {
        int arr[] = {10, 2, 7, 3};
        int index = 1;
        ArrayIndexStorage arrayIndexStorage = new ArrayIndexStorage(arr);
        Assertions.assertEquals(arr[index], arrayIndexStorage.get(index));
    }

    @Test
    public void checkNegativeIndexException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            int negativeIndex = -1;
            int arr[] = {10, 2, 7, 3};
            ArrayIndexStorage arrayIndexStorage = new ArrayIndexStorage(arr);
            arrayIndexStorage.get(negativeIndex);
        });

        String expectedMessage = "Индекс не может быть отрицательным числом или больше размера массива";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void checkIndexOutOfBoundsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            int arr[] = {10, 2, 7, 3};
            int negativeIndex = arr.length+1;
            ArrayIndexStorage arrayIndexStorage = new ArrayIndexStorage(arr);
            arrayIndexStorage.get(negativeIndex);
        });

        String expectedMessage = "Индекс не может быть отрицательным числом или больше размера массива";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
