
/**
 * Write a description of class Door here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Door
{
    private Boolean aClosed;
    private Boolean aLocked;

    /**
     * Constructor for objects of class Door
     */
    public Door(final Boolean pClosed, final Boolean pLocked)
    {
       this.aClosed=pClosed;
       this.aLocked=pLocked;
    }
    
     public Boolean getEtat(final String pEtat)
    {
        if (pEtat=="aClosed"){
            return aClosed;
        }
        
        else if (pEtat=="aLocked"){
            return aLocked;
        }
        
        return null;
    }
}
