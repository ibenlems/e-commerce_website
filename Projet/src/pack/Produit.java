package pack;

import java.awt.Image;

import javax.persistence.*;

public class Produit {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	String nom;
	
	String description;
	
	String ImagUrl;
	
	int prix;
	
	public String getImagUrl() {
		return ImagUrl;
	}



	public void setImagUrl(String imagUrl) {
		ImagUrl = imagUrl;
	}



	public int getPrix() {
		return prix;
	}



	public void setPrix(int prix) {
		this.prix = prix;
	}



	@ManyToOne()
	Client acheteur;
	
	@ManyToOne()
	Client vendeur;
	
	
	@Lob
	@Basic(fetch = FetchType.LAZY)
	private byte[] Picture;
	
	public Produit(String nom, String description) {
		super();
		this.nom = nom;
		this.description = description;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	public Produit() {};
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Client getAcheteur() {
		return acheteur;
	}
	public void setAcheteur(Client acheteur) {
		this.acheteur = acheteur;
	}
	public Client getVendeur() {
		return vendeur;
	}
	public void setVendeur(Client vendeur) {
		this.vendeur = vendeur;
	}



	public byte[] getPicture() {
		return Picture;
	}



	public void setPicture(byte[] picture) {
		Picture = picture;
	}
	
	/*public Image generateImage(Produit p) {
	    int id = p.getId();
	    StreamResource sr = new StreamResource("p", () ->  {
	        User attached = userRepository.findWithPropertyPictureAttachedById(id);
	        return new ByteArrayInputStream(attached.getProfilePicture());
	    });
	    sr.setContentType("image/png");
	    Image image = new Image(sr, "profile-picture");
	    return image;
	}*/
	
	
	
}
