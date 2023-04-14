package hi.userinterface.finalproject2;

import hi.model.Lending;
import hi.model.LibrarySystem;
import javafx.collections.ObservableList;
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
    private LibraryController libraryController = ViewSwitcher.getController(View.LIBRARY);


    public void initalize() {
        model = libraryController.getModel();
        MyLendings = new ListView<>(model.getCurrentUser().getLendings());
    }

    public void setModel(LibrarySystem model) {
        this.model = model;
    }

    @Override
    public void updateFromModel() {
        ObservableList<Lending> lendinglist = model.getCurrentUser().getLendings();
        if (!lendinglist.isEmpty()) {
            MyLendings = new ListView<>(lendinglist);
        }
    }

    public void fxBackToMenuHandler() {
        ViewSwitcher.switchTo(View.LIBRARY, model);
    }
}
