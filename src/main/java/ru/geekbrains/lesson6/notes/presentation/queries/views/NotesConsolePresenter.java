package ru.geekbrains.lesson6.notes.presentation.queries.views;

import ru.geekbrains.lesson6.notes.core.application.interfaces.NotesPresenter;
import ru.geekbrains.lesson6.notes.core.domain.Note;

import java.util.Collection;
import java.util.List;

public class NotesConsolePresenter implements NotesPresenter {
    @Override
    public void printAll(Collection<Note> notes) {
        for (Note note : notes) {
            System.out.println(note);
        }
    }

    @Override
    public void removeAll(Collection<Note> notes) {
        notes.removeAll(notes);
        System.out.println(notes);
    }
}
