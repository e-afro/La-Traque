import java.util.Map;

/**
 * Gère les personnages jouables ou non
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

// modif git
public class Character
{
    private Boolean aCalme;
    private Map<String, Object> aInventaire;
    private int aStamina;
    private int aMaxStamina;
    private String aDescription;
    private Boolean aValidite;

     /**
     * Constructeur naturel
     */
    public Character(final String pDescription, final Boolean pCalme, final int pStamina)
    {
       this.aDescription=pDescription;
       this.aCalme=pCalme;
       this.aStamina=pStamina;
       this.aMaxStamina=pStamina;
       this.aValidite=true;
    }
    
    public void setInventaire(final String pName, final Object pObject)
    {
        this.aInventaire.put(pName,pObject);
    }
    
    public void use(final String pName)
    {
        if (pName=="Nourriture"){
            this.useNourriture();
        }
        
        else if (pName=="Cle"){
            this.useCle();
        }
        
        else if (pName=="Caillou"){
            this.useCaillou();
        }
        
        else if (pName=="Os"){
            this.useOs();
        }
        
        else if (pName=="BoiteaMusique"){
            this.useBoiteaMusique();
        }
        
        if(aValidite=true){
            Object vObject = aInventaire.get(pName);
            this.aInventaire.remove(pName,vObject);
        }
    }
    
    public void useNourriture()
    {
        if (aStamina<aMaxStamina){
            this.aStamina+=1;
        }
        else{
            System.out.print("Vous etes deja rassasie");
            aValidite=false;
        }
    }
    
    public void useCle()
    {
        this.aStamina-=1;
        //[...]
    }
    
    public void useCaillou()
    {
        this.aStamina-=1;
        //[...]
    }
    
    public void useOs()
    {
        this.aStamina-=1;
        //[...]
    }
    
    public void useBoiteaMusique()
    {
        this.aStamina-=1;
        //[...]
    }
    
    public Map<String, Object> getInventaire()
    {
        return aInventaire;
    }
}
