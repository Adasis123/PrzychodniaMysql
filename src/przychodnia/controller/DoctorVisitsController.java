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
import przychodnia.model.Doctors;
import przychodnia.model.DoctorsDAO;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by adam on 23/01/2017.
 */
public class DoctorVisitsController extends DoctorsDAO {

    public static String dVSurname;
    public static boolean isVisitDoctor;

    public static String getdVSurname() {
        return dVSurname;
    }

    public static void setdVSurname(String dVSurname) {
        DoctorVisitsController.dVSurname = dVSurname;
    }

    public static String getdVName() {
        return dVName;
    }

    public static void setdVName(String dVName) {
        DoctorVisitsController.dVName = dVName;
    }
    private static Stage modalVisit;
    public static String dVName;
    @FXML
    public static JFXButton btnNewDoctor;
    @FXML
    private JFXTextArea doctorsText;
    @FXML
    private TableView<Doctors> DoctorsView;
    @FXML
    private TableColumn<Doctors, String> dSurname;
    @FXML
    private TableColumn<Doctors, String> dName;
    @FXML
    private TableColumn<Doctors, String> dSpec;
    @FXML
    private TableColumn<Doctors, String> dPhoneNumber;
    @FXML
    private TableColumn<Doctors, Integer> dIndex;
    public static Integer dId;
    private static Stage modalDoctor;
    private static ObservableList<Doctors> doctorsList;

    @FXML
    private void show() throws SQLException, ClassNotFoundException {
        try {
            ObservableList<Doctors> doctorData = DoctorsDAO.searchDoctors();
            populateDoctors(doctorData);

        } catch (SQLException e) {
            System.out.println("Error with getting information from DB.\n" + e);
            throw e;
        }
    }

    private void showSearched() throws SQLException, ClassNotFoundException {
        populateDoctors(doctorsList);
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

        dIndex.setCellValueFactory(cellData -> cellData.getValue().dIndexProperty().asObject());
        dSurname.setCellValueFactory(cellData -> cellData.getValue().dSurnameProperty());
        dName.setCellValueFactory(cellData -> cellData.getValue().dNameProperty());
        dSpec.setCellValueFactory(cellData -> cellData.getValue().dSpecProperty());
        dPhoneNumber.setCellValueFactory(cellData -> cellData.getValue().dPhoneNumberProperty());
        if (doctorsList != null) {
            showSearched();
            doctorsList = null;
            isVisitDoctor = true;
        } else show();

    }

    @FXML
    private void populateDoctors(ObservableList<Doctors> docData) throws ClassNotFoundException {
        //Set items to the employeeTable
        DoctorsView.setItems(docData);
    }


    @FXML
    private void searchDoctor() throws IOException {

        modalDoctor = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/SearchDoctorView.fxml"));
        AnchorPane searchDoctorPane = loader.load();
        Scene searchDoctor = new Scene(searchDoctorPane);
        modalDoctor.setScene(searchDoctor);
        modalDoctor.initModality(Modality.APPLICATION_MODAL);
        modalDoctor.show();
    }

    public static void setDoctorsList(ObservableList<Doctors> doctorsList) {
        DoctorVisitsController.doctorsList = doctorsList;
    }

    public static Stage getModalDoctor() {
        return modalDoctor;
    }

    public static Stage getModalVisit() {
        return modalVisit;
    }

    @FXML
    private void addVisitDoctor() throws IOException {
        Doctors search_doctor = DoctorsView.getSelectionModel().getSelectedItem();
        dVName = search_doctor.getdName();
        dVSurname = search_doctor.getdSurname();

        if (search_doctor != null) {
            modalVisit = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/AddVisitView.fxml"));
            AnchorPane addVisitPane = loader.load();
            Scene addVisit = new Scene(addVisitPane);
            AddVisitController addDoc = loader.getController();
//            addDoc.setDoctorData(search_patient.getpSurname(), search_patient.getpName());
//            addPat.addPatientBtn.setText("Edytuj");
//            pId = edt_patient.getpId();
            modalVisit.setScene(addVisit);
            modalVisit.initModality(Modality.APPLICATION_MODAL);
            modalVisit.show();
            PatientsVisitsController.getModalVisit().close();
            AddVisitController.getModalDoctor().close();
        } else doctorsText.setText("Proszę wybrać lekarza!!!");

    }
}
