package main.java.com.vinnis.launchcode.dao;

import main.java.com.vinnis.launchcode.AppOutput;
import main.java.com.vinnis.launchcode.MetrolinkDao;
import main.java.com.vinnis.launchcode.Metrolink_Stop;
import main.java.com.vinnis.launchcode.Stop;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class SqliteJDBCDao implements MetrolinkDao {

    //public static final String JDBC_SQLITE_METROLINK_DB = "jdbc:sqlite:metrolink.db";
    public static final String JDBC_SQLITE_METROLINK_DB = "jdbc:sqlite:C:\\cygwin64\\home\\omx\\java\\metro\\src\\main\\resources\\metrolink.db";
    public static final String ORG_SQLITE_JDBC = "org.sqlite.JDBC";

    private AppOutput appOutput;

    public List<Metrolink_Stop> getStops() {
        appOutput.print("Fetching metrolink stations...");
        try (Connection connection = getConnection();) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM metrolink_stops ORDER BY stop_name");

            ResultSet resultSet = preparedStatement.executeQuery();
            List<Metrolink_Stop> stops = new ArrayList<Metrolink_Stop>();

            String holdStopName = "";
            String nextStop = "";
            while (resultSet.next()) {
                Metrolink_Stop stop = new Metrolink_Stop();
                nextStop = resultSet.getString("stop_name");
                if (!nextStop.equals(holdStopName)) {
                    stop.setStopName(resultSet.getString("stop_name"));
                    stop.setStopDescription("Metrolink Station");
                    stops.add(stop);
                }
                holdStopName = nextStop;
            }

            return stops;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());

        }
    }

    private static Connection getConnection() throws SQLException {
        try {
            Class.forName(ORG_SQLITE_JDBC);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Unable to find class for loading the database", e);
        }
        return DriverManager.getConnection(JDBC_SQLITE_METROLINK_DB);
    }

    public void setAppOutput(AppOutput appOutput) {
        this.appOutput = appOutput;
    }
}