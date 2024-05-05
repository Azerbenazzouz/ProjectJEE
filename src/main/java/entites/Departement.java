package entites;

public class Departement {
    private int id;
    private String nom;
    private String info;
    private String image;
    private int chef = 0;

    public Departement() {
    }

    public Departement(String nom, String info, String image) {
        this.nom = nom;
        this.info = info;
        this.image = image;
    }
    
    public Departement(String nom, String info, String image, int chef) {
        this.nom = nom;
        this.info = info;
        this.image = image;
        this.chef = chef;
    }
    
    public Departement(int id, String nom, String info, String image) {
        this.id = id;
        this.nom = nom;
        this.info = info;
        this.image = image;
    }

    public Departement(int id, String nom, String info, String image, int chef) {
        this.id = id;
        this.nom = nom;
        this.info = info;
        this.image = image;
        this.chef = chef;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    public int getChef() {
        return chef;
    }

    public void setChef(int chef) {
        this.chef = chef;
    }
}
