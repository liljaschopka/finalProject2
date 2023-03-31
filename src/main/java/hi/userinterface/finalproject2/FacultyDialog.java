package hi.userinterface.finalproject2;

import hi.model.FacultyMember;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;

import java.io.IOException;

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
public class FacultyDialog extends Dialog<FacultyMember> {

    @FXML
    private TextField fxName;
    @FXML
    private TextField fxDepartment;
    @FXML
    private ButtonType fxConfirm;
    @FXML
    private ButtonType fxCancel;

    private FacultyMember facultyMember;

    public FacultyDialog(FacultyMember fm) {
        facultyMember = fm;
        readFacultyMemeberDialog();
        okRule();

        fxName.textProperty().bindBidirectional(fm.getName());
        fxDepartment.textProperty().bindBidirectional(fm.getDepartment());

        setResultConverter(b -> {
            if (b.getButtonData() == ButtonBar.ButtonData.OK_DONE) {
                return fm;
            } else {
                return null;
            }
        });
    }

    private DialogPane readFacultyMemeberDialog() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("faculty-view.fxml"));
        try {
            fxmlLoader.setController(this);
            DialogPane dialogPane = fxmlLoader.load();
            return dialogPane;
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    private void okRule() {
        Node ok = getDialogPane().lookupButton(fxConfirm);
        ok.disableProperty()
                .bind(fxName.textProperty().isEmpty());
    }
}
