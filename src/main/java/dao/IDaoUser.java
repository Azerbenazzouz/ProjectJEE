package dao;

import entites.Utilisateur;

public interface IDaoUser {
	public Utilisateur getUtilisateur(Utilisateur u); 
	public Utilisateur setUtilisateur(Utilisateur u);
	public boolean deleteUtilisateur(int id);
	public boolean updateUtilisateur(Utilisateur u);
	public boolean updatePassword(int id, String password, String newPassword);	
}
