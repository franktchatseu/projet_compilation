package com_implementation;

import java.util.ArrayList;
import java.util.List;

import com_interface.Nos_fonctions;
import com_nos_classes.Automate;
import com_nos_classes.Etat_transition;
import com_nos_classes.Stockage;
import com_nos_classes.Transition;

public class Traitement implements Nos_fonctions{

	@Override
	public boolean verification(String chaine_a_verifier) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isOperateur(char valeur) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public List<Stockage> inFixer(String value) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Stockage> postFixer(List<Stockage> ls) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Automate construction(char symbole) {
		// TODO Auto-generated method stub
		List<Transition>list_t=new ArrayList<Transition>();
		List<Etat_transition> list_etats=new ArrayList<Etat_transition>();
		Transition t=new Transition(symbole,new Etat_transition(2, null,true));
		list_t.add(t);
		Etat_transition etat=new Etat_transition(1,list_t ,false );
		list_etats.add(etat);
		Automate a=new Automate(1, list_etats);
		return a;
	}

	@Override
	public Automate concatenation(Automate a1, Automate a2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Automate union(Automate a1, Automate a2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Automate multiplicite(Automate a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Automate ajout_transtion_aut(Automate a, Transition t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void afficher_automate(Automate a) {
		// TODO Auto-generated method stub
		for (Etat_transition etat : a.getListe_etat()) {
			for (Transition t : etat.getListe_de_transition()) {
				System.out.println(etat.getEtiquette_etat()+ " "+t.getSymbole()+" "+t.getDestination().getEtiquette_etat());
			}
		}
		
	}

	
	

}
