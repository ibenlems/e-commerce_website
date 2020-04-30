package pack;
import java.util.Collection;

import javax.persistence.*;

@Entity
public class Acheteur  {

	Integer note;
	String nom;
	String prenom;
	String Adresse;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@OneToMany(mappedBy="acheteur",fetch=FetchType.EAGER) //chargement du panier
	Collection<Produit>  Produits ;
	
	@OneToOne(mappedBy="ownerA",fetch=FetchType.EAGER)
	Compte Acompte;
	
	
	
	public Compte getAcompte() {
		return Acompte;
	}

	public void setAcompte(Compte acompte) {
		this.Acompte = acompte;
	}

	public Acheteur() {};
	


	public Acheteur(String nom, String prenom, String adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		Adresse = adresse;
	}

	public Integer getNote() {
		return note;
	}

	public void setNote(Integer note) {
		this.note = note;
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

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Collection<Produit> getArticles() {
		return Produits;
	}

	public void setArticles(Collection<Produit> listes_articles) {
		this.Produits = listes_articles;
	}
	
	
	
}
