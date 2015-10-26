 import java.util.HashMap;
 import java.util.Set;
 import java.util.Iterator;
 import java.util.Map;
 
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
    private Map<String, Container> containers;
    private Map<String, Object> objects;
    private Map<String, Door> aDoors;
    
    /**
     * constructeur (plus) naturel
     */
    public Room(final String pDescription)
    {
        this.aDescription=pDescription;
        exits=new HashMap<String, Room>();
        containers = new HashMap<String, Container>();
        objects = new HashMap<String, Object>();
        aDoors= new HashMap<String, Door>();
    }//Room()

    /**
     * donne acces à aDescription
     */
    public String getDescription()
    {
        return this.aDescription;
    } //getDescrition()
    
    private String getObjects() 
    {
        String objects = "";
    	for(String obj : this.objects.keySet()) {
   		objects += obj + "(can be taken)\n";
    	}
    	
     return objects;
     }

	private String getContainers() 
	{
	    String containers = "";
		return null;
    }
    
    /**
     * Retourn une description plus complète de la Room comportant également ses (éventuelles) sorties
     */
    
    public String getLongDescription()
    {
        return "You are"+" "+this.aDescription+".\n"+"Exits:"+this.getExitString()+"\n"+getContainers()+getObjects()+"\n";
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
       exits.put(pDirection.toLowerCase(),pNeighbor);
    }// setExits()
    
    public void setDoors(final String pDirection,final Door pDoor)
    {
        aDoors.put(pDirection.toLowerCase(),pDoor);
    }
    
     public Door getDoor(final String pDirection)
    {
        return aDoors.get(pDirection);
    }
    
    public Container getContainer(final String pContainer) {
    	return containers.get(pContainer);
    }
    
    public void setContainer(final String pName, final Container pContainer) {
    	containers.put(pName.toLowerCase(), pContainer);
    }
    
    public Object getObject(final String pObject) {
    	return objects.get(pObject);
    }
    
    public void setObject(final String pName, final Object pObject) {
    	objects.put(pName, pObject);
    }
    
    public Object taken(final String pObject) {
    	Object object = objects.get(pObject);
    	objects.remove(pObject, object);
    	
    	return object;
    }
    
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


 