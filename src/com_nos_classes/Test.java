package com_nos_classes;

import com_implementation.Traitement;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Traitement t=new Traitement();
		
		Automate a1=t.construction('a');
	    Automate a2=t.construction('b');
		//Automate a3=t.concatenation(a1, a2);
		Automate a4=t.multiplicite(a1);
		Automate a5=t.concatenation(a2, a4);
	Automate a6=t.union(a1, a2);
		//System.out.print(a3.getEtat_initial().getEtiquette_etat());
		//t.afficher_automate(t.concatenation(t.construction('c',5,6), a3));
		t.afficher_automate(a6);
		//System.out.print(t.etat_final_ele(a1).getEtiquette_etat());
	}

}
