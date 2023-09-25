package ru.geekbrains.lesson6.notes.core.application.interfaces;

import ru.geekbrains.lesson6.notes.core.domain.Note;

import java.util.Collection;

public interface NotesDatabaseContext {

    Collection<Note> getAll();

    Collection<Note> removeAll();

    Collection<Note> addInCollection(Note note);

    boolean saveChanges();

    Collection<Note> editCollectionById(int id);

}
