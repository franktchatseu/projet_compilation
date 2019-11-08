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
		//creation de etat initial
		Etat_transition etat_debut=new Etat_transition(list_t ,false );
		List<Etat_transition> list_etats=new ArrayList<Etat_transition>();
		Etat_transition etat_fin=new Etat_transition(new ArrayList<Transition>(),true);
		Transition t=new Transition(symbole,etat_fin);
		list_t.add(t);
		
		list_etats.add(etat_debut);
		list_etats.add(etat_fin);
		Automate a=new Automate(etat_debut, list_etats);
		return a;
	}

	@Override
	public Automate concatenation(Automate a1, Automate a2) {
		Automate a;
		Transition t=new Transition('£', a2.getEtat_initial());
		
		//on ajoute une une epsilonne transition a ancien etat d'acceoption vers etat initial de autre automate
		etat_final_ele(a1).getListe_de_transition().add(t);
		//on supprime l'ancien etat acceptation 
				etat_final_ele(a1).setIsfinal(false);
		//liste des etats finaux apres concatenation
		for(Etat_transition etat1:a2.getListe_etat()) {
			a1.getListe_etat().add(etat1);
		}
		a=new Automate(a1.getEtat_initial(), a1.getListe_etat());
		
		
		return a1;
	}

	@Override
	public Automate union(Automate a1, Automate a2) {
		// TODO Auto-generated method stub
		
		Transition t=new Transition('£', a1.getEtat_initial());
		Transition t1=new Transition('£', a2.getEtat_initial());
		//creation de etat finale de automate resultant
		Etat_transition etat_fin=new Etat_transition(new ArrayList<Transition>(), true);
		//creation des transitions vers etats finals crée
		Transition t2=new Transition('£',etat_fin);
		Transition t3=new Transition('£',etat_fin);
		//liste de transition pour etat initial
		List<Transition> list_trans_etat_init=new ArrayList<Transition>();
		//ajout des differentes transitions a la liste
		list_trans_etat_init.add(t);
		list_trans_etat_init.add(t1);
		//on associe la liste de transition a etat
		Etat_transition etat_init=new Etat_transition(list_trans_etat_init, false);
		//ajout des transtions aux anciens etats finaux
		etat_final_ele(a1).getListe_de_transition().add(t2);
		etat_final_ele(a2).getListe_de_transition().add(t3);
		
	//	mettre les etats finaux de a1 et a2 à false
		etat_final_ele(a2).setIsfinal(false);
		etat_final_ele(a1).setIsfinal(false);
		//nouvelle liste des etats du nouveau automate
		List<Etat_transition> listes_etats=new ArrayList<Etat_transition>();
		listes_etats=a1.getListe_etat();
		listes_etats.add(etat_init);
		listes_etats.add(etat_fin);
		//on parcourt et on ajoute les etats de autres automates
		for(Etat_transition etat:a2.getListe_etat()) {
			listes_etats.add(etat);
			
		}
		//creation de notre automate
		Automate a=new Automate(etat_init, listes_etats);
		return a;
	}

	@Override
	public Automate multiplicite(Automate a) {
		// TODO Auto-generated method stub
		//expi
		Transition t1=new Transition('£', a.getEtat_initial());
		
		List<Transition> list_transition=new ArrayList<Transition>();
		list_transition.add(t1);
		//on cree un nouvel etat de debut qui sera maintenant etat initial
		Etat_transition etat_debut=new Etat_transition(list_transition,false);
		//on cree un etat de fin qui sera maintenant etat final
		Etat_transition etat_fin=new Etat_transition(new ArrayList<Transition>(),true);
		//espsilonne transition vers etat de fin
		Transition t3=new Transition('£',etat_fin);
		//cette epsilonne transition part de l'ancien etat final à ancien etat initial
		etat_final_ele(a).getListe_de_transition().add(t1);
		//epsilonne transition de ancien etat final vers le nouveau
		etat_final_ele(a).getListe_de_transition().add(t3);
		//ancien etat final n'est plus un etat acception
		etat_final_ele(a).setIsfinal(false);
		etat_debut.getListe_de_transition().add(new Transition('£', etat_fin));
//		a la fin on ajoute les deux etats debut et fin à la liste des etats.
		a.getListe_etat().add(etat_debut);
		a.getListe_etat().add(etat_fin);
		//puis on contruit automate final
		
		Automate automate=new Automate(etat_debut,a.getListe_etat()); 
		return automate;
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
			if(!(etat.getListe_de_transition().isEmpty())) {
					for (Transition t : etat.getListe_de_transition()) {
						System.out.println(etat.getEtiquette_etat()+ " "+t.getSymbole()+" "+t.getDestination().getEtiquette_etat());
					}
			}
		}
		
	}

	@Override
	public Etat_transition etat_final_ele(Automate a) {
		// TODO Auto-generated method stub
		for(Etat_transition etats:a.getListe_etat()) {
			if(etats.isIsfinal()==true)
				return etats;
		}
		return null;
	}

	
	

}
