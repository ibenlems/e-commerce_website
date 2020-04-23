package pack;
import java.util.*;

import javax.ejb.Singleton;
import javax.persistence.*;



@Singleton
public class Facade {
	
	@PersistenceContext
	private EntityManager em;
		
	public void ajoutClient(Client client ) {
		em.persist(client);
	}
	
	public void ajoutProduit(Produit p ) {
		em.persist(p);
	}
	
	public void rajouter(Produit p, Client c) {
		c.getArticles().add(p);
	}
	
	public void retirer(Produit p, Client c) {
		c.getArticles().remove(p);
	}
	
	
	public Collection<Client> listeClients(){
		TypedQuery<Client> req = em.createQuery("select c from Client c",Client.class);
		Collection<Client> clients = req.getResultList();
		return clients;
	}
	public Collection<Produit> listeProduits(){
		TypedQuery<Produit> req = em.createQuery("select p from Produit p",Produit.class);
		Collection<Produit> produits = req.getResultList();
		return produits;
	}
	
	
	public void associerC(int idp, int idc) {		
		Produit p =em.find(Produit.class,idp);
		Client c = em.find(Client.class,idc);
		if (p==null || c == null) throw new RuntimeException("P ou C null");
		
		c.getArticles().add(p);
	}
}
