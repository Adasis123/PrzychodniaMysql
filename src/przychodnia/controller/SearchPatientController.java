package przychodnia.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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


    public  ObservableList<Patients> getPatientsList() {
        return patientsList;
    }

    private ObservableList<Patients> patientsList;
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
    private void cancelSearch() {
        PatientsController.getModalPatient().close();
    }

    @FXML
    public void searchPatient() throws ClassNotFoundException, SQLException, IOException {
        try {
            FXMLLoader loader = new FXMLLoader();
            patientsList = PatientsDAO.searchPatient(searchSurname.getText(), searchName.getText(),
                    searchCity.getText(), searchStreet.getText(), searchPesel.getText() );
            System.out.println(patientsList);
            Main.showSearchedPatients(patientsList);
            cancelSearch();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
