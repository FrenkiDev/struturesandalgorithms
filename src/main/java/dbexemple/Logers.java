package dbexemple;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Logers {
    public static final Logger LOG_DB = LogManager.getLogger("LOG_DB");
    public static final Logger LOG_ERROR = LogManager.getLogger("LOG_ERROR");
    public static final Logger LOG_INFO = LogManager.getLogger(Logers.class);
}
