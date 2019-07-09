package zengest.jam.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zengest.jam.domaine.entities.Produit;
import zengest.jam.domaine.entities.Ravitailler;

import zengest.jam.repository.RavitaillerRepository;

@Service
public class RavitaillerImpl implements IRavitailler{

	@Autowired
	RavitaillerRepository ravit;
	@Override
	public Ravitailler creer_modifier(Ravitailler rav) {
		// permet de creer un depot et modifier
		return ravit.save(rav);
	}

	@Override
	public List<Ravitailler> affichertous() {
		//afficher tous les depot de la bd
		return ravit.findAll();
	}

	@Override
	public void supprimer(Long id) {
		//permeet de supprimer un depot
		ravit.deleteById(id);
		
	}

	@Override
	public List<Ravitailler> afficherParProduit(Produit prod) {
		// affiche tous les depot d'un produit
		return ravit.findByProduit(prod);
	}

	@Override
	public List<Ravitailler> afficherParDate(Date date) {
		// affiche les depot à une date données
		return ravit.findByDate(date);
	}

	@Override
	public Ravitailler afficherparid(Long id) {
		// affiche un depot par id
		return ravit.getOne(id);
	}

}
