package wkda.repository;

import wkda.domain.MockData;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class MockRepository<T extends MockData> {
    protected List<T> data = new ArrayList<>();
    private AtomicInteger idGenerator = new AtomicInteger(Integer.MIN_VALUE);

    public List<T> findAll() {
        return this.data;
    }

    public T findById(int id) {
        return this.data.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    public void update(int id, T newData) {
        T existingData = findById(id);
        data.remove(existingData);
        data.add(newData);
    }

    public T add(T newData) {
        newData.setId(idGenerator.incrementAndGet());
        data.add(newData);
        return newData;
    }

    public void delete(int id) {
        T existingData = findById(id);
        data.remove(existingData);
    }
}
