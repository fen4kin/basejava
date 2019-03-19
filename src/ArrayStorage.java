import java.util.*;

/**
 * Array based storage for Resumes
 * <p>
 * Второй вариант решения, без карты (если вдруг при проверке кто наткнется на первое)
 * <p>
 * Все действия реализуются непосредственно с массивом storage.
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size = 0;

    void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    void save(Resume r) {
        storage[size] = r;
        size++;
    }

    Resume get(String uuid) {
        int index = 0;
            for (int i = 0; i < size; i++) {
                if (storage[i].uuid.equals(uuid)) {
                    index = i;
                }
            }
        return storage[index];
    }

    void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = storage[size - 1];
                storage[size - 1] = null;
                size--;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] array = new Resume[size];
        for (int i = 0; i < size; i++) {
            array[i] = storage[i];
        }
        return array;
    }

    int size() {
        return size;
    }
}
