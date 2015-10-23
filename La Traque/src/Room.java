 import java.util.HashMap;
import java.util.Set;
 
/**
 *classe servant à définir les salles via leur description et celle de leur proximité immédiate
 * 
 * @author Pavius Pascal
 * @version 7.9
 */
public class Room
{
    private String aDescription;
    private HashMap<String, Room> exits;
    
    /**
     * constructeur (plus) naturel
     */
    public Room(final String pDescription)
    {
        this.aDescription=pDescription;
        exits=new HashMap<String, Room>();
    }//Room()

    /**
     * donne acces à aDescription
     */
    public String getDescription()
    {
        return this.aDescription;
    } //getDescrition()
    
    /**
     * Retourn une description plus complète de la Room comportant également ses (éventuelles) sorties
     */
    
    public String getLongDescription()
    {
        return "You are"+" "+this.aDescription+".\n"+"Exits:"+this.getExitString();
    }
    
    /**
     * retourne la sortie correspondant à la direction passée en paramère
     */
    public Room getExits(final String pDirection)
    {
        return exits.get(pDirection);
    }//getExits()
    
    /**
     * modifie les sorties en fonction de la Room courante
     */
    public void setExits(final String pDirection,final Room pNeighbor)
    {
       exits.put(pDirection,pNeighbor);
    }// setExits()
    
    /**
     * retourne la liste des sorties d'une Room
     */
    public String getExitString()
    {
      String returnString="";
      Set<String> keys= exits.keySet();
      for (String exit : keys){
          returnString += " " +exit;
        }
      return returnString;  
    }//getExitString()
}


 