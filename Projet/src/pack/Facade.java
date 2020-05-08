package pack;

import java.util.Collection;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Singleton
@Path("/")
public class Facade {

	@PersistenceContext
	EntityManager em;
	
	@POST
	@Path("/addClient")
    @Consumes({ "application/json" })
	public void addClient(Client p) {
		System.out.println("coucou");
		em.persist(p);
	}
	
	@POST
	@Path("/addCompte")
    @Consumes({ "application/json" })
	public void addCompte(Compte a) {
		em.persist(a);
	}
	
	
	
	@GET
	@Path("/listClients")
    @Produces({ "application/json" })
	public Collection<Client> listClients() {
		return em.createQuery("from Client", Client.class).getResultList();
	}
	
	@GET
	@Path("/listComptes")
    @Produces({ "application/json" })
	public Collection<Compte> listComptes() {
		return em.createQuery("from Compte", Compte.class).getResultList();	
	}
	
	@POST
	@Path("/associate")
    @Consumes({ "application/json" })
	public void associate(Association as) {
		Client client = em.find(Client.class, as.getClientId());
		Compte compte = em.find(Compte.class, as.getCompteId());		
		compte.setOwner(client);
	}
	
	@GET
	@Path("/listProduits")
    @Produces({ "application/json" })
	public Collection<Produit> listProduits() {
		return em.createQuery("from Produit", Produit.class).getResultList();	
	}
	
}
