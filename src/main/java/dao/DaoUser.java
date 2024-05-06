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
				ut = new Utilisateur(rs.getInt("id"), 
					rs.getString("username"), 
					rs.getString("password"));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ut;
	}

	@Override
	public Utilisateur setUtilisateur(Utilisateur u){
		Utilisateur ut;
		try {
			PreparedStatement ps = con.prepareStatement("insert into utilisateur(username, password, role) values(?,?,?)");
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getRole());
			ps.executeUpdate();
			ps.close();
			ut = getUtilisateur(u);
			return ut;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public boolean deleteUtilisateur(int id) {
		try {
			PreparedStatement ps = con.prepareStatement("delete from utilisateur where id=?");
			ps.setInt(1, id);
			ps.execute();
			ps.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	// Update user Name and Role
	@Override
	public boolean updateUtilisateur(Utilisateur u) {
		Utilisateur ut;
		try {
			PreparedStatement ps = con.prepareStatement("update utilisateur set username=?, role=? where id=?");
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getRole());
			ps.setInt(3, u.getId());
			ps.executeUpdate();
			ps.close();
			ut = getUtilisateur(u);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updatePassword(int id, String password, String newPassword) {
		try {
			PreparedStatement ps = con.prepareStatement("select password from utilisateur where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				if(rs.getString("password").equals(password)) {
					try {
						ps = con.prepareStatement("update utilisateur set password=? where id=?");
						ps.setString(1, newPassword);
						ps.setInt(2, id);
						ps.executeUpdate();
						ps.close();
						return true;
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
