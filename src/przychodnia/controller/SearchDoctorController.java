package przychodnia.controller;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import przychodnia.Main;
import przychodnia.model.Doctors;
import przychodnia.model.DoctorsDAO;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by adam on 21/01/2017.
 */
public class SearchDoctorController {

    private ObservableList<Doctors> doctorsList;
    @FXML
    public JFXTextField searchSurname;
    @FXML
    public JFXTextField searchSpec;
    @FXML
    public JFXTextField searchName;
    @FXML
    public JFXTextArea searchValidation;

    @FXML
    private void cancelSearch() {

        DoctorsController.getModalDoctor().close();
    }

    @FXML
    public void searchDoctor() throws ClassNotFoundException, SQLException, IOException {
        try {
            FXMLLoader loader = new FXMLLoader();
            if(!checkDoctorSearchFields()){
                doctorsList = DoctorsDAO.searchDoctors(searchSurname.getText(), searchName.getText(),
                        searchSpec.getText());
                Main.showSearchedDoctors(doctorsList);
                cancelSearch();}
            else searchValidation.setText("Proszę wypełnić przynajmniej jedno pole!");
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    private boolean checkDoctorSearchFields() {

        return (searchSurname.getText().trim().isEmpty() && searchSpec.getText().trim().isEmpty() &&
                searchName.getText().trim().isEmpty());
    }
}
