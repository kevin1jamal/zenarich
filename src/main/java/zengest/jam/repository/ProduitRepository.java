package zengest.jam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import zengest.jam.domaine.entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit,Long> {
	Produit findByNom(String nom);
	

}
