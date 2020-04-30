package pack;
import java.util.*;

import javax.ejb.Singleton;
import javax.persistence.*;



@Singleton
public class Facade {
	
	@PersistenceContext
	private EntityManager em;
		
	public void ajoutAcheteur(String nom,String prenom,String adresse) {
		Acheteur a = new Acheteur(nom,prenom,adresse);
		em.persist(a);
	}
	
	
	public void ajoutVendeur(String nom,String prenom,String adresse) {
		Vendeur v = new Vendeur(nom,prenom,adresse);
		em.persist(v);
	}
	
	
	public void ajoutProduit(String nom,String description) {
		Produit p = new Produit(nom,description);
		em.persist(p);
	}
	
	
	public void retirerProduit(String nom) {
		  Query query = em.createQuery(
		"DELETE FROM Produit p WHERE p.nom="+nom);
	  int deletedCount = query.executeUpdate();
	}
	
	public void retirerProduit(int id) {
		  Produit p = em.find(Produit.class, id);

		  em.getTransaction().begin();
		  em.remove(p);
		  em.getTransaction().commit();
	}
	
	public void rajouter(Produit p, Client c) {
		c.getArticles().add(p);
	}
	
	public void retirer(Produit p, Client c) {
		c.getArticles().remove(p);
	}
	
	
	public Collection<Acheteur> listeAcheteurs(){
		TypedQuery<Acheteur> req = em.createQuery("select a from Acheteur a",Acheteur.class);
		Collection<Acheteur> clients = req.getResultList();
		return clients;
	}
	
	public Collection<Vendeur> listeVendeurs(){
		TypedQuery<Vendeur> req = em.createQuery("select v from Vendeur v",Vendeur.class);
		Collection<Vendeur> clients = req.getResultList();
		return clients;
	}
	
	public Collection<Produit> listeProduits(){
		TypedQuery<Produit> req = em.createQuery("select p from Produit p",Produit.class);
		Collection<Produit> produits = req.getResultList();
		return produits;
	}
	
	
	public void associerA(int idp, int ida) {		
		Produit p =em.find(Produit.class,idp);
		Acheteur c = em.find(Acheteur.class,ida);
		if (p==null || c == null) throw new RuntimeException("P ou C null");
		
		c.getArticles().add(p);
	}
	
	public void associerV(int idp, int idv) {		
		Produit p =em.find(Produit.class,idp);
		Vendeur c = em.find(Vendeur.class,idv);
		if (p==null || c == null) throw new RuntimeException("P ou C null");
		
		c.getProduits().add(p);
	}
}
