package WebService.RestBean;

public class BeanJson {

    //TODO: Això és un exemple cutrillo..
    private int codi;
    private String nom;

    public BeanJson(){
        codi = 0;
        nom = "";
    }

    public int getCodi(){
        return codi;
    }

    public void setCodi(int codi){
        this.codi = codi;
    }

    public String getNom(){
        return this.nom;
    }

    public void setNom(String nom){
        this.nom = nom;
    }
}
