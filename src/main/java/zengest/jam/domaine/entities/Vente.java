package zengest.jam.domaine.entities;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Vente {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private int qte;
	private int total_montant;
	
	private String date;
	private int total_pv;
	@ManyToOne
	private Produit produit;
	@ManyToOne
	private User user;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	public int getTotal_montant() {
		return total_montant;
	}
	public void setTotal_montant(int total_montant) {
		this.total_montant = total_montant;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getTotal_pv() {
		return total_pv;
	}
	public void setTotal_pv(int total_pv) {
		this.total_pv = total_pv;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	

}
