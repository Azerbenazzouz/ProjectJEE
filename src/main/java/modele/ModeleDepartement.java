package modele;

import java.util.List;

import dao.DaoDepartement;
import entites.Departement;

public class ModeleDepartement {
    private Departement d;

    public Departement getD() {
        return d;
    }

    public void setD(Departement departement) {
        this.d = departement;
    }

    public boolean addDepartement() {
        DaoDepartement daoDepartement = new DaoDepartement();
        Departement departement = daoDepartement.addDepartement(d);
        if (departement == null) return false;
        return true;
    }

    public boolean updateDepartement() {
        DaoDepartement daoDepartement = new DaoDepartement();
        Departement departement = daoDepartement.updateDepartement(d);
        if (departement == null) return false;
        return true;
    }

    public boolean deleteDepartement(int d) {
        DaoDepartement daoDepartement = new DaoDepartement();
        boolean isDeleted = daoDepartement.deleteDepartement(d);
        if (!isDeleted) return false;
        return true;
    }

    public Departement getDepartementById(int id) {
        DaoDepartement daoDepartement = new DaoDepartement();
        Departement departement = daoDepartement.getDepartementById(id);
        if (departement == null) return null;
        return departement;
    }

    public List<Departement> getAllDepartement() {
        DaoDepartement daoDepartement = new DaoDepartement();
        List<Departement> departements = daoDepartement.getAllDepartement();
        if (departements == null) return null;
        return departements;
    }
    
}
