package hi.userinterface.finalproject2;

import hi.model.Book;
import hi.model.FacultyMember;
import hi.model.LibrarySystem;
import hi.model.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class LibraryController implements ControllerWithModel {
    @FXML
    private ListView<Book> fxYourBooks;
    @FXML
    private BookView fxBookshelf;
    @FXML
    private Button fxCheckout;
    @FXML
    private Button fxAdd;
    @FXML
    private Button fxReturn;
    @FXML
    private Button fxSignInStudent;
    @FXML
    private Button fxSignInFaculty;
    @FXML
    private Label fxName;
    private Student student;
    private FacultyMember facultyMember;

    private Stage primaryStage;

    private LibrarySystem model;

    @FXML
    public void fxSignInStudentHandler() {
        //Student newStudent = new Student("", true);
        //StudentDialog s = new StudentDialog(newStudent);
        //Optional<Student> result = s.showAndWait();
        //result.ifPresent(value -> fxName.setText(value.getName()));
        //librarySystem.addStudentUser(newStudent.getName(), newStudent.isFeePaid());
        //student = newStudent;
        ViewSwitcher.switchTo(View.STUDENT, model);
    }


    public void switchToLibraryView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("library-view.fxml"));
        Parent root = loader.load();
        LibraryController controller = loader.getController();
        controller.setModel(model);

        Scene scene = new Scene(root);
        Stage stage = (Stage) primaryStage.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void setModel(LibrarySystem model) {
        this.model = model;
    }




    public void fxSignInFacultyHandler(ActionEvent actionEvent) {
        FacultyMember newFaculty = new FacultyMember("", "");
        FacultyDialog f = new FacultyDialog(newFaculty);
        Optional<FacultyMember> result = f.showAndWait();
        result.ifPresent(value -> fxName.setText(value.getName()));
        model.addFacultyMemberUser(newFaculty.getName(), newFaculty.getDepartment());
        facultyMember = newFaculty;
    }

    @FXML
    public void fxAddBookHandler(ActionEvent actionEvent) {
        if (student != null || facultyMember != null) {
            fxBookshelf.getSelectionModel().getSelectedItems().forEach(selected -> {
                fxYourBooks.getItems().add((Book) selected);
            });
           /* if(student == null){
                librarySystem.getFxLendings().add(new Lending(facultyMember, (Book) fxBookshelf.getSelectionModel().getSelectedItem()));
            }else{
                librarySystem.getFxLendings().add(new Lending(student, (Book) fxBookshelf.getSelectionModel().getSelectedItem()));
            }*/
        } else {
            fxAdd.setDisable(true);
            fxCheckout.setDisable(true);
            fxReturn.setDisable(true);
        }

    }

    @FXML
    public void fxRemoveBookHandler(ActionEvent actionEvent) {
        Book selected = fxYourBooks.getSelectionModel().getSelectedItem();
        fxYourBooks.getItems().remove(selected);
    }

    public void initialize() {
        fxBookshelf.setBooks();
    }

    @FXML
    public void handleClick(){
        System.out.println("Clicked");
    }

}
