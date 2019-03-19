import java.util.*;

/**
 * Array based storage for Resumes
 * <p>
 * Все действия в методах основаны на мапе, так как с ее помощью удобно получать доступ
 * как к экземпляру класса Resume, так и к его переменной. Более очевидных способов я не нашла.
 * <p>
 * При каждом взаимодействии с размером массива его приходится обнулять, иначе происходили бы лишние записи,
 * вроде uuid1, uuid1, uuid2, uuid1, uuid2, uuid3 при методе save(). Да и метод delete() по-другому просто не реализовать.
 * <p>
 * Как я уже писала, в моем решении все операции происходят в мапе.
 * Я не знала насколько необходимо каждый раз делать изменения именно в массиве storage.
 * Хоть и в моем варианте решения в массиве просто нет необходимости, я предполагаю, что есть какие-то "подводные камни",
 * вроде занимаемой памяти, быстродействия работы и совместимости с чем-то еще,
 * поэтому изменения storage все же затрагивали.
 */
public class ArrayStorage {
    private HashMap<String, Resume> mapOfResume = new HashMap<String, Resume>();
    private Resume[] storage = new Resume[10000];

    void clear() {
        mapOfResume.clear();
        Arrays.fill(storage, null);
    }

    void save(Resume r) {
        mapOfResume.put(r.uuid, r);
        Arrays.fill(storage, null);
        mapOfResume.values().toArray(storage);
    }

    Resume get(String uuid) {
        return mapOfResume.get(uuid);
    }

    void delete(String uuid) {
        Arrays.fill(storage, null);
        mapOfResume.remove(uuid);
        mapOfResume.values().toArray(storage);
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] array = new Resume[mapOfResume.size()];
        mapOfResume.values().toArray(array);
        return array;
    }

    int size() {
        return mapOfResume.size();
    }
}
