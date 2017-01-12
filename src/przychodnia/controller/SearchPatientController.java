package przychodnia.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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



    @FXML
    private JFXTextField searchSurname;

    @FXML
    private void cancelSearch() {
        PatientsController.getModalPatient().close();
    }


    @FXML
    public void searchPatient() throws ClassNotFoundException, SQLException, IOException {
        try {
            FXMLLoader loader = new FXMLLoader();
            //Get Employee information
            ObservableList<Patients> patientsList = PatientsDAO.searchPatients();
            System.out.println(patientsList);
            cancelSearch();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

//
//        RequiredFieldValidator validator = new RequiredFieldValidator();
//        pSurname.getValidators().add(validator);
//        validator.setMessage("Proszę wprowadzić dane");
//
//        pSurname.focusedProperty().addListener((observable, oldValue, newValue) -> {
//            if(!newValue){
//                pSurname.validate();
//            }



    }
}
