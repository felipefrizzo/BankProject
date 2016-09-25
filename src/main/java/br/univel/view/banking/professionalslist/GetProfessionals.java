package br.univel.view.banking.professionalslist;

import java.util.ArrayList;
import java.util.List;

import br.univel.database.person.PersonService;
import br.univel.model.agency.Agency;
import br.univel.model.person.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class GetProfessionals {

	private PersonService personService = new PersonService();
	private ObservableList<Person> observableList = FXCollections.observableArrayList();
	private List<Person> person = new ArrayList<>();
	
	public GetProfessionals(){
		person = personService.getAllBankings();
		
		for(Person p : person){
			observableList.add(p);
		}
	}
	
	public ObservableList<Person> getObservableList(){
		return observableList;
	}
}
