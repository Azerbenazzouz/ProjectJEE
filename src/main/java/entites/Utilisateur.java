package entites;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utilisateur {
	private int id;
	private String username;
	private String password;
	private String role;

	public Utilisateur() {
		
	}
	
	public Utilisateur(String username, String password) {
		this.username = username;
		this.password = hashMotDePasse(password);
	}

	public Utilisateur(String username, String password, String role) {
		this.username = username;
		this.password = hashMotDePasse(password);
		this.role = role;
	}
	// Get Dont Need To HashPassword
	public Utilisateur(int id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public Utilisateur(int id, String username, String password, String role) {
		this.id = id;
		this.username = username;
		this.password = hashMotDePasse(password);
		this.role = role;
	}

	public Utilisateur(String username, String role , int id) {
		this.id = id;
		this.username = username;
		this.role = role;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = hashMotDePasse(password);
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String hashMotDePasse(String motDePasse){
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(motDePasse.getBytes());
            byte[] digest = md.digest();

            StringBuilder sb = new StringBuilder();

            for(byte b : digest){
                sb.append(String.format("%02x", b));
            }

            return sb.toString();
        }catch(NoSuchAlgorithmException e){
            System.out.println(e.getMessage());
        }
        return "";
    }
}