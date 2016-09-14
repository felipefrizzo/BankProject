package br.univel;

import br.univel.view.RootLayoutController;
import br.univel.view.cashwithdrawl.CashWithdrawalController;
import br.univel.view.deposit.DepositController;
import br.univel.view.login.LoginController;
import br.univel.view.main.MainCustomerController;
import br.univel.view.payment.PaymentController;
import br.univel.view.transfer.TransferController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

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

    public void showMainCustomerLayout() {
        this.primaryStage.setTitle("Bank Project Applications");
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/main/MainCustomerLayout.fxml"));
            AnchorPane mainOverview = (AnchorPane) loader.load();

            rootLayout.setCenter(mainOverview);
            MainCustomerController controller = loader.getController();
            controller.setMain(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showMainBankingLayout() {
        System.out.println("MAIN BANKING");
    }

    public void showCashWithdrawal() {
        this.primaryStage.setTitle("Bank Project Applications - Cash Withdrawal");
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/cashwithdrawl/CashWithdrawalLayout.fxml"));
            AnchorPane mainOverview = (AnchorPane) loader.load();

            rootLayout.setCenter(mainOverview);
            CashWithdrawalController controller = loader.getController();
            controller.setMain(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showDeposit() {
        this.primaryStage.setTitle("Bank Project Applications - Deposit");
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/deposit/DepositLayout.fxml"));
            AnchorPane mainOverview = (AnchorPane) loader.load();

            rootLayout.setCenter(mainOverview);
            DepositController controller = loader.getController();
            controller.setMain(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showPayment() {
        this.primaryStage.setTitle("Bank Project Applications - Payment");
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/payment/PaymentLayout.fxml"));
            AnchorPane mainOverview = (AnchorPane) loader.load();

            rootLayout.setCenter(mainOverview);
            PaymentController controller = loader.getController();
            controller.setMain(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showTransfer() {
        this.primaryStage.setTitle("Bank Project Applications - Transfer");
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/transfer/TransferLayout.fxml"));
            AnchorPane mainOverview = (AnchorPane) loader.load();

            rootLayout.setCenter(mainOverview);
            TransferController controller = loader.getController();
            controller.setMain(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
