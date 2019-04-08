package com.fen4kin.webapp.storage;

import com.fen4kin.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, null);
        size = 0;
    }

    public void update(Resume r) {
        if (isPresent(getAll(), r)) {
            for (int i = 0; i < size; i++) {
                if (storage[i].equals(r)) {
                    storage[i].setUuid(r.getUuid());    //единственное поле, которое мы можем обновить, это uuid
                }
            }
        } else System.out.println("Resume has not found");
    }

    public void save(Resume r) {
        if (!isPresent(getAll(), r)) {
            storage[size] = r;
            size++;
        } else System.out.println("Resume already exists");

    }

    public Resume get(String uuid) {
        Resume r = null;
        //поиск резюме по uuid. Если его нет, то временная переменная остается пустой
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                r = storage[i];
            }
        }
        //присутсвует ли резюме в заполненной области
        if (isPresent(getAll(), r)) return r;
        else System.out.println("Resume has not found");

        return null;    //без Exception не знаю как обернуть возврат без null
    }

    public void delete(String uuid) {
        Resume r = null;

        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                r = storage[i];
            }
        }

        if (isPresent(getAll(), r)) {
            for (int i = 0; i < size; i++) {
                if (storage[i].equals(r)) {
                    storage[i] = storage[size - 1];
                    storage[size - 1] = null;
                    size--;
                    break;
                }
            }
        } else System.out.println("Resume has not found");
    }


    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    private boolean isPresent(Resume[] temp, Resume r) {
        for (Resume t : temp) {
            if (t.equals(r))     //equals и hashCode переопределила автоматически
                return true;
        }
        return false;
    }
}
