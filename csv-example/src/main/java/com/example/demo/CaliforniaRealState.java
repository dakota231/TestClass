package com.example.demo;

/**
*
* @author jesselatorre
* email: tuk72227@temple.edu
* email: jlatorr3@student.ccp.edu
* Last actualization: Feb. 06 - 2020
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CaliforniaRealState {
	
    public static void main(String[] args) throws IOException {
        BufferedReader reader = Files.newBufferedReader(Paths.get("real-estate-data.csv"));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader("Street", "City", "Zip", "State", "Beds", "Baths", "sqf", "Type", "Sale_Date", "Price", "Latitude", "Longitude").withIgnoreHeaderCase().withTrim());
        for (CSVRecord csvRecord: csvParser) {
            // Accessing Values by Column Index
            String street = csvRecord.get(0);
            String city = csvRecord.get(1);
            String zip = csvRecord.get(2);
            String state = csvRecord.get(3);
            String beds = csvRecord.get(4);
            String baths = csvRecord.get(5);
            String sqf = csvRecord.get(6);
            String type = csvRecord.get(7);
            String sale_date = csvRecord.get(8);
            String price = csvRecord.get(9);
            String latitude = csvRecord.get(10);
            String longitude = csvRecord.get("Longitude");
            //Accessing the values by column header name
            //String city = csvRecord.get("city");
            //Printing the record 
            System.out.println("Record Number - " + csvRecord.getRecordNumber());
            System.out.println("Street : " + street);
            System.out.println("City : " + city);
            System.out.println("Zip : " + zip);
            System.out.println("State : " + state);
            System.out.println("Beds : " + beds);
            System.out.println("Baths : " + baths);
            System.out.println("SQF : " + sqf);
            System.out.println("Type : " + type);
            System.out.println("Sale Date : " + sale_date);
            System.out.println("Price : " + price);
            System.out.println("Latitude : " + latitude);
            System.out.println("Longitude : " + longitude);
            System.out.println("\n\n");
        }
        }

}
