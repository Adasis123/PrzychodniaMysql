package przychodnia.controller;

import com.jfoenix.controls.JFXTextArea;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import przychodnia.Main;
import przychodnia.model.Visits;
import przychodnia.model.VisitsDAO;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by adam on 05/01/2017.
 */
public class VisitsController implements Initializable {


    @FXML
    private AnchorPane visitsPane;
    @FXML
    private TableView<Visits> VisitsView;
    @FXML
    private TableColumn<Visits, String> dSurname;
    @FXML
    private TableColumn<Visits, String> dName;
    @FXML
    private TableColumn<Visits, String> pSurname;
    @FXML
    private TableColumn<Visits, String> pName;
    @FXML
    private TableColumn<Visits, String> vDate;
    @FXML
    private TableColumn<Visits, Integer> vIndex;
    private static ObservableList<Visits> visitsList;
    @FXML
    private JFXTextArea visitsText;

    @FXML
    private void populateVisits(ObservableList<Visits> visData) {
        //Set items to the employeeTable
        VisitsView.setItems(visData);
    }

    @FXML
    private void show() throws SQLException, ClassNotFoundException {
        try {
            ObservableList<Visits> visitsData = VisitsDAO.searchVisits();
            populateVisits(visitsData);

        } catch (SQLException e) {
            System.out.println("Error with getting information from DB.\n" + e);
            throw e;
        }
    }

    private void showSearched() {
        populateVisits(visitsList);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb){


        vIndex.setCellValueFactory(cellData -> cellData.getValue().vIndexProperty().asObject());
        dSurname.setCellValueFactory(cellData -> cellData.getValue().dSurnameProperty());
        dName.setCellValueFactory(cellData -> cellData.getValue().dNameProperty());
        pName.setCellValueFactory(cellData -> cellData.getValue().pNameProperty());
        pSurname.setCellValueFactory(cellData -> cellData.getValue().pSurnameProperty());
        vDate.setCellValueFactory(cellData -> cellData.getValue().vDateProperty());
        if (visitsList != null) {
            System.out.println("Jest");
            showSearched();
            visitsList = null;
        } else try {
            show();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    @FXML
    private void deleteVisit() throws SQLException, ClassNotFoundException {
        visitsText.setText("");
       Visits del_visit = VisitsView.getSelectionModel().getSelectedItem();
        if (del_visit != null) {
            try {
                VisitsDAO.deleteVisit(del_visit.getvId());
                show();
            } catch (SQLException e) {
                throw e;
            }
        } else visitsText.setText("Proszę wybrać lekarza!!!");
    }

    @FXML
    public void addVisit() throws IOException, SQLException, ClassNotFoundException {
//        doctorsText.setText("");
        Main.addVisit();
    }
}