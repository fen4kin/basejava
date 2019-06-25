package com.fen4kin.webapp.storage;

import com.fen4kin.webapp.exception.StorageException;
import com.fen4kin.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Test;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest {
    private Storage storage;
    protected AbstractArrayStorageTest(Storage storage){
        super(storage);
        this.storage = storage;
    }

    @Test(expected = StorageException.class)
    public void saveOverflow() throws Exception {
        try {
            for (int i = 4; i <= AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume());
            }
        } catch (StorageException e) {
            Assert.fail();
        }
        storage.save(new Resume());
    }
}
