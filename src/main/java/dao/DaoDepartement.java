package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entites.Departement;
import utilitaire.SingletonConnexion;

public class DaoDepartement implements IDaoDepartement {
    private Connection con = SingletonConnexion.getConnection();
    
    @Override
    public Departement getDepartementById(int id) {
        Departement d = null;
        try {
            PreparedStatement ps = con.prepareStatement("select * from departement where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                d = new Departement(
                    rs.getInt("id"), 
                    rs.getString("nom"), 
                    rs.getString("description"),
                    rs.getString("image")
                );
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return d;
    }

    @Override
    public Departement addDepartement(Departement d) {
        Departement dt;
        try {
            PreparedStatement ps = con.prepareStatement("insert into departement(nom, description, image) values(?,?,?)");
            ps.setString(1, d.getNom());
            ps.setString(2, d.getInfo());
            ps.setString(3, d.getImage());
            ps.executeUpdate();
            ps.close();
            dt = getDepartementById(d.getId());
            return dt;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Departement updateDepartement(Departement d) {
        Departement dt;
        try {
            PreparedStatement ps = con.prepareStatement("update departement set nom=?, description=?, image=? where id=?");
            ps.setString(1, d.getNom());
            ps.setString(2, d.getInfo());
            ps.setString(3, d.getImage());
            ps.setInt(4, d.getId());
            ps.executeUpdate();
            ps.close();
            dt = getDepartementById(d.getId());
            return dt;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteDepartement(int id) {
        try {
            PreparedStatement ps = con.prepareStatement("delete from departement where id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Departement> getAllDepartement() {
        List<Departement> list = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("select * from departement");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                list.add(new Departement(
                    rs.getInt("id"), 
                    rs.getString("nom"), 
                    rs.getString("description"),
                    rs.getString("image")
                ));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
