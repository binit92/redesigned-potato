import sun.rmi.runtime.Log;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Util {

    private static final String PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";

    public static  void log(String classname,String message){
        log(classname, message, "info");
    }

    public static void log(String classname,String message, String type){
        try{
            // configure the logger
            Logger logger = Logger.getLogger(classname);
            FileHandler fH = new FileHandler("risk.log");

            logger.addHandler(fH);

            // configure simple format
            SimpleFormatter sf = new SimpleFormatter();
            fH.setFormatter(sf);

            //prepend date into the log message
            String datetime = new SimpleDateFormat(PATTERN).format(
                    new Date(System.currentTimeMillis()));

            //log messages into file
            if("error".equalsIgnoreCase(type)){
                logger.severe(datetime + " " + message);
            }else {
                // everything is info log be default
                logger.info(datetime + " " + message);
            }


        }catch (IOException io){
            io.printStackTrace();
        }
    }

    public static void logError(String classname, String message){

    }
}
