package przychodnia.controller;

import javafx.fxml.FXML;
import przychodnia.Main;

/**
 * Created by adam on 08/01/2017.
 */
public class AddPatientController {

    @FXML
    public void cancelPatient() {
        Main.getModalPatient().close();

    }
}
