package hi.userinterface.finalproject2;

import hi.model.LibrarySystem;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;

import java.io.IOException;

/******************************************************************************
 *  Nafn    : Lilja Kolbrún Schopka
 *  T-póstur: lks17@hi.is
 *
 *  Lýsing  :
 *
 *
 *
 *
 *****************************************************************************/
public class BookView extends ListView {

    private LibrarySystem librarySystem = new LibrarySystem();

    public BookView() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("book-view.fxml"));
        fxmlLoader.setRoot(this);   // rótin á viðmótstrénu sett hér
        fxmlLoader.setController(this); // controllerinn settur hér en ekki í .fxml skránni
        try {
            fxmlLoader.load();          // viðmótstréð lesið inn (þ.e. .fxml skráin)
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    /**
     * This method sets the books in the list view in the user interface.
     */
    public void setBooks() {
        librarySystem.setBooks();
        librarySystem.setFxBooks();
        setItems(librarySystem.getFxBooks());
    }
}
