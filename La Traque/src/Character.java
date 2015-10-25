import java.util.Map;

/**
 * Gère les personnages jouables ou non
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Character
{
    private Boolean aCalme;
    private Map<String, Object> aInventaire;
    private int aStamina;
    private String aDescription;

     /**
     * Constructeur naturel
     */
    public Character(final String pDescription, final Boolean pCalme, final int pStamina)
    {
       this.aDescription=pDescription;
       this.aCalme=pCalme;
       this.aStamina=pStamina;
    }
    
    public void setInventaire(final String pName, final Object pObject)
    {
        this.aInventaire.put(pName,pObject);
    }
    
    public void use(final String pName)
    {
        Object vObject = aInventaire.get(pName);
        this.aInventaire.remove(pName,vObject);
    }
    
    public Map getInventaire()
    {
        return aInventaire;
    }
}
