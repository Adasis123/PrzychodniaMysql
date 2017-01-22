package przychodnia.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import przychodnia.Main;
import przychodnia.model.Patients;
import przychodnia.model.PatientsDAO;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by adam on 22/01/2017.
 */
public class PatientsVisitsController extends PatientsDAO {


    @FXML
    public static JFXButton addPatientBtn;
    @FXML
    private JFXTextArea patientsText;
    @FXML
    private TableView<Patients> PatientsView;
    @FXML
    private TableColumn<Patients, String> pSurname;
    @FXML
    private TableColumn<Patients, String> pName;
    @FXML
    private TableColumn<Patients, String> pCity;
    @FXML
    private TableColumn<Patients, String> pZipCode;
    @FXML
    private TableColumn<Patients, String> pStreet;
    @FXML
    private TableColumn<Patients, String> pNumber;
    @FXML
    private TableColumn<Patients, String> pPesel;
    @FXML
    private TableColumn<Patients, Integer> pIndex;
    public static Integer pId;
    private static Stage modalPatient;
    private static ObservableList<Patients> patientsList;
    public static boolean isVisitPatient;

    @FXML
    public void show() throws SQLException, ClassNotFoundException {
        try {
            ObservableList<Patients> patientData = PatientsDAO.searchPatients();
            populateEmployees(patientData);

        } catch (SQLException e) {
            System.out.println("Error with getting information from DB.\n" + e);
            throw e;
        }
    }

    private void showSearched() throws SQLException, ClassNotFoundException {
        populateEmployees(patientsList);
    }

    public void initialize() throws SQLException, ClassNotFoundException {
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
        pZipCode.setCellValueFactory(cellData -> cellData.getValue().pZipCodeProperty());
        pStreet.setCellValueFactory(cellData -> cellData.getValue().pStreetProperty());
        pNumber.setCellValueFactory(cellData -> cellData.getValue().pNumberProperty());
        pPesel.setCellValueFactory(cellData -> cellData.getValue().pPeselProperty());
        if (patientsList != null) {
            showSearched();
            patientsList = null;
        } else show();
        isVisitPatient = true;
    }

    @FXML
    private void populateEmployees(ObservableList<Patients> empData) throws ClassNotFoundException {
        //Set items to the employeeTable
        PatientsView.setItems(empData);
    }

    @FXML
    public void addPatient() throws IOException, SQLException, ClassNotFoundException {
        patientsText.setText("");
        Main.addPatient();
    }

    @FXML
    private void deletePatient() throws SQLException, ClassNotFoundException {
        patientsText.setText("");
        Patients del_patient = PatientsView.getSelectionModel().getSelectedItem();
        if (del_patient != null) {
            try {
                PatientsDAO.deletePatient(del_patient.getpId());
                show();
            } catch (SQLException e) {
                throw e;
            }
        } else patientsText.setText("Proszę wybrać pacjenta!!!");
    }

    public static Integer getpId() {
        return pId;
    }

    @FXML
    private void editPatient() throws IOException {
        patientsText.setText("");
        Patients edt_patient = PatientsView.getSelectionModel().getSelectedItem();
        if (edt_patient != null) {
            modalPatient = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/AddPatientView.fxml"));
            AnchorPane addPatientPane = loader.load();
            Scene addPatient = new Scene(addPatientPane);
            AddPatientController addPat = loader.getController();
            addPat.setPatientData(edt_patient.getpSurname(), edt_patient.getpName(), edt_patient.getpCity(),
                    edt_patient.getpZipCode(), edt_patient.getpStreet(), edt_patient.getpNumber(),
                    edt_patient.getpPesel());
            addPat.addPatientBtn.setText("Edytuj");
            pId = edt_patient.getpId();
            modalPatient.setScene(addPatient);
            modalPatient.initModality(Modality.APPLICATION_MODAL);
            modalPatient.show();
        } else patientsText.setText("Proszę wybrać pacjenta!!!");
    }

    @FXML
    private void searchPatient() throws IOException {

        modalPatient = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/SearchPatientView.fxml"));
        AnchorPane searchPatientPane = loader.load();
        Scene searchPatient = new Scene(searchPatientPane);
        modalPatient.setScene(searchPatient);
        modalPatient.initModality(Modality.APPLICATION_MODAL);
        modalPatient.show();
    }

    public static void setPatientsList(ObservableList<Patients> patientsList) {
        PatientsVisitsController.patientsList = patientsList;
    }

    public static Stage getModalPatient() {
        return modalPatient;
    }
}


