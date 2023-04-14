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
 *  Lýsing  :
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

    @FXML
    public void fxCancelHandler(ActionEvent actionEvent) {
        ViewSwitcher.switchTo(View.LIBRARY, model);
    }

    @FXML
    public void fxConfirmHandler(ActionEvent actionEvent) {
        int size = libraryController.getBooksInBasket().size();
        for (int i = 0; i < size; i++) {
            //Lending l = new Lending(model.getCurrentUser(), libraryController.getBooksInBasket().get(i));
            System.out.println("user:" + model.getCurrentUser().getName());
            System.out.println("book" + i + "in basket: " + libraryController.getBooksInBasket().get(i).getTitle());
            model.getLendings().add(new Lending(model.getCurrentUser(), libraryController.getBooksInBasket().get(i)));
            model.getCurrentUser().addLending(new Lending(model.getCurrentUser(), libraryController.getBooksInBasket().get(i)));
            //l = null;
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
