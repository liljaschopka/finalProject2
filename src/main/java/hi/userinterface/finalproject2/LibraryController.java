package hi.userinterface.finalproject2;

import hi.model.Book;
import hi.model.LibrarySystem;
import hi.model.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class LibraryController implements ControllerWithModel, ControllerUsingModelInInInitialize {

    @FXML
    private ListView<Book> fxBooksInBasket;
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
    @FXML
    private Label fxLoginNotification;
    @FXML
    private Text userTitle;

    private Stage primaryStage;
    private ObservableList<Book> booksInBasket = FXCollections.observableArrayList();
    private LibrarySystem model;

    @FXML
    public void fxSignInStudentHandler() {
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

    public void fxSignInFacultyHandler(MouseEvent actionEvent) {
        ViewSwitcher.switchTo(View.FACULTY, model);
    }

    @FXML
    public void fxAddBookHandler() {
        if (model.getCurrentUser() != null) {
            fxBookshelf.getSelectionModel().getSelectedItems().forEach(selected -> {
                fxBooksInBasket.getItems().add((Book) selected);
                booksInBasket.add((Book) selected);
            });

        } else {
            fxAdd.setDisable(true);
            fxCheckout.setDisable(true);
            fxReturn.setDisable(true);
            setLoginNotification(true);
        }

    }

    @FXML
    public void fxCheckoutHandler() {
        if (!fxBooksInBasket.getItems().isEmpty()) {
            System.out.println("Checking out");
            ViewSwitcher.switchTo(View.CHECKOUT, model);
        } else {
            System.out.println("No books to checkout");
        }

    }

    @FXML
    public void fxRemoveBookHandler(ActionEvent actionEvent) {
        Book selected = fxBooksInBasket.getSelectionModel().getSelectedItem();
        fxBooksInBasket.getItems().remove(selected);
        booksInBasket.remove(selected);
    }

    public void initialize() {
        fxBookshelf.setBooks();
        setLoginNotification(false);
    }

    public void updateFromModel() {
        updateLogintext();
    }

    public void updateLogintext() {
        if (model.getCurrentUser() != null) {
            if (model.getCurrentUser() instanceof Student) {
                userTitle.setText("Logged in as Student: " + (model.getCurrentUser()).getName());
            } else {
                try {
                    userTitle.setText("Logged in as: " + (model.getCurrentUser()).getName() + ", " + model.findFacultyByName(model.getCurrentUser().getName()).getDepartment());
                } catch (Exception e) {
                    userTitle.setText("Logged in as: " + (model.getCurrentUser()).getName());
                }
            }
        } else {
            userTitle.setText("Not signed in, sign in to continue");
        }
    }

    @FXML
    public void fxMyLendingsHandler() {
        if (model.getCurrentUser() != null) {
            ViewSwitcher.switchTo(View.MYLENDINGS, model);
        } else {
            setLoginNotification(true);
        }
    }

    public void setLoginNotification(boolean visable) {
        fxLoginNotification.setVisible(visable);
        fxLoginNotification.setMouseTransparent(!visable);
    }

    @FXML
    public void handleClick() {
        updateLogintext();
    }

    public ObservableList<Book> getBooksInBasket() {
        return booksInBasket;
    }

    public ListView<Book> getFxBooksInBasket() {
        return fxBooksInBasket;
    }

    public LibrarySystem getModel() {
        return model;
    }

}
