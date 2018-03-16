package location_maps;

import hierarchical_structure.District;
import hierarchical_structure.Place;

import java.util.HashMap;

public class DistrictsMap {
    private static DistrictsMap ourInstance = new DistrictsMap();

    public static DistrictsMap getInstance() {
        return ourInstance;
    }

    private DistrictsMap() {
        locations = new HashMap<>();
    }

    private HashMap<String, District> locations;

    public void insertDistrict(String name, District district) {
        locations.put(name, district);
    }

    public District getDistrict(String name) {
        return locations.get(name);
    }

    public HashMap<String, District> getLocations() {
        return locations;
    }
}
