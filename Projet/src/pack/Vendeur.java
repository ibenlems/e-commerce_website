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
	String adresse;
	
	public Vendeur(String nom, String prenom, String adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
	}
	@OneToOne(mappedBy="ownerV",fetch=FetchType.EAGER)
	Compte Vcompte;
	
	@OneToMany(mappedBy="vendeur",fetch=FetchType.EAGER)
    Collection<Produit> Produits;
	
	public int getId() {
		return id;
	}
	
	public Compte getVcompte() {
		return Vcompte;
	}


	public void setVcompte(Compte vcompte) {
		this.Vcompte = vcompte;
	}


	public Collection<Produit> getProduits() {
		return Produits;
	}


	public void setProduits(Collection<Produit> produits) {
		Produits = produits;
	}


	
	
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
