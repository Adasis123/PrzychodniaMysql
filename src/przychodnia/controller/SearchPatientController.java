package przychodnia.controller;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import przychodnia.Main;
import przychodnia.model.Patients;
import przychodnia.model.PatientsDAO;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by adam on 12/01/2017.
 */
public class SearchPatientController implements Initializable {

    private static ObservableList<Patients> patientsList;
    @FXML
    private JFXTextField searchSurname;
    @FXML
    private JFXTextField searchCity;
    @FXML
    private JFXTextField searchStreet;
    @FXML
    private JFXTextField searchPesel;
    @FXML
    private JFXTextField searchName;
    @FXML
    private JFXTextArea searchValidation;
    Stage modalPatient;

    @FXML
    private void cancelSearch() {
        if(PatientsVisitsController.isVisitPatient){
            PatientsVisitsController.getModalPatient().close();
            PatientsVisitsController.isVisitPatient = false;
        }
        else PatientsController.getModalPatient().close();
    }

    @FXML
    public void searchPatient() throws ClassNotFoundException, SQLException, IOException {
        try {
            FXMLLoader loader = new FXMLLoader();
            if(!checkPatientSearchFields()){
            patientsList = PatientsDAO.searchPatient(searchSurname.getText(), searchName.getText(),
                    searchCity.getText(), searchStreet.getText(), searchPesel.getText());
//                Main.showSearchedPatients(patientsList);
                if (PatientsVisitsController.isVisitPatient){
                AddVisitController.getModalPatient().close();
                modalPatient = new Stage();
                loader.setLocation(Main.class.getResource("view/PatientsVisitView.fxml"));
                PatientsVisitsController patController = loader.getController();
                PatientsVisitsController.setPatientsList(patientsList);
                AnchorPane searchPatientPane = loader.load();
                Scene searchPatient = new Scene(searchPatientPane);
                modalPatient.setScene(searchPatient);
                modalPatient.initModality(Modality.APPLICATION_MODAL);
                modalPatient.show();}
                else  Main.showSearchedPatients(patientsList);
            cancelSearch();}
            else searchValidation.setText("Proszę wypełnić przynajmniej jedno pole!");
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {


    }

    public ObservableList<Patients> getPatientsList() {
        return patientsList;
    }

    private boolean checkPatientSearchFields() {

        return (searchSurname.getText().trim().isEmpty() && searchCity.getText().trim().isEmpty() &&
                searchName.getText().trim().isEmpty() && searchPesel.getText().trim().isEmpty() &&
                searchStreet.getText().trim().isEmpty());
    }

    public static void setPatientsList(ObservableList<Patients> patientsList) {
        SearchPatientController.patientsList = patientsList;
    }
}
