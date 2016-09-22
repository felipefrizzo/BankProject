package br.univel;

import br.univel.model.account.Account;
import br.univel.model.account.AccountInterface;
import br.univel.model.account.AccountObserver;
import br.univel.model.person.Person;
import br.univel.view.RootLayoutController;
import br.univel.view.balance.BalanceController;
import br.univel.view.banking.main.MainBankingController;
import br.univel.view.banking.newaccount.NewAccountController;
import br.univel.view.cashwithdrawl.CashWithdrawalController;
import br.univel.view.deposit.DepositController;
import br.univel.view.login.LoginController;
import br.univel.view.main.MainCustomerController;
import br.univel.view.operation.OperationController;
import br.univel.view.passwordmodal.PasswordModalController;
import br.univel.view.payment.PaymentController;
import br.univel.view.transfer.TransferController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by felipefrizzo on 8/30/16.
 */
public class Main extends Application implements AccountObserver {
    final List<MainObserver> observers = new ArrayList<>();

    private Account account;
    private Stage primaryStage;
    private BorderPane rootLayout;

    public void notifyObservers() {
        for (final MainObserver observer : observers) {
            observer.showAccountInformation(this);
        }
    }

    public void addObservers(MainObserver observer) {
        this.observers.add(observer);
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
        account.addObservers(this);
        notifyObservers();
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

            this.addObservers(controller);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showLoginLayout() {
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

            addObservers(controller);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showMainBankingLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/banking/main/MainBanking.fxml"));
            AnchorPane mainOverview = (AnchorPane) loader.load();

            rootLayout.setCenter(mainOverview);
            MainBankingController controller = loader.getController();
            controller.setMain(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean showPasswordModal(Person person) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/passwordmodal/PasswordModalLayout.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Bank Project Applications - Password");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            PasswordModalController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPerson(person);

            dialogStage.showAndWait();

            return controller.isOkPassword();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
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

    public void showBalance() {
        this.primaryStage.setTitle("Bank Project Applications - Balance");
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/balance/BalanceLayout.fxml"));
            AnchorPane mainOverview = (AnchorPane) loader.load();

            rootLayout.setCenter(mainOverview);
            BalanceController controller = loader.getController();
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

    public void showOperation(String operation, BigDecimal value) {
        this.primaryStage.setTitle("Bank Project Applications - Operation");
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/operation/OperationLayout.fxml"));
            AnchorPane mainOverview = (AnchorPane) loader.load();

            rootLayout.setCenter(mainOverview);
            OperationController controller = loader.getController();
            controller.setMain(this);
            controller.setOperation(operation);
            controller.setValue(value);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showNewAccount() {
        this.primaryStage.setTitle("Bank Project Applications - New Account");
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/banking/newaccount/NewAccount.fxml"));
            AnchorPane mainOverview = (AnchorPane) loader.load();

            rootLayout.setCenter(mainOverview);
            NewAccountController controller = loader.getController();
            controller.setMain(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void haveChanges(AccountInterface account) {
        notifyObservers();
    }
}
