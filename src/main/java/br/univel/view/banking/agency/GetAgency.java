package br.univel.view.banking.agency;

import java.util.ArrayList;
import java.util.List;

import br.univel.database.agency.AgencyService;
import br.univel.model.agency.Agency;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class GetAgency {
	
	private AgencyService agencyService = new AgencyService();
	private ObservableList<Agency> observableList = FXCollections.observableArrayList();
	private List<Agency> agency = new ArrayList<>();
	
	public GetAgency(){
		agency = agencyService.getAll("from Agency");
		
		for(Agency a : agency){
			observableList.add(a);
		}
	}
	
	public ObservableList<Agency> getObservableList(){
		return observableList;
	}
	
	
}
