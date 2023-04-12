package hi.userinterface.finalproject2;

import hi.model.LibrarySystem;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class LibraryApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        var scene = new Scene(new Pane());
        LibrarySystem model = new LibrarySystem();
        ViewSwitcher.setScene(scene);
        ViewSwitcher.switchTo(View.LIBRARY, model);
        stage.setTitle("Library");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
