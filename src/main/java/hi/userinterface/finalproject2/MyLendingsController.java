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


    public Button Back;

    private LibrarySystem model;



    public void initalize() {
        MyLendings = new ListView<>(model.getCurrentUser().getLendings());
    }

    public void setModel(LibrarySystem model) {
        this.model = model;
    }

    public void fxBackToMenuHandler() {
        ViewSwitcher.switchTo(View.LIBRARY, model);
    }
}
