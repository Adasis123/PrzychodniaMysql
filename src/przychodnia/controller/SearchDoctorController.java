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
    Stage modalDoctor;
    @FXML
    private void cancelSearch() {
        if(DoctorVisitsController.isVisitDoctor){
            DoctorVisitsController.getModalDoctor().close();
            DoctorVisitsController.isVisitDoctor = false;
        }
        else DoctorsController.getModalDoctor().close();
    }


    @FXML
    public void searchDoctor() throws ClassNotFoundException, SQLException, IOException {
        try {
            FXMLLoader loader = new FXMLLoader();
            if(!checkDoctorSearchFields()){
                doctorsList = DoctorsDAO.searchDoctors(searchSurname.getText(), searchName.getText(),
                        searchSpec.getText());
                if (DoctorVisitsController.isVisitDoctor){
                    AddVisitController.getModalDoctor().close();
                    modalDoctor = new Stage();
                    loader.setLocation(Main.class.getResource("view/DoctorVisitView.fxml"));
                    DoctorVisitsController docController = loader.getController();
                    DoctorVisitsController.setDoctorsList(doctorsList);
                    AnchorPane searchDoctorPane = loader.load();
                    Scene searchDoctor = new Scene(searchDoctorPane);
                    modalDoctor.setScene(searchDoctor);
                    modalDoctor.initModality(Modality.APPLICATION_MODAL);
                    modalDoctor.show();}
                else Main.showSearchedDoctors(doctorsList);
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
