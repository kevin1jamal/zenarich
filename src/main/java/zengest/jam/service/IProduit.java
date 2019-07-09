package zengest.jam.service;

import java.util.List;

import zengest.jam.domaine.entities.Produit;
import zengest.jam.domaine.entities.Ravitailler;
import zengest.jam.domaine.entities.Vente;

public interface IProduit {
	public Produit creer_modifierProduit(Produit prod);
	public List<Produit> affichertous();
	public Produit rechercherparnom(String nom);
	public Produit rechercherparid(Long id);
	public Produit ravitaillerproduit(Ravitailler ravprod);
	public Produit faireunevente(Vente vente);

}
