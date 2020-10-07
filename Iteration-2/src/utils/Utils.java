/** Pranit Jaiswal
 * (ID: pxj6023) */
package utils;

import com.opencsv.CSVWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Class to store useful methods which are going to be used throughout the application.
public class Utils {

    // Method to check whether the given String contains only alphabates
    public static boolean isAlpha(String s) {
        return s != null && s.matches("^[a-zA-Z]*$");   // Regular expression for alphabates from a-z and A-Z
    }

    //  Method to create specific directory and csv file if not present at the specified path.
    //  Reference URL : https://stackoverflow.com/questions/45632147/can-not-create-file-in-specific-directory-in-java-the-system-cannot-find-the-pa
    public static void createFilePathForUsernames() {
        String filename = Constants.CSV_FILENAME;
        File file = null;

        // Check if directory exists
        File directory = new File(Constants.CSV_FILEPATH);
        if (directory.exists() && directory.isDirectory()) {

            // Create your file
            file = new File(directory + "\\" + filename);
        } else {
            // Create directory
            directory = new File(Constants.CSV_FILEPATH);

            if (directory.mkdir()) {
                // System.out.println("Directory Created");

                // Create your file
                file = new File(directory + "\\" + filename);

            } else {
                // System.out.println("Directory is not created");
            }
        }

        // Set FileWriter to null
        FileWriter writer = null;

        try {
            writer = new FileWriter(file, true);    // Initialize new FileWriter object (true: it will overwrite the file)
            writer.close();                         // Close FileWriter object
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    //  Method to write Header for CSV file
    //  Reference URL : https://www.geeksforgeeks.org/writing-a-csv-file-in-java-using-opencsv/
    public static void writeHeaderDataToCSV() {
        // first create file object for file placed at location 
        // specified by filepath 
        File file = new File(Constants.CSV_FILEPATH + "\\" + Constants.CSV_FILENAME);
        try {
            // create FileWriter object with file as parameter 
            FileWriter outputfile = new FileWriter(file, true);

            // create CSVWriter object filewriter object as parameter 
            CSVWriter writer = new CSVWriter(outputfile);

            // adding header to csv 
            String[] header = {"Username", "Timestamp", "Status", "MessageQueue"};
            writer.writeNext(header);

            // closing writer connection 
            writer.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block 
            e.printStackTrace();
        }
    }

    //  Method to append data to nextLine for CSV file
    //  Reference URL : https://www.geeksforgeeks.org/writing-a-csv-file-in-java-using-opencsv/
    public static void appendDataToNextLineCSV(String username, String datetime, String status, String messageQueue) {
        // first create file object for file placed at location 
        // specified by filepath 
        File file = new File(Constants.CSV_FILEPATH + "\\" + Constants.CSV_FILENAME);
        try {
            // create FileWriter object with file as parameter 
            FileWriter outputfile = new FileWriter(file, true);

            // create CSVWriter object filewriter object as parameter 
            CSVWriter writer = new CSVWriter(outputfile);

            // add data to csv 
            String[] data = {username, datetime, status, messageQueue};
            writer.writeNext(data);

            // closing writer connection 
            writer.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block 
            e.printStackTrace();
        }
    }

    //  Method to owerwriting the whole CSV file with a single line
    //  Reference URL : https://www.geeksforgeeks.org/writing-a-csv-file-in-java-using-opencsv/
    public static void writeDataToNextLineCSV(String username, String datetime, String status, String messageQueue) {
        // first create file object for file placed at location 
        // specified by filepath 
        File file = new File(Constants.CSV_FILEPATH + "\\" + Constants.CSV_FILENAME);
        try {
            // create FileWriter object with file as parameter 
            FileWriter outputfile = new FileWriter(file, false);

            // create CSVWriter object filewriter object as parameter 
            CSVWriter writer = new CSVWriter(outputfile);

            // add data to csv 
            String[] data = {username, datetime, status, messageQueue};
            writer.writeNext(data);

            // closing writer connection 
            writer.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block 
            e.printStackTrace();
        }
    }

    //  Method to overwrite the whole data in CSV file at once with multiple lines
    //  Reference URL : https://www.geeksforgeeks.org/writing-a-csv-file-in-java-using-opencsv/
    public static void writeDataAtOnce(List<String[]> users) {

        // first create file object for file placed at location 
        // specified by filepath 
        File file = new File(Constants.CSV_FILEPATH + "\\" + Constants.CSV_FILENAME);

        try {
            // create FileWriter object with file as parameter 
            FileWriter outputfile = new FileWriter(file, false);

            // create CSVWriter object filewriter object as parameter 
            CSVWriter writer = new CSVWriter(outputfile);
            writer.writeAll(users);

            // closing writer connection 
            writer.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block 
            e.printStackTrace();
        }
    }

    // Method to create a date from unix timestamp with specified date format
    // Reference : This code is taken from one of my previous android application project
    public static String getDateAndTimeFromTimeStamp(long timeStamp, String arg_date_format) {
        java.sql.Timestamp timestamp = new java.sql.Timestamp(timeStamp);       //create new timestamp variable
        Date date = new Date(timeStamp);                                        //create new date using timestamp
        DateFormat dateFormat = new SimpleDateFormat(arg_date_format);          //create new date format using specified date format
        return dateFormat.format(date);                                         //return new date with the given format
    }

}
