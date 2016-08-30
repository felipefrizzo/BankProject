package br.univel;

import br.univel.view.login.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by felipefrizzo on 8/10/16.
 */
public class Main extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;

    public Main() {
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Bank Project Applications");

        this.primaryStage.getIcons().add(new Image("file:resources/images/Currency.png"));

        initLoginLayout();
    }

    public void initLoginLayout() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(Main.class.getResource("view/LoginLayout.xml"));

            rootLayout = (BorderPane) fxmlLoader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            LoginController controller = fxmlLoader.getController();
            controller.setMain(this);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
