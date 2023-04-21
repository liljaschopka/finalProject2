package hi.userinterface.finalproject2;

import hi.model.Lending;
import hi.model.LibrarySystem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

/******************************************************************************
 *  Nafn    : Lilja Kolbrún Schopka
 *  T-póstur: lks17@hi.is
 *
 *  Description  : This is the controller class for the checkout scene.
 *
 *
 *
 *
 *****************************************************************************/
public class CheckOutController implements ControllerWithModel {

    @FXML
    private Button fxCancel;
    @FXML
    private Button fxConfirm;
    @FXML
    private ListView fxLendings;

    private LibrarySystem model;
    private LibraryController libraryController = ViewSwitcher.getController(View.LIBRARY);

    /**
     * Handler for the cancel button
     *
     * @param actionEvent
     */
    @FXML
    public void fxCancelHandler(ActionEvent actionEvent) {
        ViewSwitcher.switchTo(View.LIBRARY, model);
    }

    /**
     * Handler for the confirm button. It adds lendings to the current user and then switches back to the library scene.
     *
     * @param actionEvent
     */
    @FXML
    public void fxConfirmHandler(ActionEvent actionEvent) {
        int size = libraryController.getBooksInBasket().size();
        for (int i = 0; i < size; i++) {
            model.getLendings().add(new Lending(model.getCurrentUser(), libraryController.getBooksInBasket().get(i)));
            model.getCurrentUser().addLending(new Lending(model.getCurrentUser(), libraryController.getBooksInBasket().get(i)));
        }
        ViewSwitcher.switchTo(View.LIBRARY, model);
    }

    public void setModel(LibrarySystem model) {
        this.model = model;
    }

    public void initialize() {
        fxLendings.setItems(libraryController.getBooksInBasket());
    }
}
