package pack;
import java.util.Collection;

import javax.persistence.*;

@Entity
public class Acheteur implements Client {

	Integer note;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@ManyToMany(fetch=FetchType.EAGER) //chargement du panier
	Collection<Produit>  listes_articles ;

	public Integer getNote() {
		return note;
	}

	public void setNote(Integer note) {
		this.note = note;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Collection<Produit> getArticles() {
		return listes_articles;
	}

	public void setArticles(Collection<Produit> listes_articles) {
		this.listes_articles = listes_articles;
	}
	
	
	
}
