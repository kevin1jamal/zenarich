package zengest.jam.domaine.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor


public class Modele {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String image;
	private String description;
	private String titre;
	@ManyToOne(fetch=FetchType.LAZY)
	private User user;
	
}
