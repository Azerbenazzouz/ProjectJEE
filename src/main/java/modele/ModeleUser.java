package modele;

import dao.DaoUser;
import entites.Utilisateur;

public class ModeleUser {
	private Utilisateur u;
	
	
	public Utilisateur getU() {
		return u;
	}

	public void setU(Utilisateur u) {
		this.u = u;
	}

	public boolean login() {
		DaoUser d=new DaoUser();
		Utilisateur ut = d.getUtilisateur(u);
		if(ut==null) return false;
		if(u.getUsername().equals(ut.getUsername()) && u.getPassword().equals(ut.getPassword())) return true;
		return false;
	}
	
	public boolean register() {
		DaoUser d = new DaoUser();
		Utilisateur ut = d.setUtilisateur(u);
		if(ut==null) return false;
		return this.login();
	}
	
}
