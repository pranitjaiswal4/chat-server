/** Pranit Jaiswal 
(ID: pxj6023) */

package model;

// Reference URL : https://www.java67.com/2015/08/how-to-load-data-from-csv-file-in-java.html

// Create a User Model class to store all user objects
public class User {
    private String username;
    private String timestamp;
    private String status;
    
    // Constructor to initialize a user with the specified attributes
    public User(String username, String timestamp, String status) {
        this.username = username;
        this.timestamp = timestamp;
        this.status = status;
    }

    // Method to get username for a particular user object
    public String getUsername() {
        return username;
    }

    // Method to set username for a particular user object
    public void setUsername(String name) {
        this.username = name;
    }

    // Method to get timestamp for a particular user object
    public String getTimestamp() {
        return timestamp;
    }

    // Method to set timestamp for a particular user object
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    // Method to get status for a particular user object
    public String getStatus() {
        return status;
    }

    // Method to set status for a particular user object
    public void setStatus(String status) {
        this.status = status;
    }

    // Method to print the obtained data (JUST FOR TESTING PURPOSE)
    @Override
    public String toString() {
        return "User [username=" + username + ", timestamp=" + timestamp + ", status=" + status+ "]";
    }

}
