package przychodnia.controller;

import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import przychodnia.Main;
import przychodnia.model.PatientsDAO;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by adam on 08/01/2017.
 */
public class AddPatientController implements Initializable {

    @FXML
    private JFXTextField pSurname;

    @FXML
    private JFXTextField pName;

    @FXML
    private JFXTextField pCity;

    @FXML
    private JFXTextField pZipCode;

    @FXML
    private JFXTextField pStreet;

    @FXML
    private JFXTextField pNumber;

    @FXML
    private JFXTextField pPesel;

    @FXML
    public void cancelPatient() {
        Main.getModalPatient().close();

    }

    @FXML
    public void addPatient() throws SQLException, ClassNotFoundException, IOException {
        try {
            val();
            PatientsDAO.insertPatient(pSurname.getText(), pName.getText(), pCity.getText(), pZipCode.getText(), pStreet.getText(),
                    pNumber.getText(), pPesel.getText());
            Main.getModalPatient().close();
            Main.showVisits();
        } catch (SQLException e) {
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

    private void val() {
        RequiredFieldValidator validator = new RequiredFieldValidator();
        pSurname.getValidators().add(validator);
        validator.setMessage("Proszę wprowadzić dane");

        pSurname.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue){
                pSurname.validate();
            }
        });

    }

}