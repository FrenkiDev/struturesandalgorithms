package dbexemple;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Logers {
    public static final Logger LOG_DB = LogManager.getLogger("LOG_DB");
    public static final Logger LOG_ERROR = LogManager.getLogger("LOG_ERROR");
    public static final Logger LOG_INFO = LogManager.getLogger(Logers.class);

    public static void addPASS(String message){
        LOG_DB.info(String.format("Entry added to the database: %s", message));
    }

    public static void addFALSE(String message, String exception){
       LOG_ERROR.error(String.format("Error while adding record to the database: %s \n%s\n", message, exception));
       LOG_DB.error(String.format("Entry added to the database: %s", message));
    }

    public static void getAllPASS(String message){
        LOG_DB.info(String.format("The request select all %s; was successful",message));
    }

    public static void getAllFAIL(String message, String exception){
        LOG_ERROR.error(String.format("Request %s failed\n%s",message, exception));
    }

    public static void getByIdPASS(String id, String message){
        LOG_DB.info(String.format("Selected by ID = %s\n%s", id, message));
    }

    public static void getByIdFAIL(String id, String message){
        LOG_ERROR.error(String.format("Request select by ID = %s failed\n%s",id, message));
    }

    public static void updatePASS(String message){
        LOG_DB.info(String.format("Update by ID = %s", message));
    }

    public static void updateFAIL(String message, String exception){
        LOG_ERROR.error(String.format("Request update failed\n%s\n%s",message, exception));
    }

    public static void removeRASS(String message){
        LOG_DB.info(String.format("DELETE by ID = %s", message));
    }

    public static void removeFAIL(String message, String exception){
        LOG_ERROR.error(String.format("Request failed\n%s\n%s", message, exception));
    }
}
