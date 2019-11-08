package com_interface;

import java.util.List;

import com_nos_classes.Automate;
import com_nos_classes.Etat_transition;
import com_nos_classes.Stockage;
import com_nos_classes.Transition;

public interface Nos_fonctions {
	
	//fonctions de verification de nos chaines de caracteres. utilisateur a t'il entre une expression reguliere correcte?
	public boolean verification(String chaine_a_verifier);
	
	//operateurs ou symbole?
	public boolean isOperateur(char valeur);
	//mise sous forme postfixe
	public List<Stockage> inFixer(String value);
	//mise sous forme postfixé
	public List<Stockage> postFixer(List<Stockage> lss);
	
	//nos differentes fonctions elementaires pour la construction de thomson
	public Automate construction(char symbole);
	
	public Automate concatenation (Automate a1,Automate a2);
	
	public Automate union(Automate a1,Automate a2);
	
	public Automate multiplicite(Automate a);
	public Automate ajout_transtion_aut(Automate a,Transition t);
	//differentes fonctions pour la suite
	public void afficher_automate(Automate a);
	public Etat_transition etat_final_ele(Automate a);
	
	//clonage d'un automate
		
}