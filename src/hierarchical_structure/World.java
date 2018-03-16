package hierarchical_structure;

import java.util.HashMap;

public class World {
    private static World ourInstance = new World();
    private HashMap<String, LocationElement> subElements;

    public static World getInstance() {
        return ourInstance;
    }

    private World() {
        subElements = new HashMap<>();
    }

    public LocationElement getElement(String name) {
        return subElements.get(name);
    }

    public void addLocationElement(LocationElement locationElement) {
        subElements.put(locationElement.getName(), locationElement);
    }
}
