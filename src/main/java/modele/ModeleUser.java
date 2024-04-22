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
		System.out.println(ut);
		if(ut==null) return false;
		if(u.getUsername().equals(ut.getUsername()) && u.getPassword().equals(ut.getPassword())) return true;
		return false;
	}
	
}
