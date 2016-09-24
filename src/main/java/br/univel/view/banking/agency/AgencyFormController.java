package br.univel.view.banking.agency;

import br.univel.Main;
import br.univel.database.agency.AgencyService;
import br.univel.model.agency.Agency;
import br.univel.model.agency.AgencyFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class AgencyFormController {

	private Main main;
	private Agency agency;
	private AgencyService agencyService = new AgencyService();
	private AgencyFactory agencyFactory = new AgencyFactory();
	
	
	public void setAgency(Agency agency){
		this.agency = agency;
	}
	
	@FXML
	private TextField number;

	@FXML
	private TextField city;

	@FXML
	private TextField name;

	public void setMain(Main main) {
		this.main = main;
	}
	
	@FXML
	private void NewAgency(){
		
		if(isInputValid()){
			if(agencyService.getByNumberAgency(number.getText())== null){
				agency = agencyFactory.create(name.getText(), number.getText(), city.getText());				
			}else{
				showError(
						"Erro",
						"Agência ja cadastrada", 
						"Esse numero de agencia ja esta cadastrado, por favor , digite outro "
				);
			}
		}
	}
	
	
	
	private boolean isInputValid(){
		String errorMessage = "";
		if (this.number.getText() == null || this.number.getLength() == 0) {
			errorMessage += "Por favor , Informe o numero da agencia";
		}
		
		if (this.city.getText() == null || this.city.getLength() == 0){
			errorMessage += "Por favor , informe o nome da cidade";
		}
		
		if (this.name.getText() == null || this.name.getLength() == 0){
			errorMessage += "Por favor ,, informe o nome da agencia ";
		}
		if (errorMessage.equals("")) {
			return true;
		} else {
			showError("Erros", "Por favor corrija os campos Inválidos", errorMessage);
			return false;
		}
	
	}
	protected void showError(String title, String headerTitle, String contentText) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.initOwner(main.getPrimaryStage());
		alert.setTitle(title);
		alert.setHeaderText(headerTitle);
		alert.setContentText(contentText);

		alert.showAndWait();
	}
}

	