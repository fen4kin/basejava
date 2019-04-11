package com.fen4kin.webapp.storage;

import com.fen4kin.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index == -1) {                                                  //если резюме не существует
            System.out.println("Resume " + r.getUuid() + " has not found");
        } else {
            storage[index] = r;
        }

    }

    public void save(Resume r) {
        if (getIndex(r.getUuid()) != -1) {
            System.out.println("Resume " + r.getUuid() + " already exists");
        } else if (size == STORAGE_LIMIT) {                                //проверка на переполнение как в примере
            System.out.println("Storage overflow");
        } else {
            storage[size] = r;
            size++;
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Resume " + uuid + " has not found");
            return null;
        }
        return storage[index];
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Resume " + uuid + " has not found");
        } else {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid == storage[i].getUuid()) {
                return i;
            }
        }
        return -1;
    }
}
