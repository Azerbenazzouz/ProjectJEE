package dao;

import java.sql.Connection;

import utilitaire.SingletonConnexion;

public class DaoDepartement implements IDaoDepartement{
    private Connection con = SingletonConnexion.getConnection();
}
