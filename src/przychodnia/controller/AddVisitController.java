package przychodnia.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import przychodnia.Main;

import java.io.IOException;

/**
 * Created by adam on 22/01/2017.
 */
public class AddVisitController {


    public static Stage getModalPatient() {
        return modalPatient;
    }

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