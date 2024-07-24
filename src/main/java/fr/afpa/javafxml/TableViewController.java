package fr.afpa.javafxml;

import fr.afpa.models.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class TableViewController {

    @FXML
    private TableView<Person> tableView;

    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField city;

    @FXML
    private Button save;
    @FXML
    private Button cancel;
    @FXML
    private Button delete;

    @FXML
    private TableColumn<Person, String> firstNameColumn;
    @FXML
    private TableColumn<Person, String> lastNameColumn;
    @FXML
    private TableColumn<Person, String> cityColumn;

    private ObservableList<Person> persons = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        persons.add(new Person("Michel", "MICHEL", "Michelville"));
        persons.add(new Person("Françoise", "FRANCOIS", "Françoisbourg"));
        persons.add(new Person("Hervé", "RANU", "La-Compta-en-Creuse"));

        tableView.setItems(persons);

        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().getFirstName());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().getLastName());
        cityColumn.setCellValueFactory(cellData -> cellData.getValue().getCity());
    }

    @FXML
    public void save(ActionEvent event) {
        if (firstName != null && lastName != null && city != null) {
            persons.add(new Person(firstName.getText(), lastName.getText(), city.getText()));
            tableView.setItems(persons);
        }
    }

}
