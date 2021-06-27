package it.polito.tdp.artsmia.model;

public class Adiacenza implements Comparable<Adiacenza>{
	
	Artist a1;
	Artist a2;
	int peso;
	
	
	public Adiacenza(Artist a1, Artist a2, int peso) {
		super();
		this.a1 = a1;
		this.a2 = a2;
		this.peso = peso;
	}


	public Artist getA1() {
		return a1;
	}


	public void setA1(Artist a1) {
		this.a1 = a1;
	}


	public Artist getA2() {
		return a2;
	}


	public void setA2(Artist a2) {
		this.a2 = a2;
	}


	public int getPeso() {
		return peso;
	}


	public void setPeso(int peso) {
		this.peso = peso;
	}


	@Override
	public int compareTo(Adiacenza a1) {
		if(this.getPeso() > a1.getPeso()){
			return -1;
		}else {
			return +1;
		}
		
	}



	
	
}
