package przychodnia.controller;

import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by adam on 05/01/2017.
 */
public class VisitsController implements Initializable {


    @FXML
    private AnchorPane visitsPane;
    @FXML
    private JFXTreeTableView<Visit> visitsTree;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        JFXTreeTableColumn<Visit, String> pName = new JFXTreeTableColumn<>("Pacjent");
        pName.setPrefWidth(150);
        pName.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Visit, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Visit, String> param) {
                return param.getValue().getValue().pName;
            }
        });

        JFXTreeTableColumn<Visit, String> dName = new JFXTreeTableColumn<>("Lekarz");
        dName.setPrefWidth(150);
        dName.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Visit, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Visit, String> param) {
                return param.getValue().getValue().dName;
            }
        });

        JFXTreeTableColumn<Visit, String> vDate = new JFXTreeTableColumn<>("Data Wizyty");
        vDate.setPrefWidth(145);
        vDate.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Visit, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Visit, String> param) {
                return param.getValue().getValue().vDate;
            }
        });

        ObservableList<Visit> users = FXCollections.observableArrayList();
        users.add(new Visit("Adam Danielczyk", "Ryszard Zieliński", "12/12/2017"));
        users.add(new Visit("Kuba Nowak", "Ryszard Zieliński", "13/12/2017"));


        final TreeItem<Visit> root = new RecursiveTreeItem<Visit>(users, RecursiveTreeObject::getChildren);
        visitsTree.getColumns().setAll(pName, dName, vDate);
        visitsTree.setRoot(root);
        visitsTree.setShowRoot(false);

    }

    class Visit extends RecursiveTreeObject<Visit> {

        StringProperty pName;
        StringProperty dName;
        StringProperty vDate;

        public Visit(String pName, String dName, String vDate) {
            this.pName = new SimpleStringProperty(pName);
            this.dName = new SimpleStringProperty(dName);
            this.vDate = new SimpleStringProperty(vDate);
        }

    }
}