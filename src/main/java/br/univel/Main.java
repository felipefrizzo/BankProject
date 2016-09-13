package br.univel;

import java.io.IOException;

import br.univel.database.person.PersonService;
import br.univel.model.person.Customer;
import br.univel.model.person.Person;
import br.univel.model.person.TypePerson;
import br.univel.model.person.TypePersonFactory;
import br.univel.view.RootLayoutController;
import br.univel.view.login.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Created by felipefrizzo on 8/30/16.
 */
public class Main extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Bank Project Applications");

        this.primaryStage.getIcons().add(new Image("file:resources/images/Currency.png"));

        initRootLayout();
        showLoginLayout();
    }

    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            RootLayoutController controller = loader.getController();
            controller.setMain(this);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void showLoginLayout(){
    	try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/login/LoginLayout.fxml"));
            AnchorPane loginOverview = (AnchorPane) loader.load();

            rootLayout.setCenter(loginOverview);
            LoginController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
