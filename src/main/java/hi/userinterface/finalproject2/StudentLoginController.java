package hi.userinterface.finalproject2;

import hi.model.LibrarySystem;
import hi.model.User;
import hi.model.UserOrBookDoesNotExistException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class StudentLoginController implements ControllerWithModel {

    LibrarySystem model;

    @FXML
    TextField fxName;
    public void initialize() {
        System.out.println("Student Login Controller initialized");
    }

    public void setModel(LibrarySystem model) {
        this.model = model;
    }
    @FXML
    public void handleOKClicked() throws UserOrBookDoesNotExistException {
        System.out.println("OK clidked");
        String name = fxName.getText();
        try {
            User user = model.findUserByName(name);
            model.setCurrentUser(user);
            ViewSwitcher.switchTo(View.LIBRARY, model);
        } catch (UserOrBookDoesNotExistException e) {
            model.addStudentUser(name, true);
            User user = model.findUserByName(name);
            model.setCurrentUser(user);
            ViewSwitcher.switchTo(View.LIBRARY, model);
        }

    }

    @FXML
    public void handleCancelClicked() {
        System.out.println("Cancel clicked");
        ViewSwitcher.switchTo(View.LIBRARY, model);
    }
}
