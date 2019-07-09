package zengest.jam.dto;

import java.io.Serializable;

public class ProduitDto implements Serializable {
	private Long id;
	private String nom ;
	private int prix;
	private int pv;
	private String image;
	private String desc;
	private int stock;
	
	
	
	
	
	public ProduitDto() {
		super();
	}
	public ProduitDto(Long id, String nom, int prix, int pv, String image, String desc, int stock) {
		super();
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		this.pv = pv;
		this.image = image;
		this.desc = desc;
		this.stock = stock;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	
	
	public int getPv() {
		return pv;
	}
	public void setPv(int pv) {
		this.pv = pv;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getPrix() {
		return prix;
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	

}
