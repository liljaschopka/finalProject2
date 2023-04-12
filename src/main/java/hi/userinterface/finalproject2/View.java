package hi.userinterface.finalproject2;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
public enum View {
    LIBRARY("library-view.fxml"),
    CHECKOUT("checkout-view.fxml"),
    STUDENT("studentlogin-view.fxml"),
    FACULTY("facultylogin-view.fxml"),
    MYLENDINGS("mylendings-view.fxml");

    private final String fileName;

    View(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
