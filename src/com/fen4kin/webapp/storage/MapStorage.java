package com.fen4kin.webapp.storage;

import com.fen4kin.webapp.model.Resume;

public class MapStorage extends AbstractStorage {
    @Override
    protected void updating(Resume r) {

    }

    @Override
    protected void saving(Resume r) {

    }

    @Override
    protected Resume getting(String uuid) {
        return null;
    }

    @Override
    protected void deleting(String uuid) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    public int size() {
        return 0;
    }
}
