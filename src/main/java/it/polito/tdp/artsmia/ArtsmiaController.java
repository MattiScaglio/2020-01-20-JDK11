package it.polito.tdp.artsmia;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.artsmia.model.Adiacenza;
import it.polito.tdp.artsmia.model.Model;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ArtsmiaController {
	
	private Model model ;
	

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCreaGrafo;

    @FXML
    private Button btnArtistiConnessi;

    @FXML
    private Button btnCalcolaPercorso;

    @FXML
    private ComboBox<String> boxRuolo;

    @FXML
    private TextField txtArtista;

    @FXML
    private TextArea txtResult;

    @FXML
    void doArtistiConnessi(ActionEvent event) {
    	txtResult.clear();
    	
    	String role = boxRuolo.getValue();
    	
    	for(Adiacenza a :this.model.getAdiacenti(role)) {
    		txtResult.appendText(a.getA1()+", "+a.getA2()+"con peso "+a.getPeso());
    	}
    }

    @FXML
    void doCalcolaPercorso(ActionEvent event) {
    	txtResult.clear();
    	txtResult.appendText("Calcola percorso");
    }

    @FXML
    void doCreaGrafo(ActionEvent event) {
    	
    	String ruolo=boxRuolo.getValue();
    	model.creaGrafo(ruolo);
    	
    	txtResult.appendText("GRAFO CREATO"+"\n");
    	
    	txtResult.appendText("#VERTICI "+Integer.toString(model.nVertici())+"\n");
    	txtResult.appendText("#ARCHI "+Integer.toString(model.nArchi())+"\n");
    		
    }

    public void setModel(Model model) {
    	
    	this.model = model;
    	for(String g: this.model.getRuoliVettore()) {
        	boxRuolo.getItems().add(g);

    	}
    	
    	this.model = model;
    }

    
    @FXML
    void initialize() {
        assert btnCreaGrafo != null : "fx:id=\"btnCreaGrafo\" was not injected: check your FXML file 'Artsmia.fxml'.";
        assert btnArtistiConnessi != null : "fx:id=\"btnArtistiConnessi\" was not injected: check your FXML file 'Artsmia.fxml'.";
        assert btnCalcolaPercorso != null : "fx:id=\"btnCalcolaPercorso\" was not injected: check your FXML file 'Artsmia.fxml'.";
        assert boxRuolo != null : "fx:id=\"boxRuolo\" was not injected: check your FXML file 'Artsmia.fxml'.";
        assert txtArtista != null : "fx:id=\"txtArtista\" was not injected: check your FXML file 'Artsmia.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Artsmia.fxml'.";

    }
    

    
}
