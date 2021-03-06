package fr.afcepf.al32.devise.dto;

import java.io.Serializable;

public class Devise implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	String monnaie; // ex : "eur", "usd", "gbp", "jpy"
	Double change; // change pour 1€

	public String toString() {
		return "Devise [monnaie=" + monnaie + ", change=" + change + "]";
	}
	
	// constructeurs (vide, plein)
	public Devise() {
	}
	
	public Devise(String monnaie, Double change) {
		super();
		this.monnaie = monnaie;
		this.change = change;
	}
	// getters & setters
	public String getMonnaie() {
		return monnaie;
	}
	public void setMonnaie(String monnaie) {
		this.monnaie = monnaie;
	}
	public Double getChange() {
		return change;
	}
	public void setChange(Double change) {
		this.change = change;
	}
	
	
}
