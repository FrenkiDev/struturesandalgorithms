package dbexemple;

public class ConnH2DB extends ConnectDB {

    @Override
    protected void filingValueConnection() {
        setNameDrivers("org.h2.Driver");
        readingProterties(getPathConfig());
    }
}
