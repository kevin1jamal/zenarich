package zengest.jam.domaine.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class Offre {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String image;
	private String description;
	private String titre;
	private int prix;
	private Date date_debut;
	private Date date_fin;
	@OneToMany
    private List<Commentaire> commentaire;
	
	

}
