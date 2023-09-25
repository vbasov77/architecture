package ru.geekbrains.lesson6.notes.core.application;

import ru.geekbrains.lesson6.notes.core.application.interfaces.NoteEditor;
import ru.geekbrains.lesson6.notes.core.application.interfaces.NotesDatabaseContext;
import ru.geekbrains.lesson6.notes.core.application.interfaces.NotesPresenter;
import ru.geekbrains.lesson6.notes.core.domain.Note;

import java.util.*;

public class ConcreteNoteEditor implements NoteEditor {

    private final NotesDatabaseContext dbContext;
    private final NotesPresenter notesPresenter;


    public ConcreteNoteEditor(NotesDatabaseContext dbContext,
                              NotesPresenter notesPresenter) {
        this.dbContext = dbContext;
        this.notesPresenter = notesPresenter;
    }

    @Override
    public boolean add(Note item) {
        dbContext.getAll().add(item);
        return dbContext.saveChanges();
    }

    @Override
    public boolean edit(Note item) {
        if (item == null)
            return false;
        Optional<Note> note = getById(item.getId());
        if (note.isEmpty())
            return false;
        note.get().setTitle(item.getTitle());
        note.get().setDetails(item.getDetails());
        note.get().setEditDate(new Date());
        return dbContext.saveChanges();
    }
    @Override
    public boolean remove(Note item) {
        dbContext.getAll().remove(item);
        return dbContext.saveChanges();
    }

    public boolean removeAll(Collection<Note> notes){
        return dbContext.removeAll().removeAll(notes);
    }

    @Override
    public Collection<Note> addInCollection(Note note) {
        return dbContext.addInCollection(note);
    }

    @Override
    public Collection<Note> editCollectionById(Integer id) {
        return dbContext.editCollectionById(id);
    }


    @Override
    public Optional<Note> getById(Integer id) {
        return dbContext.getAll().stream().filter(p -> p.getId() == id).findFirst();
    }

    @Override
    public Collection<Note> getAll() {
        return dbContext.getAll();
    }

    @Override
    public void printAll() {
        notesPresenter.printAll(getAll());
    }

    @Override
    public Collection<Note> getAllCollection() {
        return dbContext.getAll();
    }



}