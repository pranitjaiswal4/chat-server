/** Pranit Jaiswal
 * (ID: pxj6023) */
package utils;

import java.util.ArrayList;

// Class to store common constants/values used throughout the application
public class Constants { 
    
    public static String MESSAGE_SPLITTER_KEYWORD = "PJPJPJPJ";
    
    public static int PORT_NUMBER = 9999;
    public static String SERVER_NAME = "localhost";
    public static String CSV_FILEPATH = "C:\\Users\\Public\\MessageServer\\";
    //public static String CSV_FILEPATH = "E:\\MessageServer\\";
    public static String CSV_FILENAME = "usernames.CSV";

    public static String DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";
    public static String DATE_FORMAT_FULL_DATE_TIME = "yyyy-MM-dd HH:mm:ss";

    public static String MESSAGE_TO_UPDATE_USER_LIST = "update_user_list";
    
    public static String MESSAGE_TO_CLOSE_CLIENT = "close_client";
    public static String MESSAGE_TO_CLOSE_ALL_CONNECTED_CLIENTS = "close_all_connected_clients";
    public static String MESSAGE_TO_CLOSE_SERVER = "close_server";
    
    // Interface to store Strings
    // (In interface, all variables are final. These variables never change their values)
    public interface STATUS {
        String ONLINE = "Online";
        String OFFLINE = "Offline";
    }

}
