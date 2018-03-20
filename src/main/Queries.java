package main;
import hierarchical_structure.*;
import location_maps.ActivityMap;
import location_maps.CityMap;
import location_maps.DistrictsMap;
import location_maps.PlacesMap;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Queries {
    private final static int TOP_FIVE = 5;

    public static String getInfoForName(String name) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Place tempPlace = PlacesMap.getInstance().getLocation(name);
        String info = "";
        info += "Location name: " + tempPlace.getName() + "\n";
        info += "City: " + tempPlace.getCity() +"\n";
        info += "District: " + tempPlace.getSuperiorElement().getSuperiorElement().getName() + "\n";
        info += "Country: " + tempPlace.getSuperiorElement().getSuperiorElement().getSuperiorElement().getName() + "\n";
        info += "Average price per day: " + tempPlace.getAvgPricePerDay() + "\n";
        info += "Start period: " + dateFormat.format(tempPlace.getStartDate())
                + " until " + dateFormat.format(tempPlace.getEndDate()) + "\n";
        ArrayList<String> tempActivities = (ArrayList<String>) tempPlace.getActivities();
        info += "Activities:";
        for (String activity:tempActivities) {
            info += " " + activity;
        }
        info += "\n";

        return info;
    }

    public static String getTopFiveLocations(LocationType type, String name, Date start, Date end) {
        ArrayList<Place> places = new ArrayList<>();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String info = "Top 5 cheapest locations between " + dateFormat.format(start)
                + " and " + dateFormat.format(end) + " in " + name + ":\n";
        switch (type) {
            case COUNTRY:
                places = Utility.getPlacesFromCountryByDate(name, start, end);
                break;
            case DISTRICT:
                District district = DistrictsMap.getInstance().getDistrict(name);
                places = Utility.getPlacesFromDistrictByDate(district, start, end);
                break;
            case CITY:
                City city = CityMap.getInstance().getCity(name);
                places = Utility.getPlacesFromCityByDate(city, start, end);
                break;
            default:
                break;

        }

        Collections.sort(places, new PlacePriceComparator());
        for (int i = 0; i < TOP_FIVE; i++) {
            if (i >= places.size()) {
                break;
            }
            info += (i+1) + ".\n";
            info += getInfoForName(places.get(i).getName());
        }
        return info;
    }

    public static String getCheapestPlaceForActivityFor10Days(String activity) {
        ArrayList<Place> places = ActivityMap.getInstance().getPlaces(activity);

        for (int i = places.size() - 1; i >= 0; i--) {
            long dateDifference = Math.abs(places.get(i).getEndDate().getTime()
                                            - places.get(i).getStartDate().getTime());
            if (TimeUnit.DAYS.convert(dateDifference, TimeUnit.MILLISECONDS) + 1 <= 10) {
                places.remove(i);
            }
        }

        Double minValue = Double.MAX_VALUE;
        Place resultPlace = null;
        for (Place place:places) {
            if (place.getAvgPricePerDay() < minValue) {
                minValue = place.getAvgPricePerDay();
                resultPlace = place;
            }
        }

        String info = getInfoForName(resultPlace.getName());

        return info;
    }
}
