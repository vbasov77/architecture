package ru.geekbrains.lesson6.notes.core.application.interfaces;

import ru.geekbrains.lesson6.notes.core.domain.Note;

import java.util.Collection;

public interface NoteEditor extends Editor<Note, Integer> {

    void printAll();

    Collection<Note> getAllCollection();

    boolean removeAll(Collection<Note> notes);

    Collection<Note> addInCollection(Note notes);

    Collection<Note> editCollectionById(Integer id);

}
