package zengest.jam.service;

import java.util.Date;
import java.util.List;

import zengest.jam.domaine.entities.Produit;
import zengest.jam.domaine.entities.Ravitailler;
import zengest.jam.domaine.entities.Vente;

public interface IRavitailler {
	
	public Ravitailler creer_modifier(Ravitailler rav);
	
	public List<Ravitailler> affichertous();
	public void supprimer(Long id);
	
	public List<Ravitailler> afficherParProduit(Produit prod);
	public List<Ravitailler> afficherParDate(Date date);

	public Ravitailler afficherparid(Long id);
	
	
	

}
