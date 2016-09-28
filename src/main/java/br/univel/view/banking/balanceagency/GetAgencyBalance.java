package br.univel.view.banking.balanceagency;

import br.univel.database.operationbanking.OperationBankingService;
import br.univel.model.operationbanking.OperationBanking;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by felipefrizzo on 27/09/16.
 */
public class GetAgencyBalance {
    private OperationBankingService operationBankingService = new OperationBankingService();
    private ObservableList<OperationBanking> observableList = FXCollections.observableArrayList();
    private List<OperationBanking> operationBankings = new ArrayList<>();

    public GetAgencyBalance(){
        operationBankings = operationBankingService.getAll("from OperationBanking");
        for(OperationBanking o : operationBankings){
            observableList.add(o);
        }
    }

    public GetAgencyBalance(Date dateFrom, Date dateTo){
        operationBankings = operationBankingService.getAllByDate(dateFrom, dateTo);
        for(OperationBanking o : operationBankings){
            observableList.add(o);
        }
    }

    public ObservableList<OperationBanking> getObservableList(String numberAgency){
        ObservableList<OperationBanking> list = FXCollections.observableArrayList();
        for (OperationBanking l: operationBankings) {
            if (l.getAccount().getAgency().getNumero().equals(numberAgency)) {
                list.add(l);
            }
        }
        return list;
    }
}
