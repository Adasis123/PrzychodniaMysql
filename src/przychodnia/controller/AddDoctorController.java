package przychodnia.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
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
    public JFXButton addPatientBtn;
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
//        val();
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
//        val();

    }

//    private void val() {
//        RequiredFieldValidator surname_validator = new RequiredFieldValidator();
//        pSurname.getValidators().add(surname_validator);
//        surname_validator.setMessage("Proszę wprowadzić poprawne dane");
//
//        pSurname.focusedProperty().addListener((observable, oldValue, newValue) -> {
//            if (!newValue) {
//                if (!pSurname.getText().matches("[a-zA-Z]+")) {
//                    pSurname.setText("");
//                }
//                pSurname.validate();
//            }
//        });
//
//
//        RequiredFieldValidator name_validator = new RequiredFieldValidator();
//        pName.getValidators().add(name_validator);
//        name_validator.setMessage("Proszę wprowadzić poprawne dane");
//
//        pName.focusedProperty().addListener((observable, oldValue, newValue) -> {
//            if (!newValue) {
//                if (!pName.getText().matches("[a-zA-Z]+")) {
//                    pName.setText("");
//                }
//                pName.validate();
//            }
//        });
//
//        RequiredFieldValidator city_validator = new RequiredFieldValidator();
//        pCity.getValidators().add(city_validator);
//        city_validator.setMessage("Proszę wprowadzić poprawne dane");
//
//        pCity.focusedProperty().addListener((observable, oldValue, newValue) -> {
//            if (!newValue) {
//                if (!pCity.getText().matches("[a-zA-Z]+")) {
//                    pCity.setText("");
//                }
//                pCity.validate();
//            }
//        });
//
//        RequiredFieldValidator street_validator = new RequiredFieldValidator();
//        pStreet.getValidators().add(street_validator);
//        street_validator.setMessage("Proszę wprowadzić poprawne dane");
//
//        pStreet.focusedProperty().addListener((observable, oldValue, newValue) -> {
//            if (!newValue) {
//                if (!pStreet.getText().matches("[a-zA-Z]+")) {
//                    pStreet.setText("");
//                }
//                pStreet.validate();
//            }
//        });
//
//        RequiredFieldValidator number_validator = new RequiredFieldValidator();
//        pNumber.getValidators().add(number_validator);
//        number_validator.setMessage("Proszę wprowadzić poprawne dane");
//
//        pNumber.focusedProperty().addListener((observable, oldValue, newValue) -> {
//            if (!newValue) {
//                if (!pNumber.getText().matches("^[a-zA-Z0-9/]{1,7}$")) {
//                    pNumber.setText("");
//                }
//                pNumber.validate();
//            }
//        });
//
//        RequiredFieldValidator zip_code_validator = new RequiredFieldValidator();
//        pZipCode.getValidators().add(zip_code_validator);
//        zip_code_validator.setMessage("Proszę wprowadzić poprawne dane");
//
//        pZipCode.focusedProperty().addListener((observable, oldValue, newValue) -> {
//            if (!newValue) {
//                if (!pZipCode.getText().matches("^\\d{2}-\\d{3}$")) {
//                    pZipCode.setText("");
//                }
//                pZipCode.validate();
//            }
//        });
//
//        RequiredFieldValidator pesel_validator = new RequiredFieldValidator();
//        pPesel.getValidators().add(pesel_validator);
//        pesel_validator.setMessage("Proszę wprowadzić poprawne dane");
//
//        pPesel.focusedProperty().addListener((observable, oldValue, newValue) -> {
//            if (!newValue) {
//                if (!pPesel.getText().matches("^\\d{11}$")) {
//                    pPesel.setText("");
//                }
//                pPesel.validate();
//            }
//        });


//    }


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


