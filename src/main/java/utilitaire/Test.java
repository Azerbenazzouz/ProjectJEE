package utilitaire;

import java.sql.Connection;

public class Test {
    public static void main(String[] args) {
        Connection con = SingletonConnexion.getConnection();
        if (con != null) {
            System.out.println("Connexion réussie");
        } else {
            System.out.println("Connexion échouée");
        }
    }
}
