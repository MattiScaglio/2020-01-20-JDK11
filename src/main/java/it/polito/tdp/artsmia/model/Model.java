package it.polito.tdp.artsmia.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.artsmia.db.ArtsmiaDAO;


public class Model {
	
	ArtsmiaDAO dao;
	private Graph<Artist, DefaultWeightedEdge> grafo;
	private Map<Integer, Artist> idMap;
	
	public Model() {
		this.dao = new ArtsmiaDAO();
		this.idMap = new HashMap<Integer, Artist>();
		this.dao.getAllArtist(idMap);

	}
	
	public void creaGrafo(String role) {
		grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);

		//aggiungo i vertici
		Graphs.addAllVertices(this.grafo, this.dao.getVertici(idMap,role));

		System.out.println("VERTICI FATTI: "+this.grafo.vertexSet().size());
		
		//aggiungo archi
		for(Adiacenza arco : dao.getAdiacenze(idMap, role)) {
			Graphs.addEdgeWithVertices(this.grafo,arco.getA1(),arco.getA2(), arco.getPeso());
		}
		
		System.out.println("ARCHI FATTI: "+grafo.edgeSet().size());

		
	}
	
	public List<Adiacenza> getAdiacenti(String role){
		List<Adiacenza> adiacenti = new LinkedList<>();
		
		for(Adiacenza a :this.dao.getAdiacenze(idMap, role)) {
			adiacenti.add(a);
			System.out.println(a.getA1().getId()+" "+a.getA2().getId()+" "+a.getPeso()+"\n");
		}
		
		System.out.println("ORDINAMENTO IN CORSO...");
		Collections.sort(adiacenti);
		System.out.println("FATTO!");
		
		return adiacenti;
	}

	public int nVertici() {
		return this.grafo.vertexSet().size();
	}

	public int nArchi() {
		return this.grafo.edgeSet().size();
	}

	public List<String> getRuoliVettore() {
		return this.dao.getGenesVettore();
	}

}
