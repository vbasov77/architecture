package ru.geekbrains.lesson6.notes.infrastructure.persistance;

import ru.geekbrains.lesson6.database.NotesDatabase;
import ru.geekbrains.lesson6.database.NotesRecord;
import ru.geekbrains.lesson6.notes.core.application.interfaces.NotesDatabaseContext;
import ru.geekbrains.lesson6.notes.core.domain.Note;
import ru.geekbrains.lesson6.notes.infrastructure.persistance.configurations.NoteConfiguration;

import java.util.ArrayList;
import java.util.Collection;

public class NotesDbContext extends DbContext implements NotesDatabaseContext {


    @Override
    public Collection<Note> getAll() {
        Collection<Note> notesList = new ArrayList<>();
        //TODO: Этого кастинга быть не должно, тут должен работать внутренний механизм фреймворка
        for (NotesRecord record : ((NotesDatabase) database).getNotesTable().getRecords()) {
            notesList.add(new Note(
                    record.getId(),
                    record.getUserId(),
                    record.getTitle(),
                    record.getDetails(),
                    record.getCreationDate()
            ));
        }
        return notesList;
    }

    @Override
    public Collection<Note> removeAll() {
        Collection<Note> all = getAll();
        all.clear();
        System.out.println();
        System.out.println("Удалили коллекцию\n" + all);
        return all;
    }

    @Override
    public Collection<Note> addInCollection(Note note) {
        Collection<Note> all = getAll();
        all.add(note);
        System.out.println("Добавили в коллекцию\n" + all);
        return all;
    }

    @Override
    public Collection<Note> editCollectionById(int id) {
        Collection<Note> all = getAll();
        for (Note one : all) {
            if (one.getId() == id) {
                one.setTitle("Edit");
                one.setDetails("Edit");
            }
        }
        System.out.println("Изменили коллекцию\n" + all);
        return all;
    }

    public NotesDbContext(Database database) {
        super(database);
    }

    @Override
    protected void onModelCreating(ModelBuilder builder) {
        builder.applyConfiguration(new NoteConfiguration());
    }


}
