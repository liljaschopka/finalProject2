package hi.userinterface.finalproject2;

import hi.model.Lending;
import hi.model.LibrarySystem;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class MyLendingsController implements ControllerWithModel, ControllerUsingModelInInInitialize {
    @FXML
    public ListView<Lending> MyLendings;

    @FXML
    public Button ReturnBook;


    public Button Back;

    private LibrarySystem model;
    private LibraryController libraryController = ViewSwitcher.getController(View.LIBRARY);


    public void initialize() {
        model = libraryController.getModel();
        MyLendings.setItems(model.getCurrentUser().getLendings());
        int size = model.getCurrentUser().getLendings().size();
        for (int i = 0; i < size; i++) {
            System.out.println(model.getCurrentUser().getLendings().get(i).getBook().getTitle());
        }
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
