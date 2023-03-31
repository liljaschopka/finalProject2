package hi.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {

    private StringProperty name = new SimpleStringProperty();

    public User(String n) {
        name.set(n);
    }

    public StringProperty getName() {
        return name;
    }


    public void setName(String n) {
        name.set(n);
    }
}
