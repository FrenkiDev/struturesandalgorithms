package dbexemple.jdbc.connectiondatabase;

import dbexemple.Logers;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public abstract class ConnectDB {
    private String pathConfig = "src\\main\\resources\\dbConfig.properties";
    private String nameDrivers;
    private String user;
    private String password;
    private String url;

    private Connection connDB = null;

    public Connection getINSTANCE() {
        if (connDB == null) {
            try {
                creatConnectionDb();
            } catch (SQLException ex) {
                Logers.LOG_ERROR.error("DataBase " + nameDrivers + " " + this, ex);
                closeDB();
            }
        }
        return connDB;
    }

    public void closeDB() {
        try {
            if (!connDB.isClosed()){
                connDB.close();
                connDB = null;
            }
        } catch (SQLException ex) {
            Logers.LOG_ERROR.error("DataBase " + nameDrivers + " " + this, ex);
        }
        Logers.LOG_INFO.info("DataBase " + nameDrivers + " close.");
    }

    private Connection creatConnectionDb() throws SQLException {
        boolean success = false;
        filingValueConnection();
        String infoStr = String.format("Create connect DataBase - %s: ", this);

        try {
            Class.forName(nameDrivers);
            connDB = DriverManager.getConnection(url, user, password);
            success = true;
        } catch (ClassNotFoundException e) {
            Logers.LOG_ERROR.error("DataBase " + nameDrivers + " " + this, e);
        }

        Logers.LOG_DB.info(infoStr + "SUCCESS : " + success);
        return connDB;
    }

    protected abstract void filingValueConnection();

    protected void readingProterties(String path) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(path));
            this.setUrl(properties.getProperty("db_URL_" + nameDrivers));
            this.setUser(properties.getProperty("db_USER_" + nameDrivers));
            this.setPassword(properties.getProperty("db_PASSWORD_" + nameDrivers));
        } catch (IOException e) {
            Logers.LOG_DB.error(String.format("Error reading parametrs to file: %s", path));
        }
    }

    public String getNameDrivers() {
        return nameDrivers;
    }

    public void setNameDrivers(String nameDrivers) {
        this.nameDrivers = nameDrivers;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPathConfig() {
        return pathConfig;
    }

    public void setPathConfig(String pathConfig) {
        this.pathConfig = pathConfig;
    }

    @Override
    public String toString() {
        return "ConnectDB{" +
                ", nameDrivers='" + nameDrivers + '\'' +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
