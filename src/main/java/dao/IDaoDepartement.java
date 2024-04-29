package dao;

import java.util.List;

import entites.Departement;

public interface IDaoDepartement {
    public Departement getDepartementById(int id);
    public Departement addDepartement(Departement d);
    public Departement updateDepartement(Departement d);
    public boolean deleteDepartement(int d);
    public List<Departement> getAllDepartement();
}
