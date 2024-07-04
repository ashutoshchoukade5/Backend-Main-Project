package org.railworldAirline.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long flightNumber;


    public int flightPrice;


    public String flightFrom;


    public String flightTo;


    public String departureTime;


    public String arrivalTime;

    public String date ;

    public Flight() {
        super();
    }

    public Flight(long flightNumber, int price, String from, String to, String departureTime, String arrivalTime, String date) {
        this.flightNumber = flightNumber;
        this.flightPrice = price;
        this.flightFrom = from;
        this.flightTo = to;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.date = date;
    }


    public long getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(long flightNumber) {
        this.flightNumber = flightNumber;
    }

    public int getPrice() {
        return flightPrice;
    }

    public void setPrice(int price) {
        this.flightPrice = price;
    }

    public String getFrom() {
        return flightFrom;
    }

    public void setFrom(String from) {
        this.flightFrom = from;
    }

    public String getTo() {
        return flightTo;
    }

    public void setTo(String to) {
        this.flightTo = to;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    // Constructor and other methods remain unchanged

      /*  public void setDepartureTimeFromInput(String timeString) {

            try {
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                java.util.Date utilDate = sdf.parse(timeString);
                this.departureTime = new Time(utilDate.getTime());
            } catch (ParseException e) {
                System.out.println("Invalid time format. Please enter time in HH:mm:ss format.");
                // Optionally handle the error or retry
            }
        }

        public void setArrivalTimeFromInput(String timeString) {

            try {
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                java.util.Date utilDate = sdf.parse(timeString);
                this.arrivalTime = new Time(utilDate.getTime());
            } catch (ParseException e) {
                System.out.println("Invalid time format. Please enter time in HH:mm:ss format.");
                // Optionally handle the error or retry
            }
        }

        public void setDateFromInput(String dateString) {

            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                this.date = sdf.parse(dateString);
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please enter date in dd-MM-yyyy format.");
                // Optionally handle the error or retry
            }
        }*/


    @Override
    public String toString() {
        return "Flight{" +
                "flightNumber='" + flightNumber + '\'' +
                ", price=" + flightPrice +
                ", from='" + flightFrom + '\'' +
                ", to='" + flightTo + '\'' +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", date=" + date +
                '}';
    }

}
