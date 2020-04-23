package pack;

import java.util.Collection;

import javax.persistence.*;

@Entity
public class Vendeur {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	String nom;
	String prenom;
	public int getId() {
		return id;
	}
	
	public Compte getVcompte() {
		return vcompte;
	}


	public void setVcompte(Compte vcompte) {
		this.vcompte = vcompte;
	}


	public Collection<Produit> getProduits() {
		return Produits;
	}


	public void setProduits(Collection<Produit> produits) {
		Produits = produits;
	}

	@OneToOne(mappedBy="ownerv",fetch=FetchType.EAGER)
	Compte vcompte;
	
	@OneToMany(mappedBy="personne",fetch=FetchType.EAGER)
    Collection<Produit> Produits;
	
	
	
	public Vendeur() {};
	
	
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
