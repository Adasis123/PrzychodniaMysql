package przychodnia;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import przychodnia.util.DBUtil;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by adam on 04/01/2017.
 */
public class Main extends Application {

    private Stage primaryStage;
    private static BorderPane rootLayout;
    private static Stage modalPatient;

    @Override
    public void start(Stage primaryStage) throws IOException, SQLException, ClassNotFoundException {

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Przychodnia");
        this.primaryStage.setMinWidth(1100);
        this.primaryStage.setMinHeight(700);
        DBUtil.DBConnect();
        initRootLayout();
        showVisits();


    }

    public void initRootLayout() throws IOException, SQLException, ClassNotFoundException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
        rootLayout = loader.load();
        Scene scene = new Scene(rootLayout);
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public static void showVisits() throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/PatientsView.fxml"));
        AnchorPane testPane = loader.load();
        rootLayout.setCenter(testPane);

    }


    public static Stage getModalPatient() {
        return modalPatient;
    }

    public static void addPatient() throws IOException {

        modalPatient = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/AddPatientView.fxml"));
        AnchorPane addPatientPane = loader.load();
        Scene addPatient = new Scene(addPatientPane);
        modalPatient.setScene(addPatient);
        modalPatient.initModality(Modality.APPLICATION_MODAL);
        modalPatient.show();

    }

    public static void main(String[] args) {

        launch(args);
    }
}
