package location_maps;
import hierarchical_structure.*;
import java.util.ArrayList;
import java.util.HashMap;

public class ActivityMap {
    private static ActivityMap ourInstance = new ActivityMap();

    public static ActivityMap getInstance() {
        return ourInstance;
    }

    private HashMap<String, ArrayList<Place> > activityMap;

    private ActivityMap() {
        activityMap = new HashMap<>();
    }

    public void insertPlaceToActivity(String activity, Place place) {
        ArrayList<Place> tempPlaces = activityMap.get(activity);

        if (tempPlaces == null) {
            tempPlaces = new ArrayList<>();
            tempPlaces.add(place);
        } else {
            tempPlaces.add(place);
        }

        activityMap.put(activity, tempPlaces);
    }

    public ArrayList<Place> getPlaces(String activity) {
        return activityMap.get(activity);
    }
}
