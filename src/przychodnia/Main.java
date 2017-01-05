package przychodnia;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by adam on 04/01/2017.
 */
public class Main extends Application {

    private Stage primaryStage;
    private static BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) throws IOException {

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Przychodnia");
        this.primaryStage.setMinWidth(1100);
        this.primaryStage.setMinHeight(700);
        initRootLayout();

    }

    public void initRootLayout() throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
        rootLayout = (BorderPane) loader.load();
        Scene scene = new Scene(rootLayout);
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public static void showVisits() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/VisitsView.fxml"));
        AnchorPane testPane = loader.load();
        rootLayout.setCenter(testPane);

    }

    public static void main(String[] args) {
        launch(args);
    }
}
