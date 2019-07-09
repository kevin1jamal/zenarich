package zengest.jam.service;

import java.util.Date;
import java.util.List;

import zengest.jam.domaine.entities.Produit;
import zengest.jam.domaine.entities.Vente;

public interface IVente {
	
	public Vente creer_modifier(Vente vente);
	public List<Vente> affichertous();
	public Vente afficherparid(Long id);
	public void supprimer(Long id);
	public List<Vente> afficherparDate(Date date);
	public List<Vente> afficher_vente_par_produit(Produit prod);
	public void suprimer(Long id);
	
	

}
