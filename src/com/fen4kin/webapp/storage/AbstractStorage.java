package com.fen4kin.webapp.storage;

import com.fen4kin.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    @Override
    public void update(Resume r) {
        updating(r);
    }

    @Override
    public void save(Resume r) {
        saving(r);
    }

    @Override
    public Resume get(String uuid) {
        return getting(uuid);
    }

    @Override
    public void delete(String uuid) {
        deleting(uuid);
    }

    protected abstract void updating(Resume r);
    protected abstract void saving(Resume r);
    protected abstract Resume getting(String uuid);
    protected abstract void deleting(String uuid);
}
