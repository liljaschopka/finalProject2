package hi.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class User {

    private StringProperty name = new SimpleStringProperty();
    private String nameString;
    private ObservableList<Lending> lendings = FXCollections.observableArrayList();

    public User(String n) {
        name.set(n);
        nameString = n;
    }

    public void addLending(Lending l) {
        lendings.add(l);
    }

    public ObservableList<Lending> getLendings() {
        return lendings;
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

    public void removeLending(Lending l) {
        lendings.remove(l);
    }
}
