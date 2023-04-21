package hi.userinterface.finalproject2;

import hi.model.FacultyMember;
import hi.model.LibrarySystem;
import hi.model.User;
import hi.model.UserOrBookDoesNotExistException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class FacultyLoginController implements ControllerWithModel {
    LibrarySystem model;

    @FXML
    TextField fxName;
    @FXML
    TextField fxDepartment;

    public void initialize() {
        System.out.println("Faculty Login Controller initialized");
    }

    public void setModel(LibrarySystem model) {
        this.model = model;
    }

    private void switchToLibrary(User user) {
        model.setCurrentUser(user);
        ViewSwitcher.switchTo(View.LIBRARY, model);
    }

    @FXML
    public void handleOKClicked() throws UserOrBookDoesNotExistException {
        String name = fxName.getText();
        String department = fxDepartment.getText();
        try {
            FacultyMember user = model.findFaculty(name, department);
            switchToLibrary(user);
        } catch (UserOrBookDoesNotExistException e) {
            model.addFacultyMemberUser(name, department);
            User user = model.findFaculty(name, department);
            switchToLibrary(user);
        }
    }


    @FXML
    public void handleCancelClicked() {
        ViewSwitcher.switchTo(View.LIBRARY, model);
    }
}
