package pack;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Client {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)  
	int id;
	String nom;
	String prenom;
	
	@OneToOne(mappedBy="owner", fetch = FetchType.EAGER)
	Compte compte;
	
	public int getId() {
		return id;
	}

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


	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte Compte) {
		this.compte = Compte;
	}

	
}
