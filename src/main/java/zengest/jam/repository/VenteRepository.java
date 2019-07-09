package zengest.jam.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import zengest.jam.domaine.entities.Produit;
import zengest.jam.domaine.entities.Vente;


public interface VenteRepository  extends JpaRepository<Vente,Long>{
	
	List<Vente> findByProduit(Produit prod);
	List<Vente> findByDate(Date date);

}
