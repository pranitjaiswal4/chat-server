/** Pranit Jaiswal
 * (ID: pxj6023) */
package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import model.User;

// Reference URL : https://www.java67.com/2015/08/how-to-load-data-from-csv-file-in-java.html

//Class to read and print the user log from the specified CSV File
public class CSVReaderInJava {

    public static List<User> users = new ArrayList<>();

    public static void main(String... args) {
        List<User> users = readUsersFromCSV(Constants.CSV_FILEPATH + "\\" + Constants.CSV_FILENAME);

        //Print all the users from CSV file
        for (User b : users) {
            System.out.println(b);
        }
    }

    //Method to read the user log from the specified CSV File
    public static List<User> readUsersFromCSV(String fileName) {
        
        //clear user list before reading the file
        users.clear();

        //get path for the filename
        Path pathToFile = Paths.get(fileName);

        // create an instance of BufferedReader
        // using try with resource, Java 7 feature to close resources
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {

            // read the first line from the text file
            String line = br.readLine();

            // loop until all lines are read
            while (line != null) {

                // use string.split to load a string array with the values from
                // each line of
                // the file, using a comma as the delimiter
                String[] attributes = line.split(",");

                User user = createUser(attributes);

                // adding user into ArrayList
                users.add(user);

                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine();
            }

        } catch (IOException ioe) {
            //ioe.printStackTrace();
        }

        return users;
    }

    //Method to create new user in User Model after reading data from CSV
    private static User createUser(String[] metadata) {
        String username = metadata[0];          //add 0th element to username
        String timestamp = metadata[1];         //add 1st element to timestamp
        String status = metadata[2];            //add 2nd element to status

        // remove if any unwanted double qoutes are found
        username = username.replaceAll("\"", "");
        timestamp = timestamp.replaceAll("\"", "");
        status = status.replaceAll("\"", "");
        
        // create and return user of this metadata
        return new User(username, timestamp, status);
    }
    
}
