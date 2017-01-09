package przychodnia.controller;

import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import przychodnia.Main;
import przychodnia.model.Patients;
import przychodnia.model.PatientsDAO;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by adam on 04/01/2017.
 */
public class PatientsController extends PatientsDAO {

    @FXML
    private TableView<Patients> PatientsView;
    @FXML
    private TableColumn<Patients, Integer> pId;
    @FXML
    private TableColumn<Patients, String>  pSurname;
    @FXML
    private TableColumn<Patients, String> pName;
    @FXML
    private TableColumn<Patients, String> pCity;
    @FXML
    private TableColumn<Patients, String> pStreet;
    @FXML
    private TableColumn<Patients, String> pNumber;
    @FXML
    private TableColumn<Patients, String> pPesel;
    @FXML
    private TableColumn<Patients, Integer> pIndex;

    @FXML
    private void show() throws SQLException, ClassNotFoundException {
        try {
            //Get all Employees information
            ObservableList<Patients> empData = PatientsDAO.searchPatients();
            System.out.println(empData);
            //Populate Employees on TableView
            populateEmployees(empData);

        } catch (SQLException e){
            System.out.println("Error occurred while getting employees information from DB.\n" + e);
            throw e;
        }

    }

    public void initialize () throws SQLException, ClassNotFoundException {
        /*
        The setCellValueFactory(...) that we set on the table columns are used to determine
        which field inside the Employee objects should be used for the particular column.
        The arrow -> indicates that we're using a Java 8 feature called Lambdas.
        (Another option would be to use a PropertyValueFactory, but this is not type-safe

        We're only using StringProperty values for our table columns in this example.
        When you want to use IntegerProperty or DoubleProperty, the setCellValueFactory(...)
        must have an additional asObject():
        */

        pIndex.setCellValueFactory(cellData -> cellData.getValue().pIndexProperty().asObject());
        pSurname.setCellValueFactory(cellData -> cellData.getValue().pSurnameProperty());
        pName.setCellValueFactory(cellData -> cellData.getValue().pNameProperty());
        pCity.setCellValueFactory(cellData -> cellData.getValue().pCityProperty());
        pStreet.setCellValueFactory(cellData -> cellData.getValue().pStreetProperty());
        pNumber.setCellValueFactory(cellData -> cellData.getValue().pNumberProperty());
        pPesel.setCellValueFactory(cellData -> cellData.getValue().pPeselProperty());
        show();

    }

    @FXML private TableColumn<Task, String> taskIndexCol;

    @FXML
    private void populateEmployees (ObservableList<Patients> empData) throws ClassNotFoundException {
        //Set items to the employeeTable
        PatientsView.setItems(empData);
    }

    @FXML
    public void addPatient() throws IOException, SQLException, ClassNotFoundException {
        Main.addPatient();
    }

    @FXML
    public void deletePatient() {
        Patients test = PatientsView.getSelectionModel().getSelectedItem();
        System.out.println(test.getpId());
    }

}


