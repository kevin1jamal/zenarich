package zengest.jam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zengest.jam.domaine.entities.Produit;
import zengest.jam.domaine.entities.Ravitailler;
import zengest.jam.domaine.entities.Vente;
import zengest.jam.repository.ProduitRepository;
import zengest.jam.repository.VenteRepository;

@Service
public class ProduitImpl implements IProduit{
	@Autowired
	ProduitRepository prodR;
	@Autowired
	IRavitailler ravi ;
	@Autowired
	VenteRepository venteR;

	

	public Produit creer_modifierProduit(Produit prod) {
		// permet de creer et modifier un produit
		return prodR.save(prod);
	}

	public List<Produit> affichertous() {
		// affiche la liste complete des produits
		return prodR.findAll();
	}

	public Produit rechercherparnom(String nom) {
		// recherche un produit ayant un nom preci
		return prodR.findByNom(nom);
	}

	public Produit rechercherparid(Long id) {
		// recherche un produit par id
		return prodR.getOne(id);
	}

	@Override
	public Produit ravitaillerproduit(Ravitailler ravprod) {
		// permet d 'ajouter le stock
		
		Produit rprod = ravprod.getProduit();
		int nstock = rprod.getStock() + ravprod.getQte();
		rprod.setStock(nstock);
		ravi.creer_modifier(ravprod);
		
		
		return prodR.save(rprod);
	}

	@Override
	public Produit faireunevente(Vente vente) {
		//  permet de reduire le stock apres une vente
		Produit vprod = vente.getProduit();
		int nstock;
		if(vente.getQte()<=vprod.getStock()) {
			
		nstock = vprod.getStock() - vente.getQte();	
		vprod.setStock(nstock);
			
		}
		venteR.save(vente);
		return prodR.save(vprod);
	}

}
