package location_maps;

import hierarchical_structure.City;
import hierarchical_structure.District;

import java.util.HashMap;

public class CityMap {
    private static CityMap ourInstance = new CityMap();

    public static CityMap getInstance() {
        return ourInstance;
    }

    private CityMap() {
        locations = new HashMap<>();
    }

    private HashMap<String, City> locations;

    public void insertCity(String name, City city) {
        locations.put(name, city);
    }

    public City getCity(String name) {
        return locations.get(name);
    }

    public HashMap<String, City> getLocations() {
        return locations;
    }
}
