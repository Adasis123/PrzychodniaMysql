package przychodnia.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import przychodnia.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by adam on 22/01/2017.
 */
public class AddVisitController implements Initializable {

    @FXML
    private JFXTextField pSurname;

    @FXML
    private JFXTextField dSurname;
    @FXML
    private JFXTextField pName;
    @FXML
    private JFXTextField dName;

    private static Stage modalPatient;

    public static Stage getModalDoctor() {
        return modalDoctor;
    }

    private static Stage modalDoctor;



    public static Stage getModalPatient() {
        return modalPatient;
    }



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
        Main.getModalVisit().close();
    }

    @FXML
    private void searchDoctor() throws IOException {


        modalDoctor = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/DoctorVisitView.fxml"));
        AnchorPane searchDoctorPane = loader.load();
        Scene searchDoctor = new Scene(searchDoctorPane);
        modalDoctor.setScene(searchDoctor);
        modalDoctor.initModality(Modality.APPLICATION_MODAL);
        modalDoctor.show();
        Main.getModalVisit().close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(PatientsVisitsController.getpVSurname() != null) {
            pSurname.setText(PatientsVisitsController.getpVSurname());
            pName.setText(PatientsVisitsController.getpVName());
        }
        if(DoctorVisitsController.getdVSurname() != null) {
            dSurname.setText(DoctorVisitsController.getdVSurname());
            dName.setText(DoctorVisitsController.getdVName());
        }

    }

    @FXML
    private void cancelVisit() throws IOException {
        if(PatientsVisitsController.getModalVisit() != null){
        PatientsVisitsController.getModalVisit().close();}
        if(DoctorVisitsController.getModalVisit() != null){
            DoctorVisitsController.getModalVisit().close();
        }

        PatientsVisitsController.setpVSurname(null);
        PatientsVisitsController.setpVName(null);
        DoctorVisitsController.setdVSurname(null);
        DoctorVisitsController.setdVName(null);

    }

    public void setPatientData(String Surname, String Name) {
        pSurname.setText(Surname);
        pName.setText(Name);
}
    public void setDoctorData(String Surname, String Name) {
        dSurname.setText(Surname);
        dName.setText(Name);
    }
}