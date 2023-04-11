package hi.userinterface.finalproject2;

import hi.model.LibrarySystem;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 * <p>
 * EÞH - changed to include caching of controllers
 */
public class ViewSwitcher {
    private static final Map<View, Parent> cache = new HashMap<>();
    private static final Map<View, Object> controllers = new HashMap<>();
    private static Scene scene;

    public static void setScene(Scene scene) {
        ViewSwitcher.scene = scene;
    }

    public static void switchTo(View view, LibrarySystem model) {
        if (scene == null) {
            System.out.println("No scene was set");
            return;
        }

        try {
            Parent root;
            FXMLLoader loader = new FXMLLoader(ViewSwitcher.class.getResource(view.getFileName()));
            root = loader.load();
            Object controller = loader.getController();
            if (controller instanceof ControllerWithModel) {
                ((ControllerWithModel) controller).setModel(model); // set the model
            }
            controllers.put(view, controller); // save the controller
            cache.put(view, root); // save the view
            scene.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> T getController(View view) {
        return (T) controllers.get(view);
    }
}
