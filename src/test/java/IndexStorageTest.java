import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IndexStorageTest {

    @Test
    public void checkZeroSizeException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            int size = 0;
            IndexStorage indexStorage = new IndexStorage(size);
            indexStorage.reverse();
        });

        String expectedMessage = "Размер должен быть положительным числом";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void checkReverseAndSize() {
        int size = 5;
        IndexStorage indexStorage = new IndexStorage(size);
        Assertions.assertEquals(size, indexStorage.size());
        Assertions.assertEquals(size, indexStorage.reverse().length);
    }

    @Test
    public void checkNegativeSizeException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            int size = -1;
            IndexStorage indexStorage = new IndexStorage(size);
        });

        String expectedMessage = "Размер не может быть отрицательным";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void checkGetNegativeIndexException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            int size = 5;
            int index = -1;
            IndexStorage indexStorage = new IndexStorage(size);
            indexStorage.get(index);
        });

        String expectedMessage = "Индекс не может быть отрицательным числом или больше размера массива";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void checkGetOutOfBoundsIndexException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            int size = 5;
            int index = size + 1;
            IndexStorage indexStorage = new IndexStorage(size);
            indexStorage.get(index);
        });

        String expectedMessage = "Индекс не может быть отрицательным числом или больше размера массива";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

}
