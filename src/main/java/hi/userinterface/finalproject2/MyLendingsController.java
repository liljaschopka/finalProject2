package hi.userinterface.finalproject2;

import hi.model.Book;
import hi.model.Lending;
import hi.model.LibrarySystem;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class MyLendingsController implements ControllerWithModel, ControllerUsingModelInInInitialize {
    @FXML
    public ListView<Lending> fxMyLendings;
    @FXML
    public MyLendingsView fxMyLendingsView;
    @FXML
    public Button fxReturnBook;

    public Button Back;
    private LibrarySystem model;
    private LibraryController libraryController = ViewSwitcher.getController(View.LIBRARY);


    public void initialize() {
        model = libraryController.getModel();
        fxMyLendingsView.setModel(model);
        fxMyLendingsView.setLendings();
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
            fxMyLendings = new ListView<>(lendinglist);
        }
    }

    public void fxBackToMenuHandler() {
        ViewSwitcher.switchTo(View.LIBRARY, model);
    }

    public void fxReturnBookHandler() {
        if (fxMyLendingsView.getSelectionModel().getSelectedItem() == null) {
            fxMyLendingsView.getSelectionModel().clearSelection();
            System.out.println("No book selected");
        } else {
            Lending lendingToReturn = (Lending) fxMyLendingsView.getSelectionModel().getSelectedItem();
            Book bookToReturn = ((Lending) fxMyLendingsView.getSelectionModel().getSelectedItem()).getBook();
            System.out.println(model.getCurrentUser().getLendings().size());
            try {
                model.returnBook(bookToReturn);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            model.getCurrentUser().removeLending(lendingToReturn);
            fxMyLendings.getItems().remove(lendingToReturn);
            fxMyLendings.getSelectionModel().clearSelection();
            System.out.println(model.getCurrentUser().getLendings().size());
        }
    }
}
