package main.java.com.vinnis.launchcode.dao;

import main.java.com.vinnis.launchcode.AppOutput;
import main.java.com.vinnis.launchcode.MetrolinkDao;
import main.java.com.vinnis.launchcode.Metrolink_Stop;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;


public class ArrivalTimeDao {

    //public static final String JDBC_SQLITE_METROLINK_DB = "jdbc:sqlite:metrolink.db";
    public static final String JDBC_SQLITE_METROLINK_DB = "jdbc:sqlite:C:\\cygwin64\\home\\omx\\java\\metro\\src\\main\\resources\\metrolink.db";
    public static final String ORG_SQLITE_JDBC = "org.sqlite.JDBC";

    Scanner in = new Scanner(System.in);
    private  String currentStop;

    public void setCurrentStop() {
    System.out.print("\nplease enter you cuurrent Metrolink station ");
    currentStop = in.nextLine();
    }

    private AppOutput appOutput;

    public String getArrivalTime() {
        //getting current date time using calendar class
        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        Calendar calobj = Calendar.getInstance();
        String currentTime = (df.format(calobj.getTime()));


        System.out.print("Fetching next arrival time...");
        try (Connection connection = getConnection();) {
            String sql = "SELECT arrival_time FROM metrolink_stops WHERE stop_name like ? AND arrival_time >= ? ORDER BY arrival_time LIMIT 1";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + currentStop + "%");
            preparedStatement.setString(2, currentTime);


            ResultSet resultSet = preparedStatement.executeQuery();


            String arrival_time = "hhmmss";
            while (resultSet.next()) {

                arrival_time = resultSet.getString("arrival_time");

            }

            return arrival_time;
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