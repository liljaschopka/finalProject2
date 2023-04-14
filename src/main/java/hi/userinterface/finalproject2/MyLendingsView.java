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
public class MyLendingsView extends ListView {

    private LibrarySystem model;

    public MyLendingsView() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("book-view.fxml"));
        fxmlLoader.setRoot(this);   // rótin á viðmótstrénu sett hér
        fxmlLoader.setController(this); // controllerinn settur hér en ekki í .fxml skránni
        try {
            fxmlLoader.load();          // viðmótstréð lesið inn (þ.e. .fxml skráin)
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void setLendings() {
        System.out.println("lendings put");
        getModel();
        setItems(model.getCurrentUser().getLendings());
    }

    public LibrarySystem getModel() {
        return model;
    }

    public void setModel(LibrarySystem model) {
        this.model = model;
    }

}
