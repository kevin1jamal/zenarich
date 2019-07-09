package zengest.jam.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zengest.jam.domaine.entities.Produit;
import zengest.jam.domaine.entities.Vente;
import zengest.jam.repository.VenteRepository;

@Service
public class VenteImpl implements IVente {

	@Autowired
	VenteRepository ventrep;
	
	@Override
	public Vente creer_modifier(Vente vente) {
		// permet de creer une vente
		return ventrep.save(vente);
	}

	@Override
	public List<Vente> affichertous() {
		// liste toutes les ventes de la base de donnees
		return ventrep.findAll();
	}

	@Override
	public void supprimer(Long id) {
		// permet de supprimer une vente
		ventrep.deleteById(id);
		
	}

	@Override
	public List<Vente> afficherparDate(Date date) {
		// permet de voir la liste a une date donnees 
		return ventrep.findByDate(date);
	}

	@Override
	public List<Vente> afficher_vente_par_produit(Produit prod) {
		// permet de voire toutes les ventes d'un produit donnee
		return ventrep.findByProduit(prod);
	}

	@Override
	public void suprimer(Long id) {
		// permet de supprimer une vente
		
		ventrep.deleteById(id);
		
	}

	@Override
	public Vente afficherparid(Long id) {
		// permet d'afficher par id
		return ventrep.getOne(id);
	}

}
