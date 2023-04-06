package hi.userinterface.finalproject2;

import hi.model.Book;
import hi.model.FacultyMember;
import hi.model.LibrarySystem;
import hi.model.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.util.Optional;

public class LibraryController {
    @FXML
    private ListView<Book> fxYourBooks;
    @FXML
    private ListView<Book> fxBookshelf;
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

    private LibrarySystem librarySystem;

    public void fxSignInStudentHandler(ActionEvent actionEvent) {
        Student newStudent = new Student("", true);
        StudentDialog s = new StudentDialog(newStudent);
        Optional<Student> result = s.showAndWait();
        result.ifPresent(value -> fxName.setText(value.getName()));
        librarySystem.getUsers().add(newStudent);

    }

    public void fxSignInFacultyHandler(ActionEvent actionEvent) {
        FacultyMember newFaculty = new FacultyMember("", "");
        FacultyDialog f = new FacultyDialog(newFaculty);
        Optional<FacultyMember> result = f.showAndWait();
        result.ifPresent(value -> fxName.setText(value.getName()));
        librarySystem.getUsers().add(newFaculty);

    }

    public void initalize() {
        librarySystem.setBooks();
        fxBookshelf.getItems().add((Book) librarySystem.getBooks());

    }

}
