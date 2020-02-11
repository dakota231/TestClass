/*
 * This program run 5 different techniques or sorting data and measure
 * teh time it takes to do the job for each technique using different size of
 * randomly generated arrays of numbers (integers) with values between 0 and 100
 * Every technique runs the same unsorted array to preserve the integrity of the
 * collected data.
 */
package testingrandomsort;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 *
 * @author jesselatorre
 * email: tuk72227@temple.edu
 * email: jlatorr3@student.ccp.edu
 * Last actualization: Jan. 06 - 2020
 */
public class TestingRandomSort {

    /**
     * @param args the command line arguments
     */
    
    //begining of the Main method
    public static void main(String[] args) throws IOException {
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
        
        //Create the file object
        File file = new File("testFile1.csv");
        
        //Create the file
        if (file.createNewFile()){
            System.out.println("File is created!");
        }
        else{
            System.out.println("File already exists.");
        }
        
        //build a random array of integers many times
        for (cz=0; cz<lim; cz++){//count how many arrays to build and the size
            z=z*10;//the base times 10 elements in the array to build
            //start building an array of size z
            int[] integers = new int[z];//declare the array and size for working
            int[] original = new int[z];//declare an array's copy for reference 
            for (ca = 0; ca < z; ca++){//loop to build a random array of numbers
                integers[ca] = r.nextInt(100);//limits the array from 0 to 100 
                
                //System.out.print(integers[ca]);
                //System.out.print(", ");
            }//end of the building array process
            //System.out.println("end array generated");
            
            //preserve a copy of the array with no alterations
            for (ca = 0; ca < z; ca++){//loop to build a random array of numbers
                original[ca] = integers[ca];//limits the array from 0 to 100 
                
                //System.out.print(original[ca]);
                //System.out.print(", ");
            }//end of the building array process
            
            //System.out.println("end copy as original");
            
            
            // get the start time in nanoseconds fro bubble sort
            long startTime = System.nanoTime();
            bubbleSort(integers);//calls the sort method passin the array
            // get the end time in nanoseconds
            long endTime = System.nanoTime();
            // calculate elapsed time in nanoseconds
            long duration = endTime - startTime;
            //the system time is in nanoseconds
            //save the elapsed time in seconds (nanaoseconds/ 1 billion)
            bubtime[cz] = duration / 1.0e+6;//save the value for array bubtime in milliseconds
            
            //System.out.print(integers[ca]);
            //System.out.print(", ");            
            
            //restore the array to its original
            for (ca = 0; ca < z; ca++){//loop to build a random array of numbers
                //System.out.print(integers[ca]);
                //System.out.print(", ");
                integers[ca] = original[ca];//copy original array to integers 
            }
            
            //System.out.println("end bubble");
            
            
            // get the start time in nanoseconds for insertion sort
            startTime = System.nanoTime();
            insSort(integers);//calls the sort method passin the array
            // get the end time in nanoseconds
            endTime = System.nanoTime();
            // calculate elapsed time in nanoseconds
            duration = endTime - startTime;
            //the system time is in nanoseconds
            //save the elapsed time in seconds (nanaoseconds/ 1 billion)
            instime[cz] = duration / 1.0e+6;//save the value for array instime in milliseconds
            
            //restore the array to its original
            for (ca = 0; ca < z; ca++){//loop to build a random array of numbers
                //System.out.print(integers[ca]);
                //System.out.print(", ");
                integers[ca] = original[ca];//copy original array to integers 
            } 
            //System.out.println("end insert");
            
            // get the start time in nanoseconds for selection sort
            startTime = System.nanoTime();
            selSort(integers);//calls the sort method passin the array
            // get the end time in nanoseconds
            endTime = System.nanoTime();
            // calculate elapsed time in nanoseconds
            duration = endTime - startTime;
            //the system time is in nanoseconds
            //save the elapsed time in seconds (nanaoseconds/ 1 billion)
            seltime[cz] = duration / 1.0e+6;//save the value for array seltime in milliseconds
            
            //restore the array to its original
            for (ca = 0; ca < z; ca++){//loop to build a random array of numbers
                //System.out.print(integers[ca]);
                //System.out.print(", ");
                integers[ca] = original[ca];//copy original array to integers 
            } 
            
            //System.out.println("end selection");
            
            int qhigh = integers.length-1;
            int qlow = 0;
            // get the start time in nanoseconds for quick sort
            startTime = System.nanoTime();
            quickSort(integers,qlow, qhigh);//calls the sort method passin the array
            // get the end time in nanoseconds
            endTime = System.nanoTime();
            // calculate elapsed time in nanoseconds
            duration = endTime - startTime;
            //the system time is in nanoseconds
            //save the elapsed time in seconds (nanaoseconds/ 1 billion)
            quitime[cz] = duration / 1.0e+6;//save the value for array quitime in milliseconds
            
            //restore the array to its original
            for (ca = 0; ca < z; ca++){//loop to build a random array of numbers
                //System.out.print(integers[ca]);
                //System.out.print(", ");  
                integers[ca] = original[ca];//copy original array to integers 
            }
            
            //System.out.println("end quick");
            
            
            
            int high = integers.length-1;
            int low = 0;
            // get the start time in nanoseconds
            startTime = System.nanoTime();
            sort(integers, 0, integers.length-1);//calls the sort method passin the array
            // get the end time in nanoseconds
            endTime = System.nanoTime();
            // calculate elapsed time in nanoseconds
            duration = endTime - startTime;
            //the system time is in nanoseconds
            //save the elapsed time in seconds (nanaoseconds/ 1 billion)
            mertime[cz] = duration / 1.0e+6;//save the value for array mertime in milliseconds
            
            //restore the array to its original
            for (ca = 0; ca < z; ca++){//loop to build a random array of numbers
                //System.out.print(integers[ca]);
                //System.out.print(", ");
                integers[ca] = original[ca];//copy original array to integers 
            }   
            //System.out.println("end merge");
            
            //printArray(integers);
            
            //display  the results per technique used per cycle done (size of data used)
            System.out.printf("The bubble algorithm takes %14.6f milliseconds for a %d samples%n", bubtime[cz], z);
            System.out.printf("The insertion algorithm takes %14.6f milliseconds for a %d samples\n", instime[cz], z);
            System.out.printf("The selection algorithm takes %14.6f milliseconds for a %d samples\n", seltime[cz], z);
            System.out.printf("The merge algorithm takes %14.6f milliseconds for a %d samples\n", mertime[cz], z);
            System.out.printf("The quick algorithm takes %14.6f milliseconds for a %d samples%n\n", quitime[cz], z);
    
        }
        System.out.println();
        
        /*
        for(int w = 0; w< lim; w++){
            System.out.printf("time(%d) = %14.6f\n", w, quitime[w]);
        }
        System.out.println();
        */
        
        /*
        double average;
        double sumtime = 0.0;
        double counts = time.length;
        for (a=1; a<counts; a++){
            sumtime = sumtime + time[a];
        }
        average = sumtime/counts;
        System.out.print("The average time was = ");
        System.out.print(average);
        System.out.println(" milliseconds.");
        */
        
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(file);
        //save the header for the excel sheet
        pw.println("NOTE: All measured times are in milliseconds with 6 decimal places ..... the sample size is the size of the array sorted");
        pw.println();
        pw.println("Sample Size;Bubble; Insertion; Selection; Merge; Quick");
        //write to the file the values collected
        for (int e = 0; e < lim; e++){
            y = 10*y;
                // Write variable to file
               pw.print(y + ";");
               pw.print(bubtime[e] + ";");
               pw.print(instime[e] + ";");
               pw.print(seltime[e] + ";");
               pw.print(mertime[e] + ";");
               pw.println(quitime[e] + ";");
               
        }
        // Close the file to protect for errors
               pw.close();
        
    }
    
