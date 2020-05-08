package pack;

import java.io.Serializable;

public class Association implements Serializable {
	int ClientId;
	int CompteId;
	
	public int getClientId() {
		return ClientId;
	}
	public void setClientId(int ClientId) {
		this.ClientId = ClientId;
	}
	public int getCompteId() {
		return CompteId;
	}
	public void setCompteId(int CompteId) {
		this.CompteId = CompteId;
	}
	public Association(Client client, Compte compte) {
		super();
		ClientId = client.getId();
		CompteId = compte.getId();
	}
	
	public Association() {
		super();
	}
	
	
}
