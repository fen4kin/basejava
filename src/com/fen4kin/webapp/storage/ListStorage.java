package com.fen4kin.webapp.storage;

import com.fen4kin.webapp.exception.ExistStorageException;
import com.fen4kin.webapp.exception.NotExistStorageException;
import com.fen4kin.webapp.model.Resume;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private List<Resume> list = new ArrayList<>();

    @Override
    protected void updating(Resume r) {
        Resume newResume = null;
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(r)) {
                newResume = list.get(i);
                index = i;
            }
        }
        if (newResume == null) {
            throw new NotExistStorageException(r.getUuid());
        }
    }

    @Override
    protected void saving(Resume r) {
        for (Resume resume : list) {
            if (resume.equals(r)) {
                throw new ExistStorageException(r.getUuid());
            }
        }
        list.add(r);
    }

    @Override
    protected Resume getting(String uuid) {
        return searchResume(uuid);
    }

    @Override
    protected void deleting(String uuid) {
        Resume r = searchResume(uuid);
        list.remove(r);
    }

    @Override
    public void clear() {
        Collections.fill(list, null);
    }

    @Override
    public Resume[] getAll() {
        return list.toArray(new Resume[0]);
    }

    @Override
    public int size() {
        return list.size();
    }

    private Resume searchResume(String uuid) {
        Resume r = null;
        for (Resume resume : list) {
            if (resume.getUuid().equals(uuid))
                r = resume;
        }
        if (r == null) throw new NotExistStorageException(uuid);
        else return r;
    }
}
