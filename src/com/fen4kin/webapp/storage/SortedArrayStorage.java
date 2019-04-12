package com.fen4kin.webapp.storage;

import com.fen4kin.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    @Override
    protected void fillDeletedElement(int index) {
        int dif = size - index - 1;
        if (dif > 0) {
            System.arraycopy(storage, index + 1, storage, index, dif);
        }
    }

    @Override
    protected void insertElement(Resume r, int index) {
        int newIndex = -index - 1;
        System.arraycopy(storage, newIndex, storage, newIndex + 1, size - newIndex);
        storage[newIndex] = r;

    }
}
