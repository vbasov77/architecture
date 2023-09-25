package ru.geekbrains.lesson6;


import ru.geekbrains.lesson6.database.NotesDatabase;
import ru.geekbrains.lesson6.database.NotesRecord;
import ru.geekbrains.lesson6.database.NotesTable;
import ru.geekbrains.lesson6.notes.core.application.ConcreteNoteEditor;
import ru.geekbrains.lesson6.notes.core.domain.Note;
import ru.geekbrains.lesson6.notes.infrastructure.persistance.NotesDbContext;
import ru.geekbrains.lesson6.notes.presentation.queries.controllers.NotesController;
import ru.geekbrains.lesson6.notes.presentation.queries.views.NotesConsolePresenter;

import java.util.Collection;

public class Program {


    public static void main(String[] args) {

        NotesController controller = new NotesController(
                new ConcreteNoteEditor(new NotesDbContext(new NotesDatabase()), new NotesConsolePresenter()));

        controller.routeGetAll();


        //Удаление коллекции
        controller.routeRemoveNotesAll(controller.routeGetCollection());

        // Добавление в коллекцию
        Note note = new Note();
        note.setId(1006);
        note.setTitle("MyTitle");
        note.setDetails("MyDetails");
        controller.routeAddInCollection(note);

        //Редактирование
        controller.routeEditCollectionById(1001);






    }

}
