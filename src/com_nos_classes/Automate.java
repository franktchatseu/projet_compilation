package com_nos_classes;

import java.util.List;
import java.util.Stack;

public class Automate {
	
	private int etat_initial;
	private List<Etat_transition> liste_etat;
	
	public Automate(int etat_initial, List<Etat_transition> liste_etat) {
		super();
		this.etat_initial = etat_initial;
		this.liste_etat = liste_etat;
	}

	public int getEtat_initial() {
		return etat_initial;
	}
	
	
	public void setEtat_initial(int etat_initial) {
		this.etat_initial = etat_initial;
	}

	public List<Etat_transition> getListe_etat() {
		return liste_etat;
	}

	public void setListe_etat(List<Etat_transition> liste_etat) {
		this.liste_etat = liste_etat;
	}
	public Automate() {
		// TODO Auto-generated constructor stub
		
	}
	Stack p; 
	
	
	
}
