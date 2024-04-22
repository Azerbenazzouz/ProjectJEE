package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entites.Utilisateur;
import utilitaire.SingletonConnexion;

public class DaoUser implements IDaoUser{
	private Connection con = SingletonConnexion.getConnection();
	@Override
	public Utilisateur getUtilisateur(Utilisateur u) {
		Utilisateur ut = null;
		try {
			PreparedStatement ps = con.prepareStatement("select * from utilisateur where username=? and password=?");
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ut = new Utilisateur();
				ut.setId(rs.getInt(1));
				ut.setUsername(rs.getString(2));
				ut.setPassword(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ut;
	}
	
}
