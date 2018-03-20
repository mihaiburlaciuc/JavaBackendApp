package main;

import hierarchical_structure.LocationType;
import hierarchical_structure.World;
import location_maps.ActivityMap;
import location_maps.CityMap;
import location_maps.DistrictsMap;
import location_maps.PlacesMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommandIO {
    public static void startSession() throws IOException {
        String help = "Choose one of the following commands\n"
                    + "1 - get info about a place\n"
                    + "2 - get top 5 cheapest places between two dates\n"
                    + "3 - get the cheapest place to practice an activity for 10 days\n"
                    + "0 - exit\n";

        System.out.println(help);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.print("Command number: ");
            Integer commandNumber = 0;
            try {
                commandNumber = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input\n");
                System.out.println(help);
                continue;
            }

                Boolean terminateProgram = false;
            switch (commandNumber) {
                case 0:
                    terminateProgram = true;
                    break;
                case 1:
                    System.out.println("Insert name of the place: ");
                    System.out.print("input: ");
                    String placeName = reader.readLine();

                    if (PlacesMap.getInstance().getLocation(placeName) == null) {
                        System.out.println("Place not found");
                        break;
                    }

                    System.out.println("Information about " + placeName + ":\n");
                    System.out.println(Queries.getInfoForName(placeName));
                    break;
                case 2:
                    System.out.println("Insert the type of the location:\n1 - City \n2 - District\n3 - Country");
                    System.out.print("input: ");
                    Integer typeNumber;

                    try {
                        typeNumber = Integer.parseInt(reader.readLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input\n");
                        break;
                    }
                    LocationType type;
                    switch (typeNumber) {
                        case 1:
                            type = LocationType.CITY;
                            break;
                        case 2:
                            type = LocationType.DISTRICT;
                            break;
                        case 3:
                            type = LocationType.COUNTRY;
                            break;
                        default:
                            type = null;
                    }

                    System.out.println("Insert the name of the location: ");
                    System.out.print("input: ");
                    String locationName = reader.readLine();

                    if (type == LocationType.CITY && CityMap.getInstance().getCity(locationName) == null) {
                        System.out.println("City not found");
                        break;
                    }

                    if (type == LocationType.DISTRICT && DistrictsMap.getInstance().getDistrict(locationName) == null) {
                        System.out.println("District not found");
                        break;
                    }

                    if (type == LocationType.COUNTRY && World.getInstance().getSubElements().get(locationName) == null) {
                        System.out.println("Country not found");
                        break;
                    }

                    System.out.println("Insert the first day using the format dd/mm/yyyy:");
                    System.out.print("input: ");
                    Date start = null, end = null;
                    try {
                        start = new SimpleDateFormat("dd/MM/yyyy").parse(reader.readLine());
                    } catch (ParseException e) {
                        System.out.println("Invalid date format");
                    }
                    System.out.print("input: ");
                    System.out.println("Insert the last day using the format dd/mm/yyyy:");
                    try {
                        end = new SimpleDateFormat("dd/MM/yyyy").parse(reader.readLine());
                    } catch (ParseException e) {
                        System.out.println("Invalid date format");
                    }

                    System.out.println(Queries.getTopFiveLocations(type, locationName, start, end));

                    break;
                case 3:
                    System.out.println("Insert the name of the activity:");
                    System.out.print("input: ");
                    String activity = reader.readLine();

                    if (ActivityMap.getInstance().getPlaces(activity) == null) {
                        System.out.println("Activity not found");
                        break;
                    }

                    System.out.println(Queries.getCheapestPlaceForActivityFor10Days(activity));

                    break;
                default:
                    System.out.println("Invalid input\n");
                    System.out.println(help);
                    break;
            }

            if (terminateProgram) {
                break;
            }
        }
    }
}
