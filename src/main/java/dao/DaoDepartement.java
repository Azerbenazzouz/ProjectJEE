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
                    rs.getString("info"),
                    rs.getString("image"),
                    Integer.parseInt(rs.getString("chef"))
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
    public boolean addDepartement(Departement d) {
        try {
            PreparedStatement ps = con.prepareStatement("insert into departement(nom, info, image, chef) values(?,?,?,?)");
            ps.setString(1, d.getNom());
            ps.setString(2, d.getInfo());
            ps.setString(3, d.getImage());
            ps.setInt(4, d.getChef());
            ps.execute();
            ps.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateDepartement(Departement d) {
        Departement dt;
        try {
            PreparedStatement ps = con.prepareStatement("update departement set nom=?, info=?, image=? where id=?");
            ps.setString(1, d.getNom());
            ps.setString(2, d.getInfo());
            ps.setString(3, d.getImage());
            ps.setInt(4, d.getId());
            ps.executeUpdate();
            ps.close();
            dt = getDepartementById(d.getId());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
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
                    rs.getString("info"),
                    rs.getString("image"),
                    Integer.parseInt(rs.getString("chef"))
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
