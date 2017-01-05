package przychodnia;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by adam on 04/01/2017.
 */
public class Main extends Application {

    private Stage primaryStage;
    private static StackPane rootLayout;

    @Override
    public void start(Stage primaryStage) throws IOException {

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Przychodnia");
        initRootLayout();

    }

    public void initRootLayout() throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
        rootLayout = (StackPane) loader.load();
        Scene scene = new Scene(rootLayout);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
