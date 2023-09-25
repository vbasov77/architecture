package ru.geekbrains.lesson6.notes.core.application.interfaces;

import ru.geekbrains.lesson6.notes.core.domain.Note;

import java.util.Collection;
import java.util.List;

public interface NotesPresenter {

    void printAll(Collection<Note> notes);
    void removeAll(Collection<Note> notes);
}
