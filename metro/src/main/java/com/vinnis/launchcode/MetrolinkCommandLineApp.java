package main.java.com.vinnis.launchcode;

/**
 * Created by omx on 5/20/2015.
 */
import main.java.com.vinnis.launchcode.dao.ArrivalTimeDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static java.util.Collections.*;


public class MetrolinkCommandLineApp {

    public static void main(String[] varArgs) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        MetrolinkCommandLineApp metrolinkCommandLineApp =
                (MetrolinkCommandLineApp) context.getBean("metrolinkCommandLineApp");
        metrolinkCommandLineApp.run();
    }

    private void run() {

        List<Metrolink_Stop> metroStops = metrolinkDao.getStops();

        for (Metrolink_Stop stop : metroStops) {
            appOutput.print(String.format("--- %s ---", stop.getStopName()));
        }
        ArrivalTimeDao arrival = new ArrivalTimeDao();
        arrival.setCurrentStop();
        String arrivalTime = arrival.getArrivalTime();
        appOutput.print(String.format("Next train arrives at: %s ---", arrivalTime));

    }

    private MetrolinkDao metrolinkDao;
    private AppOutput appOutput;

    public void setMetrolinkDao(MetrolinkDao metrolinkDao) {
        this.metrolinkDao = metrolinkDao;
    }

    public void setAppOutput(AppOutput appOutput) {
        this.appOutput = appOutput;
    }
}