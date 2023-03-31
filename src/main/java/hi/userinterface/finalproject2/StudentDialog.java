package hi.userinterface.finalproject2;

import hi.model.Student;
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
public class StudentDialog extends Dialog<Student> {

    @FXML
    private TextField fxName;
    @FXML
    private ButtonType fxConfirm;
    @FXML
    private ButtonType fxCancel;

    private Student student;

    public StudentDialog(Student s) {
        student = s;
        readStudentDialog();
        okRule();

        fxName.textProperty().bindBidirectional(s.getName());

        setResultConverter(b -> {
            if (b.getButtonData() == ButtonBar.ButtonData.OK_DONE) {
                return s;
            } else {
                return null;
            }
        });
    }

    private DialogPane readStudentDialog() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("student-view.fxml"));
        try {
            fxmlLoader.setController(this);
            DialogPane dialogPane = fxmlLoader.load();
            return dialogPane;
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    private void okRule() {
        // fletta upp í lagi hnappnum út frá hnappategund
        Node iLagi = getDialogPane().lookupButton(fxConfirm);
        iLagi.disableProperty()
                .bind(fxName.textProperty().isEmpty());
    }
}
