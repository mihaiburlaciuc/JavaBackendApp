## Project
A Java application which helps people to choose their holiday destination

## Project structure
The application processes the given data using a hierarchical structure, implemented using the Composite Design Pattern.
World -> Countries -> Districts -> Cities -> Places to visit

Also, there are 3 maps for accessing the name of the location in O(1) time:
 - a map for Districts
 - a map for Cities
 - a map for Places

A Place contains:
 - the name
 - the city where it is located
 - the average price per day
 - activities that can be done
 - a date interval

## Queries
    1. Get all the information about a given place.
    2. Get the top 5 places inside a given location(Country, District, City) which can be visited in a given date interval, based on the total cost of the trip.
    3. Get the cheapest place to practice a given activity for 10 days.

## Database
    The dbGenerator/gen.java outputs a text file containing the places. Every place has the fallowing entry:
    [Country_name] [District_name] [City_name] [Place_name] [average_price_per_day] [start_date] [end_date] [list_of_activities]

## Tests
    For the database in the in.txt file, the results based on a manual input are found in the text.txt file.
