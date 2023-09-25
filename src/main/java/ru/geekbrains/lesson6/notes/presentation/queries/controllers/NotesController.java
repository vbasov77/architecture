package ru.geekbrains.lesson6.notes.presentation.queries.controllers;

import ru.geekbrains.lesson6.notes.core.application.interfaces.NoteEditor;
import ru.geekbrains.lesson6.notes.core.domain.Note;

import java.util.Collection;

public class NotesController extends Controller{

    private final NoteEditor notesEditor;

    public NotesController(NoteEditor notesEditor){
        this.notesEditor = notesEditor;
    }

    public void routeAddNote(Note note){
        this.notesEditor.add(note);
    }

    public void routeRemoveNote(Note note){
        this.notesEditor.remove(note);
    }

    public void routeRemoveNotesAll(Collection<Note> notes){
        this.notesEditor.removeAll(notes);
    }

    public void routeEditCollectionById(int id){
        this.notesEditor.editCollectionById(id);
    }

    public void routeAddInCollection(Note note){
        this.notesEditor.addInCollection(note);
    }

    public void routeGetAll(){
        this.notesEditor.printAll();
    }

    public Collection<Note> routeGetCollection(){
        return this.notesEditor.getAllCollection();
    }

}
