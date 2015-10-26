import java.util.HashMap;
import java.util.Map;


public class Container {
	private Map<String, Object> objects;
	
	public Container() {
		objects = new HashMap<String, Object>();
	}
	
	public Object getObject(final String pObject) {
    	return objects.get(pObject);
    }
	
	public String getObjects() {
		String objects = "";
		for(String obj : this.objects.keySet()) {
			objects += obj + " (can be taken)\n";
		}
		
		return objects;
	}
    
    public void setObject(final String pName, final Object pObject) {
    	objects.put(pName, pObject);
    }
    
    public Object taken(final String pObject) {
    	Object object = objects.get(pObject);
    	objects.remove(pObject, object);
    	
    	return object;
    }
}