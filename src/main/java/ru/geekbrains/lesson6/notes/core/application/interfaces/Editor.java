package ru.geekbrains.lesson6.notes.core.application.interfaces;

import ru.geekbrains.lesson6.notes.core.domain.Note;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface Editor<T, TId> {

    boolean add(T item);

    boolean edit(T item);

    boolean remove(T item);

    boolean removeAll(Collection<T> items);

    Optional<T> getById(TId id);

    Collection<T> getAll();
}
