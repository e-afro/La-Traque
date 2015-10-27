import java.util.HashMap;
import java.util.Map;


public class Container {
	private Map<String, SomeObject> someObjects;
	
	public Container() {
		someObjects = new HashMap<String, SomeObject>();
	}
	
	public SomeObject getObject(final String pObject) {
    	return someObjects.get(pObject);
    }
	
	public String getObjects() {
		String objects = "";
		for(String obj : this.someObjects.keySet()) {
			objects += obj + " (can be taken)\n";
		}
		
		return objects;
	}
    
    public void setObject(final String pName, final SomeObject pObject) {
    	someObjects.put(pName, pObject);
    }
    
    public SomeObject taken(final String pObject) {
    	SomeObject someObject = someObjects.get(pObject);
    	someObjects.remove(pObject, someObject);
    	
    	return someObject;
    }
    
    public Map<String,SomeObject> canBeTaken() {
    	return someObjects;
    }
}