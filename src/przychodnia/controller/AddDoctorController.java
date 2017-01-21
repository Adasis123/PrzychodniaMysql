package przychodnia.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import przychodnia.Main;
import przychodnia.model.DoctorsDAO;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by adam on 19/01/2017.
 */
public class AddDoctorController implements Initializable {

    @FXML
    private JFXTextArea doctorValidator;

    @FXML
    public JFXButton addDoctorBtn;
    private Integer dId;
    @FXML
    private JFXTextField dSurname;

    @FXML
    private JFXTextField dName;

    @FXML
    private JFXTextField dSpec;

    @FXML
    private JFXTextField dPhone;

    @FXML
    private JFXButton addDoctor;


    @FXML
    private void cancelDoctor() throws IOException {
        if (Main.isAddDoctorModal()) {
            Main.getModalDoctor().close();
            Main.setAddDoctorModal(false);
        } else DoctorsController.getModalDoctor().close();

    }

    @FXML
    public void addDoctor() throws SQLException, ClassNotFoundException, IOException {
        val();
        if (!checkPatientFields()){
            if (Main.isAddDoctorModal()) {
                DoctorsDAO.insertDoctor(dSurname.getText(), dName.getText(), dSpec.getText(), dPhone.getText());
                cancelDoctor();
                Main.showDoctors();
                Main.setAddDoctorModal(false);
            } else {
                DoctorsDAO.updateDoctor(DoctorsController.getdId(), dSurname.getText(), dName.getText(),
                        dSpec.getText(), dPhone.getText());
                cancelDoctor();
                Main.showDoctors();
            }
        }
        else doctorValidator.setText("Proszę wypełnić wszystkie pola!!!");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        val();

    }

    private void val() {
        RequiredFieldValidator surname_validator = new RequiredFieldValidator();
        dSurname.getValidators().add(surname_validator);
        surname_validator.setMessage("Proszę wprowadzić poprawne nazwisko");

        dSurname.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                if (!dSurname.getText().matches("[a-zA-Z]+")) {
                    dSurname.setText("");
                }
                dSurname.validate();
            }
        });


        RequiredFieldValidator name_validator = new RequiredFieldValidator();
        dName.getValidators().add(name_validator);
        name_validator.setMessage("Proszę wprowadzić poprawne imie");

        dName.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                if (!dName.getText().matches("[a-zA-Z]+")) {
                    dName.setText("");
                }
                dName.validate();
            }
        });

        RequiredFieldValidator spec_validator = new RequiredFieldValidator();
        dSpec.getValidators().add(spec_validator);
        spec_validator.setMessage("Proszę wprowadzić poprawna specjalizacje");

        dSpec.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                if (!dSpec.getText().matches("[a-zA-Z]+")) {
                    dSpec.setText("");
                }
                dSpec.validate();
            }
        });

        RequiredFieldValidator phone_validator = new RequiredFieldValidator();
        dPhone.getValidators().add(phone_validator);
        phone_validator.setMessage("Proszę wprowadzić poprawny numer telefonu");

        dPhone.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                if (!dPhone.getText().matches("^\\d{9}$")) {
                    dPhone.setText("");
                }
                dPhone.validate();
            }
        });
    }

    public void setDoctorData(String Surname, String Name, String Spec, String PhoneNumber) {
        dSurname.setText(Surname);
        dName.setText(Name);
        dSpec.setText(Spec);
        dPhone.setText(PhoneNumber);

    }

    private boolean checkPatientFields() {
        return (dSurname.getText().trim().isEmpty() || dName.getText().trim().isEmpty() ||
                dSpec.getText().trim().isEmpty() || dPhone.getText().trim().isEmpty());
    }
}


