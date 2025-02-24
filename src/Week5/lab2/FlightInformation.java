package Week5.lab2;

import java.time.LocalDateTime;

class FlightInformation {
    private String flightNumber;
    private String seatNumber;
    private LocalDateTime timePickUp;

    public FlightInformation(String flightNumber, String seatNumber, LocalDateTime timePickUp) {
        this.flightNumber = flightNumber;
        this.seatNumber = seatNumber;
        this.timePickUp = timePickUp;
    }

    public FlightInformation() {
        this.flightNumber = "";
        this.seatNumber = "";
        this.timePickUp = LocalDateTime.now();
    }

    public String getFlightNumber() { return flightNumber; }
    public void setFlightNumber(String flightNumber) { this.flightNumber = flightNumber; }

    public String getSeatNumber() { return seatNumber; }
    public void setSeatNumber(String seatNumber) { this.seatNumber = seatNumber; }

    public LocalDateTime getTimePickUp() { return timePickUp; }
    public void setTimePickUp(LocalDateTime timePickUp) { this.timePickUp = timePickUp; }

    @Override
    public String toString() {
        return flightNumber + " - " + seatNumber + " - " + timePickUp;
    }
}
