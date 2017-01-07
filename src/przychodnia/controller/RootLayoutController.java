package przychodnia.controller;

import javafx.fxml.FXML;
import przychodnia.Main;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by adam on 05/01/2017.
 */
public class RootLayoutController {

    @FXML
    public void goExit() {

        System.exit(0);
    }


    public void goVisits() throws IOException, SQLException, ClassNotFoundException {
        Main.showVisits();
    }

    public void goPatients() {

    }

    public void goDoctors() {

    }
}
