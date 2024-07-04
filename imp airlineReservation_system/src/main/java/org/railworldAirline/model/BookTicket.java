package org.railworldAirline.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BookTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public  long ticketId;
    public String Source;

    public String destination;

    public String date;

    public String  flightClass;

    public String returnDate;
    public int member;


    public BookTicket() {
        super();
    }

    public BookTicket( String source, String destination, String date, String flightClass, int member) {

        Source = source;
        this.destination = destination;
        this.date = date;
        this.flightClass = flightClass;
        this.member = member;
    }


    public BookTicket( String source, String destination, String date, String flightClass, String returnDate, int member) {

        Source = source;
        this.destination = destination;
        this.date = date;
        this.flightClass = flightClass;
        this.returnDate = returnDate;
        this.member = member;
    }

    public long getTicketId() {
        return ticketId;
    }

    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        Source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(String flightClass) {
        this.flightClass = flightClass;
    }

    public int getMember() {
        return member;
    }

    public void setMember(int member) {
        this.member = member;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "BookTicket{" +
                "ticketId=" + ticketId +
                ", Source='" + Source + '\'' +
                ", destination='" + destination + '\'' +
                ", date='" + date + '\'' +
                ", flightClass='" + flightClass + '\'' +
                ", returnDate='" + returnDate + '\'' +
                ", member=" + member +
                '}';
    }
}
