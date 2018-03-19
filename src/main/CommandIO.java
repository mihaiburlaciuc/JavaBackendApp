package main;

import hierarchical_structure.LocationType;

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
                    + "3 - get the cheapest place to practice an activity\n"
                    + "0 - exit\n";
        System.out.println(help);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
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
                    System.out.println("Insert name of the place\n");
                    String placeName = reader.readLine();
                    System.out.println(Queries.getInfoForName(placeName));
                    break;
                case 2:
                    System.out.println("Insert the type of the location:\n1 - City \n2- District\n3 - Country\n");
                    Integer typeNumber = Integer.parseInt(reader.readLine());
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

                    System.out.println("Insert the name of the location:\n");
                    String locationName = reader.readLine();

                    System.out.println("Insert the first day using the format dd/mm/yyyy:\n");
                    Date start = null, end = null;
                    try {
                        start = new SimpleDateFormat("dd/MM/yyyy").parse(reader.readLine());
                    } catch (ParseException e) {
                        System.out.println("Invalid date format");
                    }
                    System.out.println("Insert the last day using the format dd/mm/yyyy:\n");
                    try {
                        end = new SimpleDateFormat("dd/MM/yyyy").parse(reader.readLine());
                    } catch (ParseException e) {
                        System.out.println("Invalid date format");
                    }

                    System.out.println(Queries.getTopFiveLocations(type, locationName, start, end));

                    break;
                case 3:
                    System.out.println("Insert the name of the activity:\n");
                    String activity = reader.readLine();
                    System.out.println(Queries.getCheapestPlaceForActivity(activity));

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
