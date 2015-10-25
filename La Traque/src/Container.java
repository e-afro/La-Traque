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
    
    public void setObject(final String pName, final Object pObject) {
    	objects.put(pName, pObject);
    }
    
    public Object taken(final String pObject) {
    	Object object = objects.get(pObject);
    	objects.remove(pObject, object);
    	
    	return object;
    }
}