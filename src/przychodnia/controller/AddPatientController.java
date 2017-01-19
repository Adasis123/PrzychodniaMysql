package przychodnia.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
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
    private JFXTextArea patientValidator;

    @FXML
    public JFXButton addPatientBtn;
    private Integer pId;
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
    private void cancelPatient() throws IOException {
        if (Main.isAddPatientModal()) {
            Main.getModalPatient().close();
            Main.setAddPatientModal(false);
        } else PatientsController.getModalPatient().close();

    }

    @FXML
    public void addPatient() throws SQLException, ClassNotFoundException, IOException {
        val();
        if (!checkPatientFields()){
        if (Main.isAddPatientModal()) {
            PatientsDAO.insertPatient(pSurname.getText(), pName.getText(), pCity.getText(), pZipCode.getText(),
                    pStreet.getText(), pNumber.getText(), pPesel.getText());
            cancelPatient();
            Main.showPatients();
            Main.setAddPatientModal(false);
        } else {
            PatientsDAO.updatePatient(PatientsController.getpId(), pSurname.getText(), pName.getText(), pCity.getText(),
                    pZipCode.getText(), pStreet.getText(),
                    pNumber.getText(), pPesel.getText());
            cancelPatient();
            Main.showPatients();
        }
    }
        else patientValidator.setText("Proszę wypełnić wszystkie pola!!!");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        val();

    }

    private void val() {
        RequiredFieldValidator surname_validator = new RequiredFieldValidator();
        pSurname.getValidators().add(surname_validator);
        surname_validator.setMessage("Proszę wprowadzić poprawne dane");

        pSurname.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                if (!pSurname.getText().matches("[a-zA-Z]+")) {
                    pSurname.setText("");
                }
                pSurname.validate();
            }
        });


        RequiredFieldValidator name_validator = new RequiredFieldValidator();
        pName.getValidators().add(name_validator);
        name_validator.setMessage("Proszę wprowadzić poprawne dane");

        pName.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                if (!pName.getText().matches("[a-zA-Z]+")) {
                    pName.setText("");
                }
                pName.validate();
            }
        });

        RequiredFieldValidator city_validator = new RequiredFieldValidator();
        pCity.getValidators().add(city_validator);
        city_validator.setMessage("Proszę wprowadzić poprawne dane");

        pCity.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                if (!pCity.getText().matches("[a-zA-Z]+")) {
                    pCity.setText("");
                }
                pCity.validate();
            }
        });

        RequiredFieldValidator street_validator = new RequiredFieldValidator();
        pStreet.getValidators().add(street_validator);
        street_validator.setMessage("Proszę wprowadzić poprawne dane");

        pStreet.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                if (!pStreet.getText().matches("[a-zA-Z]+")) {
                    pStreet.setText("");
                }
                pStreet.validate();
            }
        });

        RequiredFieldValidator number_validator = new RequiredFieldValidator();
        pNumber.getValidators().add(number_validator);
        number_validator.setMessage("Proszę wprowadzić poprawne dane");

        pNumber.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                if (!pNumber.getText().matches("^[a-zA-Z0-9/]{1,7}$")) {
                    pNumber.setText("");
                }
                pNumber.validate();
            }
        });

        RequiredFieldValidator zip_code_validator = new RequiredFieldValidator();
        pZipCode.getValidators().add(zip_code_validator);
        zip_code_validator.setMessage("Proszę wprowadzić poprawne dane");

        pZipCode.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                if (!pZipCode.getText().matches("^\\d{2}-\\d{3}$")) {
                    pZipCode.setText("");
                }
                pZipCode.validate();
            }
        });

        RequiredFieldValidator pesel_validator = new RequiredFieldValidator();
        pPesel.getValidators().add(pesel_validator);
        pesel_validator.setMessage("Proszę wprowadzić poprawne dane");

        pPesel.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                if (!pPesel.getText().matches("^\\d{11}$")) {
                    pPesel.setText("");
                }
                pPesel.validate();
            }
        });


    }


    public void setPatientData(String Surname, String Name, String City, String ZipCode, String Street, String Number,
                               String Pesel) {
        pSurname.setText(Surname);
        pName.setText(Name);
        pCity.setText(City);
        pZipCode.setText(ZipCode);
        pStreet.setText(Street);
        pNumber.setText(Number);
        pPesel.setText(Pesel);
    }

    private boolean checkPatientFields() {

        return (pSurname.getText().trim().isEmpty() || pName.getText().trim().isEmpty() ||
                pCity.getText().trim().isEmpty() || pStreet.getText().trim().isEmpty() ||
                pNumber.getText().trim().isEmpty() || pZipCode.getText().trim().isEmpty() ||
                pPesel.getText().trim().isEmpty());
    }
}
