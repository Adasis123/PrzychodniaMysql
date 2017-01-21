package przychodnia.controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import przychodnia.model.Visits;
import przychodnia.model.VisitsDAO;

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
    private static ObservableList<Visits> visitsist;

    @FXML
    private void populateVisits(ObservableList<Visits> visData) throws ClassNotFoundException {
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {


        vIndex.setCellValueFactory(cellData -> cellData.getValue().vIndexProperty().asObject());
        dSurname.setCellValueFactory(cellData -> cellData.getValue().dSurnameProperty());
        dName.setCellValueFactory(cellData -> cellData.getValue().dNameProperty());
        pName.setCellValueFactory(cellData -> cellData.getValue().pNameProperty());
        pSurname.setCellValueFactory(cellData -> cellData.getValue().pSurnameProperty());
        vDate.setCellValueFactory(cellData -> cellData.getValue().vDateProperty());
        if (visitsist != null) {
//            showSearched();
//            doctorsList = null;
        } else try {
            show();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }




}