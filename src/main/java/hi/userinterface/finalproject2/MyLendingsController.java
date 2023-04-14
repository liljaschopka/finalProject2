package hi.userinterface.finalproject2;

import hi.model.Lending;
import hi.model.LibrarySystem;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class MyLendingsController implements ControllerWithModel {
    @FXML
    public ListView<Lending> MyLendings;

    @FXML
    public Button ReturnBook;
    @FXML
    public Button Back;
    private LibrarySystem model;
    private LibraryController libraryController = ViewSwitcher.getController(View.LIBRARY);

    public void initalize() {
        model = libraryController.getModel();
        MyLendings = new ListView<>(model.getCurrentUser().getLendings());
    }

    public void setModel(LibrarySystem model) {
        this.model = model;
    }

    public void fxBackToMenuHandler() {
        ViewSwitcher.switchTo(View.LIBRARY, model);
    }
}
