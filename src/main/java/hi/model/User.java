package hi.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {

    private StringProperty name = new SimpleStringProperty();

    private String nameString;

    public User(String n) {
        name.set(n);
        nameString = n;
    }

    public StringProperty nameProperty() {
        return name;
    }


    public String getNameString() {
        return nameString;
    }

    public String getName() {
        return name.get();
    }


    public void setName(String n) {
        name.set(n);
    }
}
