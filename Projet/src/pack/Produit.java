package pack;

import java.awt.Image;

import javax.persistence.*;

public class Produit {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	String nom;
	
	String description;
	
	@ManyToOne()
	Acheteur acheteur;
	
	@ManyToOne()
	Vendeur vendeur;
	
	
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
	public Acheteur getAcheteur() {
		return acheteur;
	}
	public void setAcheteur(Acheteur acheteur) {
		this.acheteur = acheteur;
	}
	public Vendeur getVendeur() {
		return vendeur;
	}
	public void setVendeur(Vendeur vendeur) {
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
