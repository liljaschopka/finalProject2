package hi.userinterface.finalproject2;

import hi.model.LibrarySystem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class LibraryController {
    @FXML
    private ListView fxYourBooks;
    @FXML
    private ListView fxBookshelf;
    @FXML
    private Button fxCheckout;
    @FXML
    private Button fxAdd;
    @FXML
    private Button fxReturn;
    @FXML
    private Button fxSignIn;

    public void fxSignInHandler(ActionEvent actionEvent) {
        
    }

    LibrarySystem librarySystem = new LibrarySystem();
}
