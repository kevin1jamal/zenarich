package zengest.jam.dto;

import java.util.Date;

import zengest.jam.domaine.entities.Produit;

public class RavitaillerDto {
	
	private Long id;
	private String date;
	private int qte;
	private Long prod_id;
	
	private Produit produit;

	
	public RavitaillerDto() {
		super();
	}

	public RavitaillerDto(String date, int qte, Produit produit) {
		super();
		this.date = date;
		this.qte = qte;
		this.produit = produit;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProd_id() {
		return prod_id;
	}

	public void setProd_id(Long prod_id) {
		this.prod_id = prod_id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	
	
	
}
