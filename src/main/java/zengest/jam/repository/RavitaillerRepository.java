package zengest.jam.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import zengest.jam.domaine.entities.Produit;
import zengest.jam.domaine.entities.Ravitailler;



public interface RavitaillerRepository extends JpaRepository<Ravitailler,Long> {
	
 List<Ravitailler> findByProduit(Produit prod);
 
  Optional<Ravitailler> findById(Long id);
  
  List<Ravitailler> findByDate(Date d);
  
	
	
}