     /* This method sorts an array of integers using a
     * simple bubble sort technique.
     */
    public static void bubbleSort(int integers[])
    {
        int n = integers.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (integers[j] > integers[j+1])
                {
                    // swap temp and arr[i]
                    int temp = integers[j];
                    integers[j] = integers[j+1];
                    integers[j+1] = temp;
                }
    }
    
        /* Insertion Sort function */

    public static void insSort( int[] integers )
    {
        int N = integers.length;
        int i, j, temp;
        for (i = 1; i< N; i++) 
        {
            j = i;
            temp = integers[i];    
            while (j > 0 && temp < integers[j-1])
            {
                integers[j] = integers[j-1];
                j = j-1;
            }
            integers[j] = temp;            
        }        
    }    
    

    /* Selection Sort function */

    public static void selSort( int[] integers ){
        int N = integers.length;
        int i, j, pos, temp;
        for (i = 0; i < N-1; i++)
        {
            pos = i;
            for (j = i+1; j < N; j++)
            {
                if (integers[j] < integers[pos])
                {
                    pos = j;
                }
            }

            /* Swap integers[i] and integers[pos] */

            temp = integers[i];
            integers[i] = integers[pos];
            integers[pos]= temp;            
        }
    }
        
    /* Merge Sort function */
    public static void sort(int[] a, int low, int high) 
    {
        int N = high - low;         
        if (N <= 1) 
            return; 
        int mid = low + N/2; 
        // recursively sort 
        sort(a, low, mid); 
        sort(a, mid, high); 
        // merge two sorted subarrays
        int[] temp = new int[N];
        int i = low, j = mid;
        for (int k = 0; k < N; k++) 
        {
            if (i == mid)  
                temp[k] = a[j++];
            else if (j == high) 
                temp[k] = a[i++];
            else if (a[j]<a[i]) 
                temp[k] = a[j++];
            else 
                temp[k] = a[i++];
        }    
        for (int k = 0; k < N; k++) 
            a[low + k] = temp[k];         
    }
    
    /** Quick sort function
     * @param integers
     * @param low
     * @param high **/
    public static void quickSort(int[] integers, int low, int high) 
    {
        int i = low;
        int j = high;
        int temp;
        int pivot = integers[(low + high) / 2];

        /** partition **/
        while (i <= j) 
        {
            while (integers[i] < pivot)
                i++;
            
            while (integers[j] > pivot)
                j--;
        
            if (i <= j) 
            {
                /** swap **/
                temp = integers[i];
                integers[i] = integers[j];
                integers[j] = temp;
                i++;
                j--;
            }
        }
        
        /** recursively sort lower half **/
        if (low < j)
            quickSort(integers, low, j);
        /** recursively sort upper half **/
        if (i < high)
            quickSort(integers, i, high);
    }
    
    

    
}
