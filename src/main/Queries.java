package main;

import hierarchical_structure.*;
import location_maps.ActivityMap;
import location_maps.CityMap;
import location_maps.DistrictsMap;
import location_maps.PlacesMap;

import java.util.ArrayList;
import java.util.Date;

public class Queries {
    public String getInfoForName(String name) {
        Place tempPlace = PlacesMap.getInstance().getLocation(name);
        String info = "Location name: " + tempPlace.getName() + "\n";
        info += "hierarchical_structure.City: " + tempPlace.getCity() +"\n";
        info += "Average price per day: " + tempPlace.getAvgPricePerDay() + "\n";
        info += "Start period: " + tempPlace.getStartDate() + " until " + tempPlace.getEndDate() + "\n";
        ArrayList<String> tempActivities = (ArrayList<String>) tempPlace.getActivities();
        info += "Activities:";
        for (String activity:tempActivities) {
            info += " " + activity;
        }
        info += "\n";

        return info;
    }

    public String getTopFiveLocations(LocationType type, String name, Date start, Date end) {
        ArrayList<Place> places;
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


        return null;
    }

    public String getCheapestPlaceForActivity(String activity) {
        ArrayList<Place> places = ActivityMap.getInstance().getPlaces(activity);

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
