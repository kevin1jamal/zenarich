package zengest.jam.dto;

import java.util.Date;

import zengest.jam.domaine.entities.Produit;
import zengest.jam.domaine.entities.User;

public class VenteDto {
	
	private int qte;
	private int total;
	private String date;
	private Produit produit;
	private Long prod_id;
	
	private User acheteur;
	private String ach_email;
	
	
	
	
	
	public String getAch_email() {
		return ach_email;
	}
	public void setAch_email(String ach_email) {
		this.ach_email = ach_email;
	}
	public User getAcheteur() {
		return acheteur;
	}
	public void setAcheteur(User acheteur) {
		this.acheteur = acheteur;
	}
	
	public Long getProd_id() {
		return prod_id;
	}
	public void setProd_id(Long prod_id) {
		this.prod_id = prod_id;
	}
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public VenteDto(int qte, int total, String date, Produit produit) {
		super();
		this.qte = qte;
		this.total = total;
		this.date = date;
		this.produit = produit;
	}
	public VenteDto() {
		super();
	}
	
	

}
