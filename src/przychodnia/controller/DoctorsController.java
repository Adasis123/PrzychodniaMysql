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
 * Created by adam on 04/01/2017.
 */
public class DoctorsController extends DoctorsDAO {

    @FXML
    public static JFXButton addPatientBtn;
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
        } else show();
    }

    @FXML
    private void populateDoctors(ObservableList<Doctors> docData) throws ClassNotFoundException {
        //Set items to the employeeTable
        DoctorsView.setItems(docData);
    }

    @FXML
    public void addDoctor() throws IOException, SQLException, ClassNotFoundException {
        doctorsText.setText("");
        Main.addDoctor();
    }

    @FXML
    private void deleteDoctor() throws SQLException, ClassNotFoundException {
        doctorsText.setText("");
        Doctors del_doctor = DoctorsView.getSelectionModel().getSelectedItem();
        if (del_doctor != null) {
            try {
                DoctorsDAO.deleteDoctor(del_doctor.getdId());
                show();
            } catch (SQLException e) {
                throw e;
            }
        } else doctorsText.setText("Proszę wybrać lekarza!!!");
    }

    public static Integer getdId() {
        return dId;
    }

    @FXML
    private void editDoctor() throws IOException {
        doctorsText.setText("");
        Doctors edt_doctor = DoctorsView.getSelectionModel().getSelectedItem();
        if (edt_doctor != null) {
            modalDoctor = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/AddDoctorView.fxml"));
            AnchorPane addDoctorPane = loader.load();
            Scene addDoctor = new Scene(addDoctorPane);
            AddDoctorController addDoc = loader.getController();
            addDoc.setDoctorData(edt_doctor.getdSurname(), edt_doctor.getdName(), edt_doctor.getdSpec(),
                    edt_doctor.getdPhoneNumber());
            addDoc.addPatientBtn.setText("Edytuj");
            dId = edt_doctor.getdId();
            modalDoctor.setScene(addDoctor);
            modalDoctor.initModality(Modality.APPLICATION_MODAL);
            modalDoctor.show();
        } else doctorsText.setText("Proszę wybrać lekarza!!!");
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
//
    public static void setDoctorsList(ObservableList<Doctors> doctorsList) {
        DoctorsController.doctorsList = doctorsList;
    }

    public static Stage getModalDoctor() {
        return modalDoctor;
    }
}
