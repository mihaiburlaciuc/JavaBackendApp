package location_maps;
import hierarchical_structure.*;
import java.util.HashMap;

public class PlacesMap {
    private static PlacesMap ourInstance = new PlacesMap();

    public static PlacesMap getInstance() {
        return ourInstance;
    }
    private HashMap<String, Place> locations;
    private PlacesMap() {
        locations = new HashMap<>();
    }

    public void insertLocation(String name, Place place) {
        locations.put(name, place);
    }

    public Place getLocation(String name) {
        return locations.get(name);
    }

    public HashMap<String, Place> getLocations() {
        return locations;
    }
}
