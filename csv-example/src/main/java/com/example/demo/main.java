package com.example.demo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Random;
import java.io.Writer;
import java.util.Arrays;
import java.nio.file.Paths;
import java.nio.file.Files;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

/*
 *
 * @author jesselatorre
 * email: tuk72227@temple.edu
 * email: jlatorr3@student.ccp.edu
 * Last actualization: Jan. 06 - 2020
 * 
 */

public class main {
	
	//begining of the Main method
	public static void main(String[] arg) {
		try {
			// declare and initialize variables
	        Random r= new Random();//declare a variable to create a random number
	        int cz;
	        int lim = 4;
	        int z = 10;
	        int y = z;
	        int ca;
	        int a = 0;
	        //declare arrays for saving timing processes per technique
	        double[] bubtime = new double[lim];//array for bubble sort time
	        double[] seltime = new double[lim];//array for selection sort time
	        double[] quitime = new double[lim];//array for quick search time
	        double[] mertime = new double[lim];//array for merge sort time
	        double[] instime = new double[lim];//array for insertion sort time
	        
	        Writer writer = Files.newBufferedWriter(Paths.get("student.csv"));
	        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("Student Name", "Fees"));
	        csvPrinter.printRecord("Akshay Sharma", 1000);
	        csvPrinter.printRecord("Rahul Gupsa", 2000);
	        
	        
	        csvPrinter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
	}
}
