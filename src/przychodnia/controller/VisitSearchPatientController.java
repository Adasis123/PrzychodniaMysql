package przychodnia.controller;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import przychodnia.Main;
import przychodnia.model.Patients;

import java.io.IOException;

/**
 * Created by adam on 22/01/2017.
 */
public class VisitSearchPatientController {

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
    private JFXTextArea searchValidation;
    private static Stage modalPatient;


    @FXML
    private void searchPatient() throws IOException {

        modalPatient = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/PatientsVisitView.fxml"));
        AnchorPane searchPatientPane = loader.load();
        Scene searchPatient = new Scene(searchPatientPane);
        modalPatient.setScene(searchPatient);
        modalPatient.initModality(Modality.APPLICATION_MODAL);
        modalPatient.show();
    }
}
