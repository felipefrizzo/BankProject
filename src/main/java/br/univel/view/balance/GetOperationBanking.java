package br.univel.view.balance;

import br.univel.database.operationbanking.OperationBankingService;
import br.univel.model.operationbanking.OperationBanking;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by felipefrizzo on 9/22/16.
 */
public class GetOperationBanking {
    private OperationBankingService operationBankingService = new OperationBankingService();
    private ObservableList<OperationBanking> observableList = FXCollections.observableArrayList();
    private List<OperationBanking> operationBanking = new ArrayList<OperationBanking>();

    public GetOperationBanking(Long idAccount) {
        operationBanking = operationBankingService.getAllByAccount(idAccount);

        for (OperationBanking operation: operationBanking) {
            observableList.add(operation);
        }
    }

    public GetOperationBanking(Long idAccount, Date dateFrom, Date dateTo) {
        operationBanking = operationBankingService.getAllByAccountByDate(idAccount, dateFrom, dateTo);

        for (OperationBanking operation: operationBanking) {
            observableList.add(operation);
        }
    }

    public ObservableList<OperationBanking> getObservableList() {
        return observableList;
    }
}
